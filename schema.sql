-- Create the users table
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    age INT,
    gender VARCHAR(50)
);

-- Create the activity table
CREATE TABLE activity (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id),
    date DATE NOT NULL,
    steps INT,
    calories_burned INT,
    distance FLOAT,
    active_time INT -- in minutes
);

-- Create the workout table
CREATE TABLE workout (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id),
    date DATE NOT NULL,
    title VARCHAR(255),
    type VARCHAR(255),
    duration INT, -- in minutes
    calories_burned INT,
    details TEXT
);

-- Create the nutrition table
CREATE TABLE nutrition (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id),
    date DATE NOT NULL,
    calories_consumed INT,
    carbohydrates_percentage FLOAT,
    proteins_percentage FLOAT,
    fats_percentage FLOAT
);

-- Create the meal table
CREATE TABLE meal (
    id SERIAL PRIMARY KEY,
    nutrition_id INT REFERENCES nutrition(id),
    type VARCHAR(255), -- e.g., breakfast, lunch, dinner
    name VARCHAR(255),
    description TEXT,
    calories INT
);

-- Create the water_intake table
CREATE TABLE water_intake (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id),
    date DATE NOT NULL,
    amount INT -- in ml
);

-- Create the sleep table
CREATE TABLE sleep (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id),
    date DATE NOT NULL,
    duration INT, -- in minutes
    quality INT, -- percentage
    bed_time TIME,
    wakeup_time TIME,
    awakenings INT
);

-- Create the reminder table
CREATE TABLE reminder (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id),
    title VARCHAR(255),
    description TEXT,
    due_time TIMESTAMP,
    completed BOOLEAN DEFAULT FALSE,
    recurrence VARCHAR(50) -- e.g., daily, weekly
);
