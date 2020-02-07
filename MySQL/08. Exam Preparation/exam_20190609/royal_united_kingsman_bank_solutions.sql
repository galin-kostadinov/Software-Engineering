#01. Table Design

CREATE TABLE `branches`(
`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE `clients`(
`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`full_name` VARCHAR(50) NOT NULL,
`age` INT NOT NULL
);

CREATE TABLE `employees`(
`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(20) NOT NULL,
`last_name` VARCHAR(20) NOT NULL,
`salary` DECIMAL(10,2) NOT NULL,
`started_on` DATE NOT NULL,
`branch_id` INT NOT NULL,

CONSTRAINT fk_employees_brances
FOREIGN KEY (`branch_id`)
REFERENCES `branches`(`id`)
);

CREATE TABLE `employees_clients`(
`employee_id` INT,
`client_id` INT,

CONSTRAINT fc_employees_clients_employees
FOREIGN KEY (`employee_id`)
REFERENCES `employees`(`id`),

CONSTRAINT fc_employees_clients_clientes
FOREIGN KEY (`client_id`)
REFERENCES `clients`(`id`)
);

CREATE TABLE `bank_accounts`(
`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`account_number` VARCHAR(10) NOT NULL,
`balance` DECIMAL(10,2) NOT NULL,
`client_id` INT NOT NULL UNIQUE,

CONSTRAINT fc_bank_accounts_clientes
FOREIGN KEY (`client_id`)
REFERENCES `clients`(`id`)
);
	
CREATE TABLE `cards`(
`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`card_number` VARCHAR(19) NOT NULL,
`card_status` VARCHAR(7) NOT NULL,
`bank_account_id` INT NOT NULL,

CONSTRAINT fc_cards_bank_accounts
FOREIGN KEY (`bank_account_id`)
REFERENCES `bank_accounts`(`id`)
);


#02. Insert

INSERT INTO `cards` (`card_number`, `card_status`, `bank_account_id`)
SELECT reverse(cl.`full_name`), 'Active', cl.`id`
FROM `clients` AS cl
WHERE cl.`id` BETWEEN 191 AND 200;


#03. Update

UPDATE `employees_clients` AS em_cl
SET `employee_id` = (
	SELECT result.em_id 
    FROM(
		SELECT COUNT(ec.`client_id`) AS ec_count, ec.`employee_id` AS em_id
		FROM `employees_clients` AS ec
		GROUP BY ec.`employee_id`
		ORDER BY ec_count ASC, ec.employee_id ASC
		LIMIT 1
        ) AS result
	)
WHERE em_cl.`employee_id` = em_cl.`client_id`;


#04. Delete

DELETE FROM `employees` AS empl
WHERE	(
		SELECT ec.`employee_id`
		FROM `employees_clients` AS ec
		WHERE ec.`employee_id` = empl.id
		GROUP BY ec.`employee_id`
		) IS NULL;
        
        
#06. Newbies

SELECT e.`id`, concat_ws(' ', e.`first_name`, e.`last_name`) AS full_name , concat_ws('', '$', e.`salary`) AS salary, e.`started_on`
FROM `employees` AS e
WHERE e.`salary` >= 100000 AND e.`started_on` >= '2018-01-01'
ORDER BY e.`salary` DESC, e.`id`;


#07. Cards against Humanity

SELECT c.`id`, concat(c.`card_number`,' : ' ,cl.`full_name`) AS card_token
FROM `cards` AS c
JOIN `bank_accounts` AS ba
ON ba.id = c.`bank_account_id`
JOIN `clients` AS cl
ON cl.id = ba.`client_id`
ORDER BY c.id DESC;


#08. Top 5 Employees

SELECT concat_ws(' ', e.`first_name`, e.`last_name`) AS name, e.`started_on`, COUNT(ec.`client_id`) AS count_of_clients
FROM `employees` AS e
JOIN `employees_clients` AS ec
ON e.id = ec.`employee_id`
GROUP BY ec.`employee_id`
ORDER BY count_of_clients DESC, e.`id` ASC
LIMIT 5;


#09. Branch cards

SELECT b.`name` AS 'name', COUNT(c.id) 'count_of_cards'
FROM `branches` as b
LEFT JOIN `employees` AS e
ON b.`id` = e.`branch_id`
LEFT JOIN `employees_clients` AS ec
ON e.`id` = ec.`employee_id`
LEFT JOIN `bank_accounts` AS ba
ON ec.`client_id` = ba.`client_id`
LEFT JOIN `cards` AS c
ON ba.`id` = c.`bank_account_id`
GROUP BY name
ORDER BY count_of_cards DESC, b.name;


#10. Extract card's count

DELIMITER $$
CREATE FUNCTION udf_client_cards_count(p_name VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE  result INT;
	SET result := (
		SELECT COUNT(cl.`id`) 
		FROM `clients` AS cl
        JOIN `bank_accounts` AS ba
        ON ba.`client_id` = cl.id
        JOIN `cards` AS c
        ON c.`bank_account_id` = ba.`id`
        WHERE cl.`full_name` = p_name
	);
	RETURN result;
END $$
DELIMITER ;


#11. Client Info

DELIMITER $$
CREATE PROCEDURE udp_clientinfo (p_full_name VARCHAR(50))
BEGIN
	SELECT c.`full_name`, c.`age`, ba.`account_number`, concat('$', ba.`balance`) AS balance
	FROM `clients` AS c
	JOIN `bank_accounts` AS ba
	ON c.`id` = ba.`client_id`
    WHERE c.`full_name` = p_full_name;
END $$
DELIMITER ;