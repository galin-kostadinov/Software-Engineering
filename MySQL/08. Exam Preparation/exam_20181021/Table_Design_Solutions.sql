#00. Table Design

create database colonial_journey_management_system_db;

CREATE TABLE `planets`(
`id` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(30)
);

CREATE TABLE `spaceports`(
`id` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(50),
`planet_id` INT(11) NOT NULL,

CONSTRAINT fk_spaceports_planets
FOREIGN KEY (`planet_id`)
REFERENCES `planets`(`id`)
);

CREATE TABLE `spaceships`(
`id` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(50) NOT NULL,
`manufacturer` VARCHAR(30) NOT NULL,
`light_speed_rate` INT(11) DEFAULT 0
);

CREATE TABLE `colonists`(
`id` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
`first_name` VARCHAR(20) NOT NULL,
`last_name` VARCHAR(20) NOT NULL,
`ucn` CHAR(10) NOT NULL UNIQUE,
`birth_date` DATE NOT NULL
);

CREATE TABLE `journeys`(
`id` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
`journey_start` DATETIME,
`journey_end` DATETIME,
`purpose` ENUM('Medical', 'Technical', 'Educational', 'Military'),
`destination_spaceport_id` INT(11) NOT NULL,
`spaceship_id` INT(11) NOT NULL,

CONSTRAINT fk_journeys_planets_spaceports
FOREIGN KEY (`destination_spaceport_id`)
REFERENCES `spaceports`(`id`),

CONSTRAINT fk_journeys_planets_spaceships
FOREIGN KEY (`spaceship_id`)
REFERENCES `spaceships`(`id`)
);

CREATE TABLE travel_cards(
`id` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
`card_number` CHAR(10) NOT NULL UNIQUE,
`job_during_journey` ENUM('Pilot', 'Engineer', 'Trooper', 'Cleaner', 'Cook'),
`colonist_id` INT(11) NOT NULL,
`journey_id` INT(11) NOT NULL,

CONSTRAINT fk_travel_cards_colonists
FOREIGN KEY (`colonist_id`)
REFERENCES `colonists`(`id`),

CONSTRAINT fk_travel_cards_journey_id
FOREIGN KEY (`journey_id`)
REFERENCES `journeys`(`id`)
);


#01. Insert

INSERT INTO `travel_cards`(`card_number`, `job_during_journey`, `colonist_id`, `journey_id`)
	SELECT
		(
		CASE
			WHEN c.`birth_date` > '1980-01-01' THEN concat_ws('', YEAR(c.`birth_date`), DAY(c.`birth_date`), LEFT(c.`ucn`, 4))
			ELSE concat_ws('', YEAR(c.`birth_date`), MONTH(c.`birth_date`), RIGHT(c.`ucn`, 4))
		END
		) AS card_number,

		(
		CASE
			WHEN c.`id`  % 2 = 0 THEN 'Pilot'
			WHEN c.`id`  % 3 = 0 THEN 'Cook'
			ELSE 'Engineer' 
		END
		) AS job_during_journey,

		c.`id`,
		LEFT(c.`ucn`, 1)  AS journey_id
	FROM `colonists` AS c
	WHERE c.`id` BETWEEN 96 AND 100;
    
#02. Update

UPDATE  `journeys` AS j
SET `purpose` = (
	CASE 
		WHEN j.`id` % 2 = 0 THEN 'Medical'
		WHEN j.`id` % 3 = 0 THEN 'Technical'
		WHEN j.`id` % 5 = 0 THEN 'Educational'
		WHEN j.`id` % 7 = 0 THEN 'Military'
        ELSE j.`purpose`
    END
);


#03. Delete

DELETE FROM `colonists` AS c
WHERE(SELECT tc.`journey_id` FROM `travel_cards` AS tc WHERE tc.`colonist_id` = c.`id`) IS NULL;


#04. Extract all travel cards

SELECT `card_number`, `job_during_journey`
FROM `travel_cards`
ORDER BY `card_number`;


#05. Extract all colonists

SELECT `id`, concat_ws(' ', `first_name`, `last_name`) AS full_name, `ucn`
FROM `colonists`
ORDER BY `first_name`, `last_name`, `id`;


#06 Extract all military journeys

SELECT `id`, `journey_start`, `journey_end`
FROM `journeys`
WHERE `purpose` = 'Military'
ORDER BY `journey_start`;


#07 Extract all pilots

SELECT c.`id`, concat_ws(' ', c.`first_name`, c.`last_name`) AS full_name
FROM `colonists` AS c
JOIN `travel_cards` AS tc
ON c.`id` = tc.`colonist_id`
WHERE tc.`job_during_journey` = 'Pilot'
ORDER BY c.`id`;


#08 Count all colonists that are on technical journey

SELECT count(*)
FROM `colonists` AS c
JOIN `travel_cards` AS tc
ON c.`id` = tc.`colonist_id`
JOIN `journeys` AS j
ON tc.`journey_id` = j.`id`
WHERE j.`purpose` = 'Technical';


#09.Extract the fastest spaceship

SELECT s.`name` AS spaceship_name, spport.`name` AS spaceport_name
FROM `spaceships` AS s
JOIN `journeys` AS j
ON s.`id` = j.`spaceship_id`
JOIN `spaceports` AS p
ON p.`id` = j.`destination_spaceport_id`
WHERE s.`light_speed_rate` = (SELECT MAX(`sp.light_speed_rate`) FROM `spaceships` AS sp);


#10.Extract spaceships with pilots younger than 30 years

SELECT s.`name`, s.`manufacturer`
FROM `spaceships` AS s
JOIN `journeys` AS j
ON s.`id` = j.`spaceship_id`
JOIN `spaceports` AS p
ON p.`id` = j.`destination_spaceport_id`
JOIN `travel_cards` AS tc
ON j.`id` = tc.`journey_id`
JOIN `colonists` AS c
ON c.`id` = tc.`colonist_id`
WHERE tc.`job_during_journey` = 'Pilot' AND (c.`birth_date`) > (DATE_SUB('2019-01-01', INTERVAL 30 YEAR))
ORDER BY s.name ASC;


#11. Extract all educational mission planets and spaceports

SELECT p.`name` AS planet_name, sp.`name` AS spaceport_name
FROM `spaceports` AS sp
JOIN `journeys` AS j
ON sp.`id` = j.`destination_spaceport_id`
JOIN `planets` AS p
ON p.`id` = sp.`planet_id`
WHERE j.`purpose` = 'Educational'
ORDER BY sp.`name` DESC;


#12. Extract all planets and their journey count

SELECT p.`name` AS planet_name, COUNT(*) AS journeys_count
FROM `spaceports` AS sp
JOIN `journeys` AS j
ON sp.`id` = j.`destination_spaceport_id`
JOIN `planets` AS p
ON p.`id` = sp.`planet_id`
GROUP BY p.`name`
ORDER BY journeys_count DESC, p.name ASC;


#13.Extract the shortest journey

SELECT j.`id`, p.name AS planet_name, sp.`name` AS spaceport_name, j.`purpose` AS journey_purpose
FROM `journeys` AS j
JOIN `spaceports` AS sp
ON sp.`id` = j.`destination_spaceport_id`
JOIN `planets` AS p
ON p.`id` = sp.`planet_id`
ORDER BY DATEDIFF(j.`journey_end`, j.`journey_start`)
LIMIT 1;


#14. Extract the less popular job
SELECT result.job_name
FROM
	(SELECT COUNT(tc.`job_during_journey`) AS count_job_title, tc.`job_during_journey` AS job_name, DATEDIFF(j.`journey_end`, j.`journey_start`) AS period
	FROM `travel_cards` AS tc
	JOIN `journeys` AS j
	ON j.`id` = tc.`journey_id`
	GROUP BY job_name, tc.`journey_id`
	ORDER BY period DESC, count_job_title ASC
	LIMIT 1) AS result;


#15. Get colonists count

DELIMITER $$
CREATE FUNCTION udf_count_colonists_by_destination_planet(planet_name VARCHAR (30))
	RETURNS INT
    BEGIN
		DECLARE count_result INT;
		SET count_result := (
			SELECT COUNT(tc.`colonist_id`)
			FROM `planets` as p
			JOIN `spaceports` as sp ON p.`id` = sp.`planet_id`
			JOIN `journeys` as j ON j.`destination_spaceport_id` = sp.`id`
			JOIN `travel_cards` as tc ON tc.`journey_id` = j.`id`
			WHERE p.`name` = planet_name);
		RETURN count_result;
	END $$
DELIMITER ;


#16. Modify spaceship

DELIMITER $$
CREATE PROCEDURE udp_modify_spaceship_light_speed_rate(spaceship_name VARCHAR(50), light_speed_rate_increse INT(11))
  BEGIN
	START TRANSACTION;
    IF (SELECT count(ss.`name`) FROM `spaceships` AS ss WHERE ss.`name` = spaceship_name > 0) THEN
		UPDATE spaceships AS ss
		SET ss.`light_speed_rate` = ss.`light_speed_rate` + light_speed_rate_increse
		WHERE name = spaceship_name;
    ELSE
      SIGNAL SQLSTATE '45000'
      SET MESSAGE_TEXT = 'Spaceship you are trying to modify does not exists.';
      ROLLBACK;
    END IF;
    
    IF ((SELECT ss.`light_speed_rate` FROM `spaceships` AS ss WHERE ss.`name` = `spaceship_name`) > 0) THEN COMMIT;
    ELSE 
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'Spaceship you are trying to modify does not exists.';
		ROLLBACK;
    END IF;
  END $$
DELIMITER ;
