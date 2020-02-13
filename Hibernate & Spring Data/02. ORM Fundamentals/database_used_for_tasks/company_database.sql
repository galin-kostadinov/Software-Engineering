CREATE DATABASE company_db;

USE company_db;

CREATE TABLE `employees`(
`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(20) NOT NULL,
`last_name` VARCHAR(25) NOT NULL,
`age` INT NOT NULL
);

INSERT INTO employees (`first_name`, `last_name`, `age`)
VALUES 
		('Guy', 'Gilbert', 27),
		('Kevin', 'Brown', 32),
		('Roberto', 'Tamburello', 42),
		('Rob', 'Walters', 29),
		('Thierry', 'Hers', 40),
		('David', 'Bradley', 50),
		('JoLynn', 'Dobney', 26),
		('Ruth', 'Ellerbrock', 27),
		('Gail', 'Erickson', 18),
		( 'Barry', 'Johnson', 27),
		( 'Jossef', 'Goldberg', 22),
		( 'Terri', 'Duffy', 48),
		( 'Sidney', 'Higa', 45),
		( 'Taylor', 'Maxwell', 18),
		( 'Jeffrey', 'Ford', 25),
		( 'Jo', 'Brown', 42),
		( 'Doris', 'Hartwig', 18),
		( 'John', 'Campbell', 28),
		( 'Diane', 'Glimp', 32);