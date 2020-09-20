CREATE USER 'Lazaros'@'%' IDENTIFIED BY 'lazaros';
GRANT ALL ON items.* TO 'Lazaros'@'%';

USE items;

CREATE TABLE MyGuests (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
firstname VARCHAR(30) NOT NULL,
lastname VARCHAR(30) NOT NULL,
email VARCHAR(50));
