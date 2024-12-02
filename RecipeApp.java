import java.sql.*;
import java.util.*;

public class RecipeApp {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/RecipeDB";
    private static final String DB_USER = "root"; // Replace with your username if different
    private static final String DB_PASSWORD = "sql123";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            System.out.println("Connected to the database successfully!");

            while (true) {
                System.out.println("\n--- Recipe App ---");
                System.out.println("1. Recommend by ingredient");
                System.out.println("2. Display all recipes");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1: {
                        System.out.print("Enter ingredient: ");
                        String ingredient = scanner.nextLine();
                        recommendByIngredient(conn, ingredient);
                        break;
                    }
                    case 2: {
                        displayAllRecipes(conn);
                        break;
                    }
                    case 3: {
                        System.out.println("Goodbye!");
                        return;
                    }
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
        }
    }

    // Method to recommend recipes based on a single ingredient
    private static void recommendByIngredient(Connection conn, String ingredient) {
        String query = "SELECT * FROM recipes WHERE ingredients LIKE ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, "%" + ingredient + "%"); // Use LIKE to find the ingredient

            try (ResultSet rs = stmt.executeQuery()) {
                boolean found = false;
                while (rs.next()) {
                    System.out.println("\nRecipe: " + rs.getString("name"));
                    System.out.println("Ingredients: " + rs.getString("ingredients"));
                    System.out.println("Instructions: " + rs.getString("instructions"));
                    System.out.println("Cuisine: " + rs.getString("cuisine"));
                    System.out.println("Tags: " + rs.getString("tags"));
                    System.out.println("------------------------------------------------");
                    found = true;
                }

                if (!found) {
                    System.out.println("No recipes found with ingredient: " + ingredient);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching recipes: " + e.getMessage());
        }
    }

    // Method to display all recipes
    private static void displayAllRecipes(Connection conn) {
        String query = "SELECT * FROM recipes";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.println("\nRecipe: " + rs.getString("name"));
                System.out.println("Ingredients: " + rs.getString("ingredients"));
                System.out.println("Instructions: " + rs.getString("instructions"));
                System.out.println("Cuisine: " + rs.getString("cuisine"));
                System.out.println("Tags: " + rs.getString("tags"));
                System.out.println("------------------------------------------------");
            }
        } catch (SQLException e) {
            System.err.println("Error fetching recipes: " + e.getMessage());
        }
    }
}
