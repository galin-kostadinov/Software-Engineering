#01. Departments Info

SELECT `department_id`, COUNT(`department_id`) AS 'Number of employees'
FROM `employees`
GROUP BY `department_id`
ORDER BY `department_id` ASC;


#02. Average Salary

SELECT `department_id`, ROUND(AVG(`salary`), 2) AS 'Average Salary'
FROM `employees`
GROUP BY `department_id`
ORDER BY `department_id` ASC;


#03. Min Salary

SELECT 
    `department_id`, ROUND(MIN(`salary`), 2) AS 'Min Salary'
FROM
    `employees`
GROUP BY `department_id`
HAVING `Min Salary` > 800;


#04. Appetizers Count

SELECT COUNT(*)
FROM `products`
WHERE `price` > 8.0 AND `category_id` = 2;


#05. Menu Prices

SELECT 
    `category_id`,
    ROUND(AVG(`price`), 2) AS 'Average Price',
    ROUND(MIN(`price`), 2) AS 'Cheapest Product',
    ROUND(MAX(`price`), 2) AS 'Most Expensive Product'
FROM
    `products`
GROUP BY `category_id`;
