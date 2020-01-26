#01. One-To-One Relationship

CREATE TABLE passports(
passport_id INT(11) NOT NULL UNIQUE PRIMARY KEY,
passport_number VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE persons(
person_id INT(11) NOT NULL ,
first_name VARCHAR(30) NOT NULL,
salary DECIMAL(10, 2)  NOT NULL DEFAULT 0,
passport_id INT(11) NOT NULL UNIQUE
);

ALTER TABLE persons
MODIFY COLUMN person_id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY;

ALTER TABLE persons
ADD CONSTRAINT fk_persons_passports
FOREIGN KEY (passport_id) 
REFERENCES passports(passport_id);

INSERT INTO passports (passport_id, passport_number)
VALUES
	(101, 'N34FG21B'),
	(102, 'K65LO4R7'),
	(103, 'ZE657QP2');

INSERT INTO persons (first_name, salary, passport_id)
VALUES
	('Roberto', 43300.00, '102'),
	('Tom', 56100.00, '103'),
	('Yana', 60200.00, '101');


#02. One-To-Many Relationship

CREATE TABLE manufacturers(
`manufacturer_id` INT(11) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(15) NOT NULL,
`established_on` DATE NOT NULL
);

CREATE TABLE models(
`model_id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY, 
`name` VARCHAR(15) NOT NULL,
`manufacturer_id` INT(11) UNSIGNED NOT NULL,

CONSTRAINT fk_models_manufacturers
FOREIGN KEY (manufacturer_id)
REFERENCES manufacturers(manufacturer_id)
) AUTO_INCREMENT = 101;

INSERT INTO manufacturers (`name`, `established_on`)
VALUES 
	('BMW', STR_TO_DATE('01/03/1916', '%d/%m/%Y')), 
	('Tesla', STR_TO_DATE('01/01/2003', '%d/%m/%Y')),
	('Lada', STR_TO_DATE('01/05/1966', '%d/%m/%Y'));
    
INSERT INTO models (`name`, `manufacturer_id`)
VALUES 
	('X1', 1), 
	('i6', 1), 
	('Model S', 2),
    ('Model X', 2), 
    ('Model 3', 2), 
    ('Nova', 3);


#03. Many-To-Many Relationship

CREATE TABLE students(
`student_id` INT(11) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(15) NOT NULL
);

CREATE TABLE exams(
`exam_id` INT(11) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(15) NOT NULL
) AUTO_INCREMENT = 101;

CREATE TABLE students_exams(
`student_id` INT(11) UNSIGNED NOT NULL,
`exam_id` INT(11) UNSIGNED NOT NULL,

CONSTRAINT pk_student_id_exam_id
PRIMARY KEY (`student_id`,`exam_id`),

CONSTRAINT fk_students_exams_students
FOREIGN KEY (student_id)
REFERENCES students(student_id),

CONSTRAINT fk_students_exams_exams
FOREIGN KEY (exam_id)
REFERENCES exams(exam_id)
);

INSERT INTO students (`name`) VALUE ('Mila'), ('Toni'), ('Ron');

INSERT INTO exams (`name`) VALUE ('Spring MVC'), ('Neo4j'), ('Oracle 11g');

INSERT INTO students_exams (`student_id`, `exam_id`)
VALUE (1, 101), (1, 102), (2, 101), (3, 103), (2, 102), (2, 103);


#04. Self-Referencing

CREATE TABLE teachers(
`teacher_id` INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(15) NOT NULL,
`manager_id` INT(11),
CONSTRAINT fk_teacher_id_manager_id
FOREIGN KEY (`manager_id`)
REFERENCES teachers(`teacher_id`)
) AUTO_INCREMENT = 101;

INSERT INTO teachers (`name`)
VALUE
('John'), 
('Maya'), 
('Silvia'), 
('Ted'), 
('Mark'), 
('Greta');

UPDATE `teachers`
SET `manager_id` = 106
WHERE `teacher_id` IN (102, 103);

UPDATE `teachers`
SET `manager_id` = 105
WHERE `teacher_id` = 104;

UPDATE `teachers`
SET `manager_id` = 101
WHERE `teacher_id` IN (105, 106);


#05. Online Store Database

CREATE TABLE `cities` (
`city_id` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(50) NOT NULL
);

CREATE TABLE `customers`(
`customer_id` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(50) NOT NULL,
`birthday` DATE,
`city_id` INT(11) NOT NULL,

CONSTRAINT fk_customers_sities
FOREIGN KEY (`city_id`)
REFERENCES `cities`(`city_id`)
);

CREATE TABLE `item_types` (
`item_type_id` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(50) NOT NULL
);

CREATE TABLE `items` (
`item_id` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(50) NOT NULL,
`item_type_id` INT(11) NOT NULL,

CONSTRAINT fk_items_item_types
FOREIGN KEY (`item_type_id`)
REFERENCES `item_types`(`item_type_id`)
);

CREATE TABLE `orders`(
`order_id` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
`customer_id` INT(11) NOT NULL,

CONSTRAINT fk_orders_customers
FOREIGN KEY (`customer_id`)
REFERENCES `customers`(`customer_id`)
);

CREATE TABLE `order_items`(
`order_id` INT(11) NOT NULL,
`item_id` INT(11) NOT NULL,

CONSTRAINT pk_order_id_item_id
PRIMARY KEY (`order_id`,`item_id`),

CONSTRAINT fk_order_items_orders
FOREIGN KEY (`order_id`)
REFERENCES `orders`(`order_id`),

CONSTRAINT fk_order_items_items
FOREIGN KEY (`item_id`)
REFERENCES `items`(`item_id`)
);


#06. University Database

CREATE TABLE `majors`(
`major_id` INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL
);

CREATE TABLE `subjects`(
`subject_id` INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
`subject_name` VARCHAR(50) NOT NULL
);

CREATE TABLE `students`(
`student_id` INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
`student_number` VARCHAR(12) NOT NULL,
`student_name` VARCHAR(50) NOT NULL,
`major_id` INT(11) NOT NULL,

CONSTRAINT fk_students_majors
FOREIGN KEY (`major_id`)
REFERENCES `majors`(`major_id`)
);

CREATE TABLE `payments`(
`payment_id` INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
`payment_date` DATE NOT NULL,
`payments_amount` DECIMAL(8, 2) NOT NULL,
`student_id` INT(11) NOT NULL,

CONSTRAINT fk_payments_students
FOREIGN KEY (`student_id`)
REFERENCES `students`(`student_id`)
);

CREATE TABLE `agenda`(
`student_id` INT(11) NOT NULL,
`subject_id` INT(11) NOT NULL,

CONSTRAINT pk_student_id_subject_id
PRIMARY KEY (student_id, subject_id),

CONSTRAINT fk_agenda_students
FOREIGN KEY (`student_id`)
REFERENCES `students`(`student_id`),

CONSTRAINT fk_agenda_subjects
FOREIGN KEY (`subject_id`)
REFERENCES `subjects`(`subject_id`)
);


#09. Peaks in Rila

SELECT `mountain_range`, `peak_name`, `elevation` AS peak_elevation
FROM `peaks` as p
JOIN `mountains` as m
ON p.`mountain_id` = m.id
WHERE m.`mountain_range` = 'Rila'
ORDER BY peak_elevation DESC