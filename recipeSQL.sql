-- Create the database (optional, depending on your SQL setup)
CREATE DATABASE RecipeDB;

-- Use the database
USE RecipeDB;

-- Create the recipes table
CREATE TABLE recipes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    ingredients TEXT NOT NULL,
    instructions TEXT NOT NULL,
    cuisine VARCHAR(100),
    tags VARCHAR(255)
);

-- Insert sample recipes
-- Assuming the database and table already exist from previous SQL script

-- Insert sample recipes (if not already done)
INSERT INTO recipes (name, ingredients, instructions, cuisine, tags) VALUES
('Pasta', 'pasta, garlic, olive oil, cheese', 'Boil pasta and mix with garlic, oil, and cheese', 'Italian', 'Lunch, Cheesy'),
('Omelette', 'egg, salt, pepper', 'Mix ingredients and cook in a pan', 'American', 'Breakfast, Healthy'),
('Salad', 'lettuce, tomato, cucumber', 'Chop vegetables and toss together', 'American', 'Healthy, Lunch'),
('Spaghetti Bolognese', 'spaghetti, ground beef, tomato sauce, onion, garlic', 'Cook pasta. Sauté onion and garlic, add ground beef, then tomato sauce. Simmer and serve.', 'Italian', 'Dinner'),
('Vegetable Stir Fry', 'broccoli, carrot, bell pepper, soy sauce, garlic', 'Stir fry vegetables in a pan with garlic and soy sauce.', 'Chinese', 'Vegetarian, Dinner'),
('Chicken Salad', 'chicken breast, lettuce, tomato, cucumber, olive oil, lemon juice', 'Grill chicken, chop vegetables, and mix with dressing.', 'American', 'Healthy, Lunch'),
('Pancakes', 'flour, milk, egg, butter, sugar', 'Mix ingredients and cook on a griddle.', 'American', 'Breakfast, Sweet'),
('Biryani', 'rice, water, masalas, cloves, salt, pepper, cinnamon stick, bay leaves, veggies, chicken/proteins', 'Cook spiced meat/veggies with yogurt and masala, layer with half-cooked basmati rice, drizzle saffron milk and ghee, then steam on low heat.', 'Indian', 'Lunch, Dinner'),
('Pizza', 'dough, sugar, salt, warm water, cheese, toppings, olive oil, pizza sauce, dry yeast', 'Prepare dough, spread pizza sauce, add cheese and toppings, and bake at 475°F (245°C) for 12-15 minutes.', 'Italian', 'Lunch, Cheesy, Special');

select * from recipes;
drop table recipes;