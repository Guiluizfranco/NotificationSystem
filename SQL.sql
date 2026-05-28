CREATE DATABASE NotificationSystem;

USE NotificationSystem;

CREATE TABLE User(
id INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100),
email VARCHAR(100) UNIQUE,
senha VARCHAR(100)
);

CREATE TABLE Notification(
id INT AUTO_INCREMENT,
titulo VARCHAR(100),
mensagem VARCHAR(100),
lida BOOLEAN,
sender_id INT,
receiver_id Int,

FOREIGN KEY (sender_id) REFERENCES Users(id),
FOREIGN KEY (receiver_id) REFERENCES Users(id)
);