#1. Create Tables

CREATE TABLE `employees` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(45) NOT NULL,
    last_name VARCHAR(45) NOT NULL
);

CREATE TABLE `categories` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL
);

CREATE TABLE `products` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    category_id INT NOT NULL
);

#2. Insert Data in Tables

INSERT INTO `employees` (`first_name`, `last_name`) VALUES ('a', 'a');
INSERT INTO `employees` (`first_name`, `last_name`) VALUES ('b', 'b');
INSERT INTO `employees` (`first_name`, `last_name`) VALUES ('c', 'c');

#3. Alter Tables

ALTER TABLE `employees` 
ADD COLUMN `middle_name` VARCHAR(45) NOT NULL AFTER `last_name`;

#4. Adding Constraints

ALTER TABLE `products` 
ADD CONSTRAINT `my_fk`
FOREIGN KEY (`category_id`)
REFERENCES `categories` (`id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

#5. Modifying Columns

ALTER TABLE `employees` 
CHANGE COLUMN `middle_name` `middle_name` VARCHAR(100) NOT NULL ;