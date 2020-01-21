#01. Select Employee Information

SELECT id, first_name, last_name, job_title FROM employees
ORDER BY id ASC;


#02. Select Employees with Filter

SELECT id, concat(first_name, ' ' ,last_name) AS 'full_name', job_title, salary FROM employees
WHERE salary > 1000
ORDER BY id ASC;


#03. Update Employees Salary

UPDATE `employees`
SET `salary` = `salary` * 1.1
WHERE `job_title` = 'Therapist';

SELECT `salary` FROM  `employees`
ORDER BY `salary` ASC;


#04. Top Paid Employee

SELECT * FROM  `employees`
ORDER BY `salary` DESC
LIMIT 1;


#05. Select Employees by Multiple Filters

SELECT * FROM  `employees`
WHERE `department_id` = 4 AND `salary` >=1600
ORDER BY `id` ASC;


#06. Delete from Table

DELETE FROM `employees`
WHERE  `department_id` IN (1, 2);

SELECT * FROM `employees`
ORDER BY `id` ASC;
