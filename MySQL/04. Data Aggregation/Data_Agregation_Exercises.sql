#01. Records' Count

SELECT COUNT(`id`) AS 'count'
FROM wizzard_deposits;


#02. Longest Magic Wand

SELECT MAX(`magic_wand_size`) AS 'longest_magic_wand'
FROM `wizzard_deposits`;


#03. Longest Magic Wand per Deposit Groups

SELECT `deposit_group`, MAX(`magic_wand_size`) AS 'longest_magic_wand'
FROM `wizzard_deposits`
GROUP BY `deposit_group`
ORDER BY `longest_magic_wand` ASC,  `deposit_group` ASC;


#04. Smallest Deposit Group per Magic Wand Size*

SELECT `deposit_group`
FROM `wizzard_deposits`
GROUP BY `deposit_group`
ORDER BY AVG(`magic_wand_size`) ASC
LIMIT 1;


#05. Deposits Sum

SELECT `deposit_group`, ROUND(SUM(`deposit_amount`), 2) AS 'total_sum'
FROM `wizzard_deposits`
GROUP BY `deposit_group`
ORDER BY `total_sum` ASC;


#06. Deposits Sum for Ollivander family

SELECT `deposit_group`, ROUND(SUM(`deposit_amount`), 2) AS 'total_sum'
FROM `wizzard_deposits`
WHERE `magic_wand_creator` = 'Ollivander family'
GROUP BY `deposit_group`
ORDER BY `deposit_group` ASC;


#07. Deposits Filter

SELECT `deposit_group`, ROUND(SUM(`deposit_amount`), 2) AS 'total_sum'
FROM `wizzard_deposits`
WHERE `magic_wand_creator` = 'Ollivander family'
GROUP BY `deposit_group`
HAVING `total_sum` < 150000
ORDER BY `total_sum` DESC;


#08. Deposit charge

SELECT `deposit_group`, `magic_wand_creator`, MIN(`deposit_charge`) 
FROM `wizzard_deposits`
GROUP BY `deposit_group`, `magic_wand_creator`
ORDER BY `magic_wand_creator` ASC, `deposit_group` ASC;


#09. Age Groups

SELECT 
    CASE
        WHEN `age` BETWEEN 0 AND 10 THEN '[0-10]'
        WHEN `age` BETWEEN 11 AND 20 THEN '[11-20]'
        WHEN `age` BETWEEN 21 AND 30 THEN '[21-30]'
        WHEN `age` BETWEEN 31 AND 40 THEN '[31-40]'
        WHEN `age` BETWEEN 41 AND 50 THEN '[41-50]'
        WHEN `age` BETWEEN 51 AND 60 THEN '[51-60]'
        ELSE '[61+]'
    END AS 'age_group',
    COUNT(`age`) AS 'wizard_count'
FROM
    `wizzard_deposits`
GROUP BY `age_group`
ORDER BY `age_group`;


#10. First Letter

SELECT 
    LEFT(`first_name`, 1) AS 'first_letter'
FROM
    `wizzard_deposits`
WHERE
    `deposit_group` = 'Troll Chest'
GROUP BY `first_letter`
ORDER BY `first_letter`;


#11. Average Interest 

SELECT 
  `deposit_group`, `is_deposit_expired`, AVG(`deposit_interest`)
FROM
    `wizzard_deposits`
WHERE DATE(deposit_start_date) > '1985-01-01'
GROUP BY `deposit_group`, `is_deposit_expired`
ORDER BY `deposit_group` DESC;


#12. Rich Wizard, Poor Wizard*

SELECT SUM(table_with_diff.difference_between_two_deposites) AS 'sum_difference'
FROM
(
 SELECT 
	(wd1.deposit_amount-
		(	
		SELECT wd2.deposit_amount
		FROM wizzard_deposits AS wd2
		WHERE wd2.id = wd1.id + 1
		)
	) AS 'difference_between_two_deposites'
   FROM wizzard_deposits AS wd1
) AS table_with_diff;
  

#13. Employees Minimum Salaries

SELECT `department_id`, MIN(`salary`)  AS 'minimum_salary'
FROM `employees`
WHERE `department_id` IN (2, 5, 7) AND DATE(`hire_date`) > '2000-01-01'
GROUP BY `department_id`
ORDER BY `department_id` ASC;


#14. Employees Average Salaries

CREATE TABLE `employees_earn_30000` 
SELECT * FROM `employees`
WHERE`salary` > 30000;

DELETE FROM `employees_earn_30000`
WHERE (`manager_id` = 42);

UPDATE `employees_earn_30000`
SET `salary` = `salary` + 5000
WHERE `department_id`= 1;

SELECT `department_id`, AVG(`salary`) AS `avg_salary`
FROM `employees_earn_30000`
GROUP BY `department_id`
ORDER BY `department_id` ASC;


#15. Employees Maximum Salaries

SELECT `department_id`, MAX(`salary`) AS `max_salary`
FROM `employees`
GROUP BY `department_id`
HAVING `max_salary`> 70000 OR `max_salary` < 30000
ORDER BY `department_id` ASC;


#16. Employees Count Salaries

SELECT COUNT(`salary`)
FROM `employees`
WHERE manager_id IS NULL
ORDER BY `department_id` ASC;


#17. 3rd Highest Salary*

SELECT 
    `department_id`,
    (SELECT DISTINCT
            `e2`.`salary`
        FROM
            `employees` AS `e2`
        WHERE
            `e2`.`department_id` = `e1`.`department_id`
        ORDER BY `e2`.`salary` DESC
        LIMIT 1 OFFSET 2) AS `third_highest_salary`
FROM
    `employees` AS `e1`
GROUP BY `department_id`
HAVING `third_highest_salary` IS NOT NULL;


#18. Salary Challenge**

SELECT 
    `e`.`first_name`, `e`.`last_name`, `e`.`department_id`
FROM
    `employees` AS `e`
        JOIN
    (SELECT 
        `department_id`, AVG(`salary`) AS 'dep_avg_salary'
    FROM
        `employees`
    GROUP BY `department_id`) AS `avrg` ON `e`.`department_id` = `avrg`.`department_id`
WHERE
    `salary` > `avrg`.`dep_avg_salary`
ORDER BY `department_id`
LIMIT 10;


#19. Departments Total Salaries

SELECT `department_id`,  SUM(`salary`) AS 'total_salary'
FROM `employees`
GROUP BY `department_id`
ORDER BY `department_id` ASC;