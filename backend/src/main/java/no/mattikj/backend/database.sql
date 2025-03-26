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
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    link VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS files
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    file_name  VARCHAR(255) NOT NULL,
    file_path  VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert dummy data into games table
INSERT INTO games (name, description, version, price, icon_id, screenshot, link)
VALUES ('Party Poopers', 'Fun 4-player party game', '1.1.0', 0, 1, '7', 'PartyPoopersWin64.zip'),
       ('Paths', 'Amateur student project game made with Java','1.0.0', 0, 2, '', '');

INSERT INTO tools (name, description, version, price, icon_id, screenshot, link)
VALUES ('WWS', 'A warehouse workflow simulator', '1.0.0', 0, 3, '2', ''),
       ('GitLocker', 'A simple tool for managing git keys', '1.0.0', 0, 3, '2', '');


-- Insert dummy data into icons table
INSERT INTO icons (name, link)
VALUES ('Icon 1', 'http://example.com/icon1.png'),
       ('Icon 2', 'http://example.com/icon2.png'),
       ('Icon 3', 'http://example.com/icon3.png');

-- Insert dummy data into projects table

INSERT INTO files (file_name, file_path)
VALUES ('pause.svg', '/home/mattikjellstadli/Downloads/shelstad/pause.svg'),
         ('PartyPoopers-win.zip', '/home/mattikjellstadli/Downloads/shelstad/PartyPoopersWin64.zip');