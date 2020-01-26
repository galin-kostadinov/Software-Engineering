#01. Find Names of All Employees by First Name

SELECT `first_name`, `last_name`
FROM `employees`
WHERE `first_name` LIKE 'Sa%'
ORDER BY `employee_id` ASC;


#02. Find Names of All employees by Last Name

SELECT `first_name`, `last_name`
FROM `employees`
WHERE `last_name` LIKE '%ei%'
ORDER BY `employee_id` ASC;


#03. Find First Names of All Employees

SELECT `first_name`
FROM `employees`
WHERE `department_id` IN (3,10) AND YEAR(`hire_date`) BETWEEN 1995 AND 2005
ORDER BY `employee_id` ASC;


#04. Find All Employees Except Engineers

SELECT `first_name`, `last_name`
FROM `employees`
WHERE `job_title` NOT LIKE '%engineer%'
ORDER BY `employee_id` ASC;


#05. Find Towns with Name Length

SELECT `name`
FROM `towns`
WHERE char_length(`name`) IN (5,6)
ORDER BY `name` ASC;


#06. Find Towns Starting With

SELECT *
FROM `towns`
WHERE substring(`name`, 1, 1) IN ('m', 'k', 'b', 'e')
ORDER BY `name` ASC;


#07. Find Towns Not Starting With

SELECT *
FROM `towns`
WHERE substring(`name`, 1, 1 ) NOT IN ('r', 'b', 'd')
ORDER BY `name` ASC;


#08. Create View Employees Hired After 2000 Year

CREATE VIEW v_employees_hired_after_2000 AS
SELECT `first_name`, `last_name`
FROM `employees`
WHERE YEAR(`hire_date`) > 2000;

SELECT * FROM v_employees_hired_after_2000;


#09. Length of Last Name

SELECT `first_name`, `last_name`
FROM `employees`
WHERE char_length(`last_name`) = 5;


#10. Countries Holding 'A' 3 or More Times

SELECT `country_name`, `iso_code`
FROM `countries`
WHERE `country_name` LIKE '%a%a%a%'
ORDER BY `iso_code` ASC;


#11. Mix of Peak and River Names

SELECT p.`peak_nam`e, r.`river_name`, concat(LOWER(p.`peak_name`), substring( LOWER(r.`river_name`), 2)) AS mix
FROM `peaks` AS p, `rivers` AS r
WHERE RIGHT(p.`peak_name`, 1) = LEFT(r.`river_name`, 1)
ORDER BY mix ASC;


#12. Games from 2011 and 2012 year

SELECT `name`, DATE_FORMAT(`start`, '%Y-%m-%d') 
FROM `games`
WHERE YEAR(`start`) IN (2011, 2012)
ORDER BY `start` ASC
LIMIT 50;


#13. User Email Providers

SELECT `user_name`,
SUBSTRING(`email`, LOCATE('@', `email`) + 1)  AS 'Email Provider'
FROM `users`
ORDER BY `Email Provider` ASC, `user_name` ASC;


#14. Get Users with IP Address Like Pattern

SELECT `user_name`, `ip_address`
FROM `users`
WHERE `ip_address` LIKE '___.1%.%.___'
ORDER BY `user_name` ASC;


#15. Show All Games with Duration and Part of the Day

SELECT
	`name` AS 'game',
    CASE 
    WHEN HOUR(`start`) >= 0 AND HOUR(`start`) < 12 THEN 'Morning'
    WHEN HOUR(`start`) >= 12 AND HOUR(`start`) < 18 THEN 'Afternoon'
    WHEN HOUR(`start`) >= 18 AND HOUR(`start`) < 24 THEN'Evening'
    END AS 'Part of the Day',
    CASE 
    WHEN `duration` BETWEEN 0 AND 3 THEN 'Extra Short'
    WHEN `duration` BETWEEN 3 AND 6 THEN 'Short'
    WHEN `duration` BETWEEN 6 AND 10 THEN 'Long'
	ELSE 'Extra Long'
    END AS 'Duration'
FROM `games`;


#16. Orders Table

SELECT
	`product_name`,
	`order_date`,
	DATE_ADD(`order_date`, INTERVAL 3 DAY) AS 'pay_due',
	DATE_ADD(`order_date`, INTERVAL 1 MONTH) AS 'deliver_due'
FROM `orders`;

