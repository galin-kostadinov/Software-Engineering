#01. Table Design 

CREATE TABLE `coaches`(
`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(10) NOT NULL,
`last_name` VARCHAR(20) NOT NULL,
`salary` DECIMAL(10,2) NOT NULL DEFAULT 0,
`coach_level` INT NOT NULL DEFAULT 0
);

CREATE TABLE `countries`(
`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL
);

CREATE TABLE `towns`(
`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`country_id` INT NOT NULL,

CONSTRAINT fk_towns_countries
FOREIGN KEY (`country_id`)
REFERENCES `countries`(`id`)
);

CREATE TABLE `stadiums`(
`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`capacity` INT NOT NULL,
`town_id` INT NOT NULL,

CONSTRAINT fk_stadiums_towns
FOREIGN KEY (`town_id`)
REFERENCES `towns`(`id`)
);

CREATE TABLE `teams`(
`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`established` DATE NOT NULL,
`fan_base` BIGINT(20) NOT NULL DEFAULT 0,
`stadium_id` INT NOT NULL,

CONSTRAINT fk_teams_stadiums
FOREIGN KEY (`stadium_id`)
REFERENCES `stadiums`(`id`)
);

CREATE TABLE `skills_data`(
`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`dribbling` INT DEFAULT 0,
`pace` INT DEFAULT 0,
`passing` INT DEFAULT 0,
`shooting` INT DEFAULT 0,
`speed` INT DEFAULT 0,
`strength` INT DEFAULT 0
);

CREATE TABLE `players`(
`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(10) NOT NULL,
`last_name` VARCHAR(20) NOT NULL,
`age` INT NOT NULL DEFAULT 0,
`position` CHAR(1) NOT NULL,
`salary` DECIMAL(10,2) NOT NULL DEFAULT 0,
`hire_date` DATETIME,
`skills_data_id` INT NOT NULL,
`team_id` INT,

CONSTRAINT fk_players_skills_data
FOREIGN KEY (`skills_data_id`)
REFERENCES `skills_data`(id),

CONSTRAINT fk_players_teams
FOREIGN KEY (`team_id`)
REFERENCES `teams`(`id`)
);

CREATE TABLE `players_coaches`(
`player_id` INT,
`coach_id` INT,

CONSTRAINT pk_players_coaches
PRIMARY KEY (`player_id`, `coach_id`),

CONSTRAINT fk_players_coaches_players
FOREIGN KEY (`player_id`)
REFERENCES `players`(`id`),

CONSTRAINT fk_players_coaches_coaches
FOREIGN KEY (`coach_id`)
REFERENCES `coaches`(`id`)
);


#02. Insert 

INSERT INTO `coaches` (`first_name`, `last_name`, `salary`, coach_level)
SELECT p.`first_name`, p.`last_name`, p.`salary` * 2, char_length(p.`first_name`)
FROM `players` AS p
WHERE p.`age` >= 45;


#03. Update 

UPDATE `coaches` AS c
SET c.`coach_level` =  c.`coach_level` + 1
WHERE LEFT(c.`first_name`, 1) = 'A' AND
(SELECT result.caunt_pl FROM (
SELECT COUNT(pc.`player_id`) AS caunt_pl, co.id AS id_co
FROM `coaches` AS co
JOIN `players_coaches` AS pc
ON co.`id` = pc.`coach_id`
GROUP BY pc.`coach_id` ) AS result
WHERE c.`id` = result.id_co) >= 1;


#04. Delete
DELETE FROM `players` AS p
WHERE p.`age` >= 45;


#05. Players 

SELECT `first_name`, `age`, `salary` AS s
FROM `players`
ORDER BY s DESC;


#6. Young offense players without contract

SELECT p.`id`,concat_ws(' ', p.`first_name`,p.`last_name`) AS full_name, p.`age`, p.`position`, p.`hire_date`
FROM `players` AS p
JOIN `skills_data` AS sd
ON sd.`id` = p.`skills_data_id`
WHERE p.`age` < 23 AND p.`position` = 'A' AND p.`hire_date` IS NULL AND sd.`strength` > 50
ORDER BY p.`salary` ASC, p.`age` ASC;


#07. Detail info for all teams
SELECT t.`name` AS team_name, t.`established` , t.`fan_base`, COUNT(p.`team_id`) AS players_count
FROM `teams` AS t
LEFT JOIN `players` AS p
ON t.`id` = p.`team_id`
GROUP BY  t.`id`
ORDER BY players_count DESC, t.`fan_base` DESC;


#8. The fastest player by towns
SELECT MAX(sd.`speed`) AS max_speed, tw.`name` AS town_name
FROM `skills_data` AS sd
RIGHT JOIN `players` AS p
ON p.`skills_data_id` = sd.`id`
RIGHT JOIN `teams` AS t
ON p.`team_id` = t.`id`
RIGHT JOIN `stadiums` AS s
ON t.`stadium_id` = s.`id`
RIGHT JOIN `towns` AS tw
ON tw.`id` = s.`town_id`
WHERE t.`name` != 'Devify'
GROUP BY tw.`id`
ORDER BY max_speed DESC, tw.`name` ASC;


#09 Total salaries and players by country

SELECT ctr.`name`,  COUNT(p.`id`) AS total_count_of_players, SUM(p.`salary`) AS total_sum_of_salaries
FROM `skills_data` AS sd
RIGHT JOIN `players` AS p
ON p.`skills_data_id` = sd.`id`
RIGHT JOIN `teams` AS t
ON p.`team_id` = t.`id`
RIGHT JOIN `stadiums` AS s
ON t.`stadium_id` = s.`id`
RIGHT JOIN `towns` AS tw
ON tw.`id` = s.`town_id`
RIGHT JOIN `countries` AS ctr
ON tw.`country_id` = ctr.id
GROUP BY ctr.`name`
ORDER BY total_count_of_players DESC, ctr.name ASC;


#10. Find all players that play on stadium

DELIMITER $$
CREATE FUNCTION udf_stadium_players_count (p_stadium_name VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE  result INT;
	SET result := (
		SELECT COUNT(p.`id`)
		FROM `players` AS p
		JOIN `teams` AS t
		ON p.`team_id` = t.`id`
		JOIN `stadiums` AS s
		ON t.`stadium_id` = s.`id`
		WHERE s.`name` = p_stadium_name
	);
	RETURN result;
END $$
DELIMITER ;


#11. Find good playmaker by teams

DELIMITER $$
CREATE FUNCTION udf_stadium_players_count (p_stadium_name VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE  result INT;
	SET result := (
		SELECT COUNT(p.`id`)
		FROM `players` AS p
		JOIN `teams` AS t
		ON p.`team_id` = t.`id`
		JOIN `stadiums` AS s
		ON t.`stadium_id` = s.`id`
		WHERE s.`name` = p_stadium_name
	);
	RETURN result;
END $$
DELIMITER ;
