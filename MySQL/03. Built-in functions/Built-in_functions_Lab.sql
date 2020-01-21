#01. Find Book Titles

SELECT `title` FROM books
WHERE substring(`title`,1,3) = 'The'
ORDER BY `id` ASC;


#02. Replace Titles

SELECT REPLACE(`title`, 'The', '***')
FROM `books`
WHERE SUBSTRING(`title`, 1, 3) = 'The'
ORDER BY `id` ASC;


#03. Sum Cost of All Books

SELECT ROUND(SUM(`cost`), 2)
FROM `books`;


#04. Days Lived

SELECT  CONCAT(`first_name`, ' ',`last_name`) AS 'Full Name',
timestampdiff(DAY, `born`, `died`) AS 'Days Lived'
FROM `authors`;


#05. Harry Potter Books

SELECT `title`
FROM `books`
WHERE `title` LIKE '%Harry Potter%'
ORDER BY `id` ASC;