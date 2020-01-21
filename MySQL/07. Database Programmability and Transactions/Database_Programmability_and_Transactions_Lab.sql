#01. Count Employees by Town

CREATE FUNCTION ufn_count_employees_by_town(town_name VARCHAR(20))
RETURNS INT
RETURN
	(SELECT COUNT(e.employee_id)
	FROM employees AS e
	JOIN addresses AS a
	ON e.address_id = a.address_id
	JOIN towns AS t
	ON a.town_id = t.town_id
	WHERE t.name = town_name
    );


#02. Employees Promotion

DELIMITER $$

CREATE PROCEDURE usp_raise_salaries(department_name VARCHAR(20))
BEGIN
	UPDATE employees AS e
    JOIN departments AS d
    ON e.department_id = d.department_id
    SET e.salary = 1.05 * e.salary
	WHERE d.name = department_name;
END
$$ 
DELIMITER ;


#3. Employees Promotion By ID

DELIMITER $$

CREATE PROCEDURE usp_raise_salary_by_id(id INT) 
BEGIN
	START TRANSACTION;
		IF((SELECT count(em.employee_id)
			FROM employees AS em
			WHERE em.employee_id like id)<>1)
		THEN ROLLBACK;
		ELSE
			UPDATE employees AS e
			SET e.salary = 1.05 * e.salary
			WHERE e.employee_id = id;
	END IF; 
END
$$ 
DELIMITER ;


#04. Triggered

CREATE TABLE deleted_employees (
    `employee_id` INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(50) NOT NULL,
    `last_name` VARCHAR(50) NOT NULL,
    `middle_name` VARCHAR(50),
    `job_title` VARCHAR(50) NOT NULL,
    `department_id` INT(10),
    `salary` DECIMAL(19 , 4 ) NOT NULL
);

DELIMITER $$

CREATE TRIGGER tr_deleted_employees
AFTER DELETE
ON employees
FOR EACH ROW
BEGIN
	INSERT INTO deleted_employees (`first_name`,`last_name`,`middle_name`,`job_title`, `department_id`,`salary`)
	VALUES (OLD.first_name, OLD.last_name, OLD.middle_name, OLD.job_title, OLD.department_id, OLD.salary);
END
$$ 
DELIMITER ;

