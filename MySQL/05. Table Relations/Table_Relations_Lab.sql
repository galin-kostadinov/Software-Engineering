#01. Mountains and Peaks

CREATE TABLE `mountains` (
    `id` INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL
);

CREATE TABLE `peaks` (
    `id` INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL,
    `mountain_id` INT(11) NOT NULL,
    CONSTRAINT fk_peaks_mountiens FOREIGN KEY (`mountain_id`)
        REFERENCES mountains (id)
);


#02. Trip Organization

SELECT v.driver_id,
v.vehicle_type,
CONCAT(c.first_name, ' ', c.last_name) AS driver_name
FROM `campers` AS c
JOIN `vehicles` AS v
ON c.id = v.driver_id ; 


#03. SoftUni Hiking

SELECT r.starting_point,
r.end_point,
leader_id,
CONCAT(c.first_name, ' ', c.last_name)
FROM `routes` AS r, `campers` AS c
WHERE leader_id = c.id;


#04. Delete Mountains

CREATE TABLE `mountains` (
    `id` INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL
);

CREATE TABLE `peaks` (
    `id` INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL,
    `mountain_id` INT(11) NOT NULL,
    CONSTRAINT fk_peaks_mountiens FOREIGN KEY (`mountain_id`)
        REFERENCES mountains (id)
        ON DELETE CASCADE
);


#05. Project Management DB

CREATE TABLE projects (
    id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    client_id INT(11) NOT NULL,
    project_lead_id INT(11) NOT NULL
);

CREATE TABLE clients(
id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
client_name VARCHAR(100) NOT NULL,
project_id INT(11) NOT NULL
);

CREATE TABLE employees (
    id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    project_id INT(11) NOT NULL
);

ALTER TABLE clients
ADD CONSTRAINT fk_clients_projects
FOREIGN KEY (project_id)
REFERENCES projects(id);

ALTER TABLE projects
ADD CONSTRAINT fk_projects_clients
FOREIGN KEY (client_id)
REFERENCES clients(id);

ALTER TABLE projects
ADD CONSTRAINT fk_projects_employees
FOREIGN KEY (project_lead_id)
REFERENCES employees(id);

ALTER TABLE employees
ADD CONSTRAINT fk_employees_projects
FOREIGN KEY (project_id)
REFERENCES projects(id);