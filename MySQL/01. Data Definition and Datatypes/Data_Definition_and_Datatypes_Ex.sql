#02. Create Tables

CREATE TABLE `minions` (
    `id` INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `age` INT(11) NOT NULL
);

CREATE TABLE `towns` (
    `id` INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL
);


#03. Alter Minions Table

ALTER TABLE `minions`
ADD COLUMN `town_id` INT(11) AFTER `age`;
ALTER TABLE `minions`
ADD CONSTRAINT `my_fk`
	FOREIGN KEY (`town_id`)
    REFERENCES `towns` (`id`)
	ON DELETE NO ACTION
    ON UPDATE NO ACTION;


#04. Insert Records in Both Tables

INSERT INTO `towns` (`id`,`name`) VALUES (1, 'Sofia');
INSERT INTO `towns` (`id`,`name`) VALUES (2, 'Plovdiv');
INSERT INTO `towns` (`id`,`name`) VALUES (3, 'Varna');
INSERT INTO `minions` (`id`, `name`, `age`, `town_id`) VALUES (1, 'Kevin', 22, 1);
INSERT INTO `minions` (`id`, `name`, `age`, `town_id`) VALUES (2, 'Bob', 15, 3);
INSERT INTO `minions` (`id`, `name`, `age`, `town_id`) VALUES (3, 'Steward', null, 2);


#05. Truncate Table Minions

TRUNCATE `minions`;

#06. Drop All Tables

DROP TABLE `minions`;
DROP TABLE `towns`;


#07. Create Table People

CREATE TABLE `people` (
    `id` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(200) NOT NULL,
    `picture` BLOB(2048),
    `height` FLOAT(3 , 2 ),
    `weight` FLOAT(5 , 2 ),
    `gender` ENUM('f', 'm') NOT NULL,
    `birthdate` DATE NOT NULL,
    `biography` TEXT
);


INSERT INTO `people` (`name`, `picture` , `height`, `weight`, `gender`, `birthdate`, `biography`)
VALUES
('A', NULL, '1.23', '1.23', 'f', '2018-01-08', 'Lorem'),
('A', NULL, '1.23', '1.23', 'f', '2018-01-08', 'Lorem'),
('A', NULL, '1.23', '1.23', 'f', '2018-01-08', 'Lorem'),
('A', NULL, '1.23', '1.23', 'f', '2018-01-08', 'Lorem'),
('A', NULL, '1.23', '1.23', 'f', '2018-01-08', 'Lorem');


#08. Create Table Users

CREATE TABLE `users`(
`id` INT(19) PRIMARY KEY AUTO_INCREMENT,
`username` CHAR(30) NOT NULL,
`password` CHAR(26) NOT NULL,
`profile_picture` BLOB(921600),
`last_login_time` DATETIME NOT NULL,
`is_deleted` BOOL
);

INSERT INTO `users` (`username`,`password`, `last_login_time`,  `is_deleted` )
VALUE
('A', '123','2018-05-01 10:45:45', false),
('B', '123','2018-05-01 10:45:45', false),
('C', '123','2018-05-01 10:45:45', false),
('D', '123','2018-05-01 10:45:45', false),
('E', '123','2018-05-01 10:45:45', false);


#09. Change Primary Key

ALTER TABLE `users`
MODIFY COLUMN `id` INT(19);

ALTER TABLE `users`
DROP PRIMARY KEY;

ALTER TABLE `users`
ADD PRIMARY KEY (`id`, `username`);


#10. Set Default Value of a Field

ALTER TABLE `users` 
CHANGE COLUMN `last_login_time` `last_login_time` DATETIME NOT NULL DEFAULT now() ;


#11. Set Unique Field

ALTER TABLE `users`
	DROP PRIMARY KEY,
	ADD CONSTRAINT PRIMARY KEY (`id`),
	ADD CONSTRAINT UNIQUE (`username`);


#12. Movies Database

CREATE TABLE `directors` (
    `id` INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `director_name` VARCHAR(45) NOT NULL,
    `notes` TEXT
);
   
CREATE TABLE `genres` (
    `id` INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `genre_name` VARCHAR(45) NOT NULL,
    `notes` TEXT
);
   
CREATE TABLE `categories` (
`id` INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
`category_name` VARCHAR(45) NOT NULL,
`notes` TEXT);

CREATE TABLE `movies` (
    `id` INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `title` VARCHAR(45) NOT NULL,
    `director_id` INT UNSIGNED NOT NULL,
    `copyright_year` YEAR NOT NULL,
    `length` TIME NOT NULL,
    `genre_id` INT UNSIGNED NOT NULL,
    `category_id` INT UNSIGNED NOT NULL,
    `rating` DOUBLE NOT NULL DEFAULT 0,
    `notes` TEXT
);

     
INSERT INTO `directors` (`director_name`)
VALUES ('A'), ('B'),('C'),('D'),('E');

INSERT INTO `genres` (`genre_name`)
VALUES ('A'), ('B'),('C'),('D'),('E');

INSERT INTO `categories` (`category_name`)
VALUES ('A'), ('B'),('C'),('D'),('E');

INSERT INTO `movies` (`title`, `director_id`, `copyright_year`,`length`,`genre_id`,`category_id`)
VALUES
('A', 1, '2018', '22', 1, 1),
('B', 1, '2018', '22', 1, 1),
('C', 1, '2018', '22', 1, 1),
('D', 1, '2018', '22', 1, 1),
('E', 1, '2018', '22', 1, 1);


#13. Car Rental Database

CREATE TABLE `categories` (
	`id` INT UNSIGNED PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
	`category` VARCHAR(30) NOT NULL,
	`daily_rate` DOUBLE NOT NULL,
	`weekly_rate` DOUBLE NOT NULL,
	`monthly_rate` DOUBLE NOT NULL,
	`weekend_rate` DOUBLE NOT NULL
);

INSERT INTO `categories`
		(`category`, `daily_rate`, `weekly_rate`, `monthly_rate`, `weekend_rate`)
	VALUES 
		('Category 1', 1.1, 2.1, 3.1, 4.1),
		('Category 2', 1.2, 2.2, 3.2, 4.2),
		('Category 3', 1.3, 2.3, 3.3, 4.3);

CREATE TABLE `cars` (
	`id` INT UNSIGNED PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
	`plate_number` VARCHAR(20) NOT NULL UNIQUE,
	`make` VARCHAR(20) NOT NULL,
	`model` VARCHAR(20) NOT NULL,
	`car_year` YEAR NOT NULL,
	`category_id` INT UNSIGNED NOT NULL,
	`doors` TINYINT UNSIGNED NOT NULL,
	`picture` BLOB,
	`car_condition` VARCHAR(20),
	`available` BOOLEAN NOT NULL DEFAULT TRUE
);

INSERT INTO `cars`
		(`plate_number`, `make`, `model`, `car_year`, `category_id`, `doors`, `car_condition`)
	VALUES 
		('Plate Num 1', 'Maker 1', 'Model 1', '1970', 1, 2, ''),
		('Plate Num 2', 'Maker 2', 'Model 2', '1980', 2, 4, 'Scrap'),
		('Plate Num 3', 'Maker 3', 'Model 3', '1990', 3, 5, 'Good');

CREATE TABLE `employees` (
	`id` INT UNSIGNED PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
	`first_name` VARCHAR(30) NOT NULL,
	`last_name` VARCHAR(30) NOT NULL,
	`title` VARCHAR(30) NOT NULL,
	`notes` VARCHAR(128)
);

INSERT INTO `employees`
		(`first_name`, `last_name`, `title`, `notes`)
	VALUES 
		('Gosho', 'Goshev', 'Boss', ''),
		('Pesho', 'Peshev', 'Supervisor', ''),
		('Bai', 'Ivan', 'Worker', 'Can do any work');

CREATE TABLE `customers` (
	`id` INT UNSIGNED PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
	`driver_licence_number` VARCHAR(30) NOT NULL,
	`full_name` VARCHAR(60) NOT NULL,
	`address` VARCHAR(50) NOT NULL,
	`city` VARCHAR(20) NOT NULL,
	`zip_code` INT(4) NOT NULL,
	`notes` VARCHAR(128)
);

INSERT INTO `customers`
		(`driver_licence_number`, `full_name`, `address`, `city`, `zip_code`, `notes`)
	VALUES 
		('1234ABCD', 'A A', 'Lorem Ipsum 1', 'Sofia', 1111, ''),
		('2234ABCD', 'B V', 'Lorem Ipsum 2', 'Burgas', 2222, ''),
		('3234ABCD', 'C C', 'Lorem Ipsum 3', 'Sofia', 3333, '');

CREATE TABLE `rental_orders` (
	`id` INT UNSIGNED PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
	`employee_id` INT UNSIGNED NOT NULL,
	`customer_id` INT UNSIGNED NOT NULL,
	`car_id` INT UNSIGNED NOT NULL,
	`car_condition` VARCHAR(20),
	`tank_level` DOUBLE,
	`kilometrage_start` DOUBLE,
	`kilometrage_end` DOUBLE,
	`total_kilometrage` DOUBLE,
	`start_date` DATE,
	`end_date` DATE,
	`total_days` INT UNSIGNED,
	`rate_applied` DOUBLE,
	`tax_rate` DOUBLE,
	`order_status` VARCHAR(30),
	`notes` VARCHAR(128)
);

INSERT INTO `rental_orders`
		(`employee_id`, `customer_id`, `car_id`, `car_condition`, `start_date`)
	VALUES 
		(1, 3, 2, 'Good', NOW()),
		(2, 1, 3, 'Bad', NOW()),
		(3, 2, 1, 'OK', NOW());


#14. Hotel Database

CREATE TABLE `employees` (
    `id` INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(40) NOT NULL,
    `last_name` VARCHAR(40) NOT NULL,
    `title` VARCHAR(40) NOT NULL,
    `notes` TEXT
);

CREATE TABLE `customers` (
    `account_number` INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(40) NOT NULL,
    `last_name` VARCHAR(40) NOT NULL,
    `phone_number` VARCHAR(40) NOT NULL,
    `emergency_name` VARCHAR(50),
    `emergency_number` VARCHAR(40),
    `notes` TEXT
);

CREATE TABLE `room_status` (
    `room_status` INT UNSIGNED PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    `notes` TEXT
);

CREATE TABLE `room_types` (
    `room_type` INT UNSIGNED PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    `notes` TEXT
);

CREATE TABLE `bed_types` (
    `bed_type` INT UNSIGNED PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    `notes` TEXT
);

CREATE TABLE `rooms` (
    `room_number` INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `room_type` INT UNSIGNED NOT NULL,
    `bed_type` INT UNSIGNED NOT NULL,
    `rate` DOUBLE DEFAULT 0,
    `room_status` INT UNSIGNED NOT NULL,
    `notes` TEXT
);

CREATE TABLE `payments` (
    `id` INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `employee_id` INT UNSIGNED NOT NULL,
    `payment_date` DATE NOT NULL,
    `account_number` INT UNSIGNED NOT NULL,
    `first_date_occupied` DATE,
    `last_date_occupied` DATE,
    `total_days` INT UNSIGNED,
    `amount_charged` DOUBLE,
    `tax_rate` DOUBLE,
    `tax_amount` DOUBLE,
    `payment_total` DOUBLE,
    `notes` TEXT
);

CREATE TABLE `occupancies` (
    `id` INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `employee_id` INT UNSIGNED NOT NULL,
    `date_occupied` DATE NOT NULL,
    `account_number` INT UNSIGNED NOT NULL,
    `room_number` INT UNSIGNED NOT NULL,
    `rate_applied` DOUBLE,
    `phone_charge` DOUBLE,
    `notes` TEXT
);
 
INSERT INTO `employees`
		(`first_name`, `last_name`, `title`)
	VALUES 
		('Gosho', 'Goshev', 'Boss'),
		('Pesho', 'Peshev', 'Supervisor'),
		('Bai', 'Ivan', 'Worker');
 
INSERT INTO `customers`
		(`first_name`, `last_name`, `phone_number`)
	VALUES 
		('Gosho', 'Goshev', '123'),
		('Pesho', 'Peshev', '44-2432'),
		('Bai', 'Ivan', '007');
 
INSERT INTO `room_status` 
		(`notes`)
	VALUES 
		('Free'),
		('For clean'),
		('Occupied');

INSERT INTO `room_types` 
		(`notes`)
	VALUES 
		('Small'),
		('Medium'),
		('Appartment');
        
INSERT INTO `bed_types` 
		(`notes`)
	VALUES 
		('Single'),
		('Double'),
		('Water-filled');
        
INSERT INTO `rooms` 
		(`room_type`, `bed_type`, `room_status`)
	VALUES 
		(1, 1, 1),
		(2, 2, 2),
		(3, 3, 3);

INSERT INTO `payments` 
		(`employee_id`, `payment_date`, `account_number`)
	VALUES 
		(1, DATE(NOW()), 1),
		(2, DATE(NOW()), 2),
		(3, DATE(NOW()), 3);
        
INSERT INTO `occupancies` 
		(`employee_id`, `date_occupied`, `account_number`, `room_number`)
	VALUES 
		(1, DATE(NOW()), 1, 1),
		(2, DATE(NOW()), 2, 2),
		(3, DATE(NOW()), 3, 3);


#15. Create SoftUni Database

CREATE TABLE `towns` (
    `id` INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
    `name` VARCHAR(40) NOT NULL,
    CONSTRAINT `pk_towns` PRIMARY KEY (`id`)
);

CREATE TABLE `addresses` (
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `address_text` VARCHAR(40) NOT NULL,
    `town_id` INT UNSIGNED NOT NULL,
    CONSTRAINT `pk_addresses` PRIMARY KEY (`id`),
    
    CONSTRAINT `fk_addresses_towns` FOREIGN KEY (`town_id`)
	REFERENCES `towns` (`id`)
);

CREATE TABLE `departments` (
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(40) NOT NULL,
    CONSTRAINT `pk_departments` PRIMARY KEY (`id`)
);

CREATE TABLE `employees` (
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) NOT NULL,
    `middle_name` VARCHAR(40) NOT NULL,
    `last_name` VARCHAR(40) NOT NULL,
    `job_title` VARCHAR(40) NOT NULL,
    `department_id` INT UNSIGNED NOT NULL,
    `hire_date` DATE NOT NULL,
    `salary` DOUBLE NOT NULL,
    `address_id` INT UNSIGNED NOT NULL,
    CONSTRAINT `pk_employees` PRIMARY KEY (`id`),
    
    CONSTRAINT `fk_employees_departments` FOREIGN KEY (`department_id`)
	REFERENCES `departments` (`id`),
    
    CONSTRAINT `fk_employees_addresses` FOREIGN KEY (`address_id`)
	REFERENCES `addresses` (`id`)
);

   
#16. Basic Insert

INSERT INTO `towns` (`name`) VALUES ('Sofia'), ('Plovdiv'), ('Varna'), ('Burgas');

INSERT INTO `departments` (`name`) VALUES ('Engineering'), ('Sales'), ('Marketing'), ('Software Development'), ('Quality Assurance');

INSERT INTO `employees` (`first_name`,`middle_name`,`last_name`,`job_title`,`department_id`,`hire_date`,`salary`)
VALUES 
('Ivan', 'Ivanov', 'Ivanov', '.NET Developer', 4,'2013-02-01','3500.00'),
('Petar', 'Petrov', 'Petrov', 'Senior Engineer', 1,'2004-03-02','4000.00'),
('Maria', 'Petrova', 'Ivanova', 'Intern', 5,'2016-08-28','525.25'),
('Georgi', 'Terziev', 'Ivanov', 'CEO', 2,'2007-12-09','3000.00'),
('Peter', 'Pan', 'Pan', 'Intern', 3,'2016-08-28','599.88');

#17. Basic Select All Fields

SELECT * FROM `towns`;

SELECT * FROM `departments`;

SELECT * FROM `employees`;

#18. Basic Select All Fields and Order Them

SELECT * FROM `towns`
ORDER BY `name` ASC;

SELECT * FROM `departments`
ORDER BY `name` ASC;

SELECT * FROM `employees`
ORDER BY `salary` DESC;

#19. Basic Select Some Fields

SELECT `name` FROM `towns`
ORDER BY `name` ASC;

SELECT `name` FROM `departments`
ORDER BY `name` ASC;

SELECT `first_name`,`last_name`, `job_title`, `salary` FROM `employees`
ORDER BY `salary` DESC;


#20. Increase Employees Salary

UPDATE `employees`
SET `salary` = `salary` * 1.1;

SELECT `salary` FROM `employees`;

#21. Decrease Tax Rate

UPDATE `payments`
SET `tax_rate` = `tax_rate` * 0.97;

SELECT `tax_rate` FROM `payments`;


#22. Delete All Records

TRUNCATE bed_types;
TRUNCATE customers;
TRUNCATE employees;
TRUNCATE occupancies;
TRUNCATE payments;
TRUNCATE room_status;
TRUNCATE room_types;
TRUNCATE rooms;