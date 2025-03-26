CREATE DATABASE IF NOT EXISTS shelstad;

USE shelstad;

CREATE TABLE IF NOT EXISTS games
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    version     VARCHAR(255) NOT NULL,
    description TEXT,
    icon_id     INT          NOT NULL,
    screenshot  TEXT,
    price       DECIMAL(10, 2),
    link        VARCHAR(255),
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS tools
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    version     VARCHAR(255) NOT NULL,
    description TEXT,
    icon_id     INT          NOT NULL,
    screenshot  TEXT,
    price       DECIMAL(10, 2),
    link        VARCHAR(255),
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE IF NOT EXISTS icons
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    file_name  VARCHAR(255) NOT NULL,
    file_path  VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS files
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    file_name  VARCHAR(255) NOT NULL,
    file_path  VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert dummy data into games table
INSERT INTO games (name, description, version, price, icon_id, screenshot, link, created_at)
VALUES ('Party Poopers', '**Party Poopers**

Party Poopers features a collection of engaging minigames designed for multiplayer fun. Each minigame is easy to grasp yet competitive, offering a blend of skill and light-hearted enjoyment for friends. The controls are intuitive, primarily utilizing the WASD keys and a jump function, allowing the gameplay to shine.

This game served as the final project for the Game Development course at NTNU in autumn 2024.

**Version History:**

- 1.0.0: Initial game release as the exam delivery candidate.
- 1.0.1: Minor map adjustments in the "Crane Climbers" and "Pole Thrusters" mini games.
- 1.1.0: Removed Unity Relay services. Players must now use IP to play together.

Please note, the project is no longer under active development, and future bug fixes are not planned. Despite this, Party Poopers should still be playable.

**Install instructions**

1. Download the appropriate build for your platform.
2. Choose the version that matches your operating system.
3. Run the executable file.
4. After downloading, locate the file and double-click it to start the game (No installation required).

**Note about potential warnings:**

Some systems might flag the file as a potential risk. This is a common false positive and can be safely ignored.

', '1.1.0', 0, 1, '7', 'https://www.youtube.com/embed/FPyl7lJiniE','2024-12-13 00:00:00'),
       ('Paths', '
# Paths

Paths is a robust game engine designed specifically for crafting choice-based and interactive storytelling experiences.

## Installation

Getting started with Paths is a breeze. Simply follow these steps:

1. Download the project ZIP file.
2. Open it in an Integrated Development Environment (IDE) that supports Maven.
3. Clean and compile the project.
4. Use `JavaFX:Run` to start the application.

Now you''re ready to dive into the world of interactive storytelling!

## 2023 Exam
Paths was originally developed as part of a Computer Science exam assignment at NTNU in May 2023. It''s a testament to the project''s academic roots and commitment to excellence in interactive storytelling.
', '1.0.0', 0, 2, '3', '', '2023-06-01 00:00:00');

INSERT INTO tools (name, description, version, price, icon_id, screenshot, link)
VALUES ('WWS', 'A warehouse workflow simulator', '1.0.0', 0, 3, '2', ''),
       ('GitLocker', 'A simple tool for managing git keys', '1.0.0', 0, 3, '2', '');


-- Insert dummy data into icons table
INSERT INTO icons (file_name, file_path)
VALUES ('pause.svg', '/home/mattikjellstadli/Downloads/shelstad/pause.svg');
-- Insert dummy data into projects table

INSERT INTO files (file_name, file_path)
VALUES ('pause.svg', '/home/mattikjellstadli/Downloads/shelstad/pause.svg');