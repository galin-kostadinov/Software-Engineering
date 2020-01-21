#01. Managers

SELECT e.employee_id,
CONCAT(e.first_name, ' ', e.last_name) AS full_name,
d.department_id,
d.`name` AS 'deparment_name'
FROM employees e
JOIN departments d
ON e.employee_id = d.manager_id
ORDER BY e.employee_id ASC
LIMIT 5;


#02. Towns Adresses

SELECT a.town_id, t.name AS town_name, a.address_text
FROM addresses AS a
JOIN towns AS t
ON a.town_id = t .town_id
WHERE t.name IN ('San Francisco', 'Sofia', 'Carnation')
ORDER BY a.town_id, a.address_id;


#03. Employees Without Managers

SELECT employee_id, first_name, last_name, department_id, salary
FROM employees AS e
WHERE e.manager_id IS NULL;


#04. Higher Salary

SELECT COUNT(salary) AS count
FROM employees AS e
WHERE e.salary >(SELECT AVG(salary) FROM employees);
