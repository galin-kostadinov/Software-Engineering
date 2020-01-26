#01. Employees with Salary Above 35000

DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above_35000()
	BEGIN
		SELECT e.`first_name`, e.`last_name`
		FROM `employees` AS e
		WHERE e.`salary` > 35000
		ORDER BY e.`first_name`, e.`last_name`, e.`employee_id`;
	END $$
DELIMITER ;

#02. Employees with Salary Above Number

DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above(salary DECIMAL(19,4))
	BEGIN
		SELECT e.`irst_name`, e.`last_name`
		FROM `employees` AS e
		WHERE e.`salary` >= `salary`
		ORDER BY e.`first_name`, e.`last_name`, e.`employee_id`;
	END $$
DELIMITER ;

#03. Town Names Starting With

DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with(town_name VARCHAR(50))
	BEGIN
		SELECT t.`name`
		FROM `towns` AS t
		WHERE t.`name` LIKE CONCAT(town_name, '%')
		ORDER BY t.name;
	END $$
DELIMITER ;


#04. Employees from Town

DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town(town_name VARCHAR(50))
	BEGIN
		SELECT e.`first_name`, e.`last_name`
		FROM `employees` AS e
        JOIN `addresses` AS a
        ON e.`address_id` = a.`address_id`
		JOIN `towns` AS t
        ON a.`town_id` = t.`town_id`
        WHERE t.`name` = `town_name`
		ORDER BY e.`first_name`, e.`last_name`, e.`employee_id`;
	END $$
DELIMITER ;


#05. Salary Level Function

CREATE FUNCTION ufn_get_salary_level (salary_in DECIMAL(19,4))
RETURNS VARCHAR(10)
    RETURN (
    CASE
    WHEN salary_in < 30000 THEN 'Low'
    WHEN salary_in BETWEEN 30000 AND 50000 THEN 'Average'
    ELSE 'High'
    END);


#06. Employees by Salary Level

DELIMITER $$
CREATE PROCEDURE usp_get_employees_by_salary_level(salary_level VARCHAR(10))
BEGIN
SELECT e.`first_name`, e.`last_name`
	FROM employees AS e
	WHERE (e.`salary` < 30000 AND `salary_level` = 'Low') OR
    (e.`salary` BETWEEN 30000 AND 50000 AND salary_level = 'Average') OR
    (e.`salary` > 50000 AND salary_level = 'High')
	ORDER BY e.`first_name` DESC, e.`last_name` DESC;
END $$
DELIMITER ;


#07. Define Function

#First variant

CREATE FUNCTION ufn_is_word_comprised(set_of_letters varchar(50), word varchar(50))
RETURNS BIT
RETURN word REGEXP (concat('^[', set_of_letters,']+$'));

#Second variant
DELIMITER $$
CREATE FUNCTION ufn_is_word_comprised(set_of_letters varchar(50), word varchar(50))
RETURNS BIT
BEGIN
	DECLARE lenght INT;
	DECLARE result BIT;
	DECLARE curr_index INT;
	SET lenght:= LENGTH(word);
	SET curr_index = 1;
	SET result := 1;
    
    WHILE(curr_index <= lenght AND result) DO
		IF(set_of_letters NOT LIKE CONCAT('%', SUBSTRING(word, curr_index, 1), '%'))
			THEN SET result:= 0;
		END IF;
		
		SET curr_index := curr_index + 1;
    END WHILE;

	RETURN result;
END $$
DELIMITER ;


#08. Find Full Name

DELIMITER $$
CREATE PROCEDURE usp_get_holders_full_name()
BEGIN
SELECT CONCAT (ah.`first_name`, ' ',ah.`last_name`) AS full_name
FROM `account_holders` AS ah
ORDER BY full_name ASC, ah.`id` ASC;
END $$
DELIMITER ;

#09. People with Balance Higher Than

DELIMITER $$
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(amound DECIMAL(19, 4))
BEGIN
	SELECT ah.`first_name`, ah.`last_name`
	FROM `account_holders` AS ah
	JOIN `accounts` AS a
	ON ah.`id` = a.`account_holder_id`
	GROUP BY a.`account_holder_id`
    	HAVING SUM(a.`balance`) > amound
	ORDER BY a.`id` ASC;
END $$
DELIMITER ;


#10. Future Value Function

DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value(
    initial_sum DOUBLE(19, 2), interest_rate DOUBLE(19, 2), years INT)
RETURNS DOUBLE(19, 11)
BEGIN
    RETURN initial_sum * POW((1 + interest_rate), years);
END $$
DELIMITER ;


#11. Calculating Interest

DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value(
    initial_sum DECIMAL(19, 4), interest_rate DECIMAL(19, 4), years INT)
RETURNS DECIMAL(19, 4)
BEGIN
    RETURN initial_sum * POW((1 + interest_rate), years);
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE usp_calculate_future_value_for_account(
    account_id INT, interest_rate DECIMAL(19, 4))
BEGIN
    SELECT 
         a.id AS 'account_id', h.`first_name`, h.`last_name`, a.`balance` AS 'current_balance',
         ufn_calculate_future_value(a.`balance`, interest_rate, 5) AS 'balance_in_5_years'
    FROM
        `account_holders` AS h
            JOIN
        `accounts` AS a ON h.`id` = a.`account_holder_id`
    WHERE a.`id` = account_id;
END $$
DELIMITER ;


#12. Deposit Money

DELIMITER $$
CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount DECIMAL(19,4))
BEGIN
START TRANSACTION;
IF (money_amount < 0 AND round(money_amount,4) <> money_amount ) THEN
ROLLBACK;
ELSE
UPDATE accounts AS a SET a.`balance` = a.`balance`  + money_amount WHERE a.`id` = account_id;
COMMIT;
END IF;
END $$
DELIMITER ;


#13. Withdraw Money

DELIMITER $$
CREATE PROCEDURE usp_withdraw_money(
    account_id INT, money_amount DECIMAL(19, 4))
BEGIN
    IF money_amount > 0 THEN
        START TRANSACTION;
        
        UPDATE `accounts` AS a 
        SET 
            a.`balance` = a.`balance` - money_amount
        WHERE
            a.`id` = account_id;
        
        IF (SELECT a.`balance `
            FROM `accounts` AS a 
            WHERE a.`id` = account_id) < 0
            THEN ROLLBACK;
        ELSE
            COMMIT;
        END IF;
    END IF;
END $$
DELIMITER ;


#14. Money Transfer

DELIMITER $$
CREATE PROCEDURE usp_transfer_money(
    from_account_id INT, to_account_id INT, money_amount DECIMAL(19, 4))
BEGIN
    IF money_amount > 0 
        AND from_account_id <> to_account_id 
        AND (SELECT a.`id`
            FROM `accounts` AS a 
            WHERE a.id = to_account_id) IS NOT NULL
        AND (SELECT a.`id`
            FROM `accounts` AS a 
            WHERE a.`id` = from_account_id) IS NOT NULL
        AND (SELECT a.balance 
            FROM `accounts` AS a 
            WHERE a.`id` = from_account_id) >= money_amount
    THEN
        START TRANSACTION;
        
        UPDATE `accounts` AS a 
        SET 
            a.`balance` = a.`balance` + money_amount
        WHERE
            a.`id` = to_account_id;
            
        UPDATE `accounts` AS a 
        SET 
            a.`balance` = a.`balance` - money_amount
        WHERE
            a.`id` = from_account_id;
        
        IF (SELECT a.`balance` 
            FROM `accounts` AS a 
            WHERE a.`id` = from_account_id) < 0
            THEN ROLLBACK;
        ELSE
            COMMIT;
        END IF;
    END IF;
END  $$
DELIMITER ;


#15. Log Accounts Trigger

CREATE TABLE  `logs`(
`log_id` INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
`account_id` INT(11),
`old_sum` DECIMAL(19, 4),
`new_sum` DECIMAL(19, 4));

DELIMITER $$
CREATE TRIGGER tr_logs
AFTER UPDATE
ON `accounts`
FOR EACH ROW
BEGIN
	INSERT INTO `logs` (`account_id`, `old_sum`, `new_sum` )
	VALUES (OLD.id, OLD.balance, NEW.balance);
END $$
DELIMITER ;


#16. Emails Trigger

CREATE TABLE  `logs`(
`log_id` INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
`account_id` INT(11),
`old_sum` DECIMAL(19, 4),
`new_sum` DECIMAL(19, 4));

DELIMITER $$
CREATE TRIGGER tr_logs
AFTER UPDATE
ON `accounts`
FOR EACH ROW
BEGIN
	INSERT INTO `logs` (`account_id`, `old_sum`, `new_sum` )
	VALUES (OLD.id, OLD.balance, NEW.balance);
END $$
DELIMITER ;

CREATE TABLE `notification_emails` (
    `id` INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `recipient` INT(11) NOT NULL,
    `subject` VARCHAR(50) NOT NULL,
    `body` VARCHAR(255) NOT NULL
);
 
DELIMITER $$
CREATE TRIGGER `tr_notification_emails`
AFTER INSERT ON `logs`
FOR EACH ROW
BEGIN
    INSERT INTO `notification_emails`
        (`recipient`, `subject`, `body`)
    VALUES (
        NEW.account_id,
        CONCAT('Balance change for account: ', NEW.account_id),
        CONCAT('On ', DATE_FORMAT(NOW(), '%b %d %Y at %r'), ' your balance was changed from ', ROUND(NEW.old_sum, 2), ' to ', ROUND(NEW.new_sum, 2), '.'));
END; $$
DELIMITER ;