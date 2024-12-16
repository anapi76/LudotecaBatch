DROP TABLE category IF EXISTS;

CREATE TABLE category  (
category_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
name VARCHAR(20),
type VARCHAR(20),
characteristics VARCHAR(30)
);

CREATE TABLE game (
game_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
title VARCHAR(100),
age int,
stock int
);

INSERT INTO game(title, age, stock) VALUES ('On Mars', 14, 1);
INSERT INTO game(title, age, stock) VALUES ('Aventureros al tren', 8, 3);
INSERT INTO game(title, age, stock) VALUES ('1920: Wall Street', 12, 1);
INSERT INTO game(title, age, stock) VALUES ('Barrage', 14, 0);
INSERT INTO game(title, age, stock) VALUES ('Los viajes de Marco Polo', 12, 1);
INSERT INTO game(title, age, stock) VALUES ('Azul', 8, 0);