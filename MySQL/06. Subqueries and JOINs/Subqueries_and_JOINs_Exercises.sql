#01. Employee Address

SELECT e.`employee_id`, e.`job_title`, e.`address_id`, a.`address_text`
FROM `employees` AS e
JOIN `addresses` AS a
ON e.`address_id` = a.`address_id`
ORDER BY e.`address_id`
LIMIT 5;


#02. Addresses with Towns

SELECT e.`first_name`, e.`last_name`, t.`name`, a.`address_text`
FROM `employees` AS e
JOIN `addresses` AS a
ON e.`address_id` = a.`address_id`
JOIN `towns` AS t
ON a.`town_id` = t.`town_id`
ORDER BY e.`first_name`, e. `last_name`
LIMIT 5;


#03. Sales Employee

SELECT e.`employee_id`, e.`first_nam`e, e.`last_name`, d.`name` AS department_name
FROM `employees` AS e
JOIN `departments` AS d
ON e.`department_id` = d.`department_id`
WHERE d.name = 'Sales'
ORDER BY e.`employee_id` DESC;


#04. Employee Departments

SELECT e.`employee_id`, e.`first_name`, e.`salary`, d.name AS department_name
FROM `employees` AS e
JOIN `departments` AS d
ON e.`department_id` = d.`department_id`
WHERE e.`salary` > 15000
ORDER BY d.`department_id` DESC
LIMIT 5;


#05. Employees Without Project

SELECT e.`employee_id`, e.`first_name`
FROM  `employees` AS e
LEFT JOIN `employees_projects` AS ep
ON e.`employee_id` = ep.`employee_id`
WHERE ep.`employee_id` IS NULL
ORDER BY e.`employee_id` DESC
LIMIT 3;


#06. Employees Hired After

SELECT e.`first_name`, e.`last_name`, e.`hire_date`, d.`name` AS dept_name
FROM `employees` AS e
JOIN `departments` AS d
ON e.`department_id` = d.`department_id`
WHERE DATE(e.`hire_dat`e) > '1999/1/1' AND d.name IN ('Sales', 'Finance')
ORDER BY e.`hire_date` ASC;


#07. Employees with Project

SELECT e.`employee_id`, e.`first_name`, p.`name` AS project_name
FROM  `employees` AS e
JOIN `employees_projects` AS ep
ON e.`employee_id` = ep.`employee_id`
JOIN `projects` AS p
ON p.`project_id` = ep.`project_id`
WHERE DATE(p.`start_date`) > '2002-08-13' AND p.`end_date` IS NULL
ORDER BY e.`first_name`, p.name
LIMIT 5;


#08. Employee 24

SELECT 	e.`employee_id`,
		e.`first_name`,
		IF(YEAR(p.`start_date`) >='2005', NULL, p.`name`) AS project_name
FROM `employees` AS e
JOIN `employees_projects` AS ep
ON e.`employee_id `= ep.`employee_id`
JOIN `projects` AS p
ON p.`project_id` = ep.`project_id`
WHERE e.`employee_id` = 24
ORDER BY p.`name`;


#09. Employee Manager

SELECT e.`employee_id`, e.`first_name`, e.`manager_id`, m.`first_name`
FROM `employees` AS e
JOIN `employees` AS m
ON m.`employee_id` = e.`manager_id`
WHERE e.`manager_id` IN (3, 7) 
ORDER BY e.`first_name`;


#10. Employee Summary

SELECT e.`employee_id`,
CONCAT(e.`first_name`, ' ', e.`last_name`) AS employee_name,
CONCAT(m.`first_name`, ' ', m.`last_name`) AS manager_name,
d.`name` AS department_name
FROM `employees` AS e
JOIN `employees `AS m
ON m.`employee_id` = e.`manager_id`
JOIN `departments` AS d
ON e.`department_id` = d.`department_id`
ORDER BY e.`employee_id`
LIMIT 5;


#11. Min Average Salary

SELECT MIN(department_avg_salary.avg_salary) AS min_average_salary
FROM (
	SELECT AVG(eAVG.salary) AS avg_salary
	FROM `employees` AS eAVG
	GROUP BY eAVG.department_id) AS department_avg_salary;


#12. Highest Peaks in Bulgaria

SELECT mc.`country_code`, m.`mountain_range`, p.`peak_name`, p.`elevation`
FROM `peaks` AS p
JOIN `mountains` AS m
ON p.`mountain_id` = m.id
JOIN `mountains_countries` AS mc
ON m.`id` = mc.`mountain_id`
WHERE mc.`country_code` = 'BG' AND p.`elevation` > 2835
ORDER BY p.`elevation` DESC;


#13. Count Mountain Ranges

SELECT mc.`country_code`, COUNT(m.`mountain_range`) AS mountain_range
FROM `mountains` AS m
JOIN `mountains_countries` AS mc
ON m.id = mc.`mountain_id`
WHERE mc.`country_code` IN ('BG','RU', 'US')
GROUP BY mc.`country_code`
ORDER BY mountain_range DESC;


#14. Countries with Rivers

SELECT c.`country_name`, r.`river_name`
FROM `countries` AS c
LEFT JOIN `countries_rivers` AS cr
ON c.`country_code` = cr.`country_code`
LEFT JOIN `rivers` AS r
ON r.`id` = cr.`river_id`
WHERE c.`continent_code` = 'AF'
ORDER BY c.`country_name` ASC
LIMIT 5;


#15. *Continents and Currencies

SELECT 
    c.`continent_code`,
    c.`currency_code`,
    COUNT(*) AS 'currency_usage'
FROM
    `countries` AS c
GROUP BY c.`continent_code` , c.`currency_code`
HAVING `currency_usage` > 1
    AND `currency_usage` = (SELECT 
        COUNT(*) AS cn
    FROM
        `countries` AS c2
    WHERE
        c2.`continent_code` = c.`continent_code`
    GROUP BY c2.`currency_code`, c2.`continent_code`
    ORDER BY cn DESC
    LIMIT 1)
ORDER BY c.`continent_code`, c.`continent_code`;


#16. Countries without any Mountains

SELECT 
    COUNT(*) as 'country_count'
FROM
    (SELECT 
        mc.country_code AS 'mc_country_code'
    FROM
        `mountains_countries` AS mc
    GROUP BY mc.country_code) AS d
        RIGHT JOIN
    `countries` AS c ON c.country_code = d.mc_country_code
WHERE
    d.mc_country_code IS NULL;

#17. Highest Peak and Longest River by Country

SELECT c.`country_name`, MAX(p.`elevation`) AS highest_peak_elevation, MAX(r.`length`) AS longest_river_length
FROM `countries` AS c
LEFT JOIN `mountains_countries` AS mc
ON mc.`country_code` = c.`country_code`
LEFT JOIN `peaks` AS p
ON mc.`mountain_id` = p.`mountain_id`
LEFT JOIN `countries_rivers `AS cr
ON c.`country_code` = cr.`country_code`
LEFT JOIN `rivers` AS r
ON cr.`river_id` = r.`id`
GROUP BY c.`country_name`
ORDER BY highest_peak_elevation DESC, longest_river_length DESC, c.`country_name` ASC
LIMIT 5;
