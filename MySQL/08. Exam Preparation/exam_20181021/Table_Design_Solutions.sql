#00. Table Design

create database colonial_journey_management_system_db;

CREATE TABLE planets(
id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(30)
);

CREATE TABLE spaceports(
id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50),
planet_id INT(11) NOT NULL,

CONSTRAINT fk_spaceports_planets
FOREIGN KEY (planet_id)
REFERENCES planets(id)
);

CREATE TABLE spaceships(
id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) NOT NULL,
manufacturer VARCHAR(30) NOT NULL,
light_speed_rate INT(11) DEFAULT 0
);

CREATE TABLE colonists(
id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(20) NOT NULL,
last_name VARCHAR(20) NOT NULL,
ucn CHAR(10) NOT NULL UNIQUE,
birth_date DATE NOT NULL
);

CREATE TABLE journeys(
id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
journey_start DATETIME,
journey_end DATETIME,
purpose ENUM('Medical', 'Technical', 'Educational', 'Military'),
destination_spaceport_id INT(11) NOT NULL,
spaceship_id INT(11) NOT NULL,

CONSTRAINT fk_journeys_planets_spaceports
FOREIGN KEY (destination_spaceport_id)
REFERENCES spaceports(id),

CONSTRAINT fk_journeys_planets_spaceships
FOREIGN KEY (spaceship_id)
REFERENCES spaceships(id)
);

CREATE TABLE travel_cards(
id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
card_number CHAR(10) NOT NULL UNIQUE,
job_during_journey ENUM('Pilot', 'Engineer', 'Trooper', 'Cleaner', 'Cook'),
colonist_id INT(11) NOT NULL,
journey_id INT(11) NOT NULL,

CONSTRAINT fk_travel_cards_colonists
FOREIGN KEY (colonist_id)
REFERENCES colonists(id),

CONSTRAINT fk_travel_cards_journey_id
FOREIGN KEY (journey_id)
REFERENCES journeys(id)
);


#01. Insert

INSERT INTO travel_cards(card_number, job_during_journey, colonist_id, journey_id)
	SELECT
		(
		CASE
			WHEN c.birth_date > '1980-01-01' THEN concat_ws('', YEAR(c.birth_date), DAY(c.birth_date), LEFT(c.ucn, 4))
			ELSE concat_ws('', YEAR(c.birth_date), MONTH(c.birth_date), RIGHT(c.ucn, 4))
		END
		) AS card_number,

		(
		CASE
			WHEN c.id  % 2 = 0 THEN 'Pilot'
			WHEN c.id  % 3 = 0 THEN 'Cook'
			ELSE 'Engineer' 
		END
		) AS job_during_journey,

		c.id,
		LEFT(c.ucn, 1)  AS journey_id
	FROM colonists AS c
	WHERE c.id BETWEEN 96 AND 100;
    


