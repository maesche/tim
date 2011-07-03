/*
	Authors:		Alain Bellatalla
					Mathieu Noverraz
					Stefan Meier
	Version: 		20110703
	
	Description:	script to create tim database
				 
	Détails:		creation order needs to be respected (dependencies)

	To execute from command line interface :
	mysql --user=USR --password=PWD --default-character-set=utf8  < /tim.sql

*/

/*
 * As there exists no drop user if exists in mysql, the following work
 * around will do the job (described in http://bugs.mysql.com/bug.php?id=19166)
 */
GRANT USAGE ON *.* TO 'tim'@'localhost';
DROP USER 'tim'@'localhost';


/*
 * Create database and tables
 */

DROP DATABASE IF EXISTS tim;
CREATE DATABASE tim DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE tim;

CREATE USER 'tim'@'localhost' IDENTIFIED BY 'tim';
GRANT ALL PRIVILEGES ON *.* TO 'tim'@'localhost' WITH GRANT OPTION;

DROP TABLE IF EXISTS colors;
CREATE TABLE IF NOT EXISTS colors (
  color_id INTEGER(9) NOT NULL AUTO_INCREMENT,
  r INTEGER(3) NOT NULL,
  g INTEGER(3) NOT NULL,
  b INTEGER(3) NOT NULL,
  PRIMARY KEY (color_id)
) DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS calendars;
CREATE TABLE IF NOT EXISTS calendars (
  calendar_id INTEGER(9) NOT NULL AUTO_INCREMENT,
  color_id INTEGER(9) NOT NULL,
  PRIMARY KEY (calendar_id),
  FOREIGN KEY (color_id) REFERENCES colors(color_id)
  	ON DELETE cascade
) DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS clients;
CREATE TABLE IF NOT EXISTS clients (
  client_id INTEGER(9) NOT NULL AUTO_INCREMENT,
  firstName VARCHAR(30) NOT NULL,
  lastName VARCHAR(30) NOT NULL,
  phone VARCHAR(30) NOT NULL,
  address VARCHAR(250) NOT NULL,
  description TEXT,
  PRIMARY KEY (client_id)
) DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS employees;
CREATE TABLE IF NOT EXISTS employees (
  employee_id INTEGER(9) NOT NULL AUTO_INCREMENT,
  firstName VARCHAR(30) NOT NULL,
  lastName VARCHAR(30) NOT NULL,
  calendar_id INTEGER(9) NOT NULL,
  PRIMARY KEY (employee_id),
  FOREIGN KEY (calendar_id) REFERENCES calendars(calendar_id)
  	ON DELETE cascade
) DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS appointments;
CREATE TABLE IF NOT EXISTS appointments (
  appointment_id VARCHAR(255) NOT NULL,
  client_id INTEGER(9) NOT NULL,
  employee_id INTEGER(9) NOT NULL,
  description TEXT NOT NULL,
  PRIMARY KEY (appointment_id),
  FOREIGN KEY (client_id) REFERENCES clients(client_id)
    ON DELETE cascade,
  FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
    ON DELETE cascade
 ) DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS appointment_dates;
CREATE TABLE IF NOT EXISTS appointment_dates (
  appointment_date_id INTEGER(9) NOT NULL AUTO_INCREMENT,
  appointment_id VARCHAR(255) NOT NULL,
  begin DATETIME NOT NULL,
  end DATETIME NOT NULL,
  PRIMARY KEY (appointment_date_id),
  FOREIGN KEY (appointment_id) REFERENCES appointments(appointment_id)
    ON DELETE cascade
) DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*
 * Create dummy data
 */
INSERT INTO colors VALUES 
	(1, 255, 0, 0),
	(2, 0, 255, 0),
	(3, 0, 0, 255),
	(4, 255, 6, 200);
	
INSERT INTO calendars VALUES 
	(1, 1),
	(2, 2),
	(3, 3),
	(4, 4);

INSERT INTO `clients` VALUES 
(1,'Bill','Microsoft','095 959 59 59','Anywhere 95 1000 Lausanne',NULL),
(2,'Mac','Job','085 585 58 55','Funstreet 5 1000 Lausanne',NULL),
(3,'Gérard','Lacosse','077 777 77 77','Paradis 7 1000 Lausanne',NULL),
(4,'André','Kud','21 432 88 88','1033 Cheseaux',NULL),
(5,'Arthure','Migros','021 432 99 99','2000 Neuchâtel',NULL),
(6,'Alain','Possible','026 663 12 67','1400 Yverdon-les-Bains',NULL),
(7,'Stephen','Harper','021 333 33 33','Rue du Canada 23',''),
(8,'直人','管','021 444 44 44','総理大臣道路','null'),
(9,'Barak','Obama','021 333 33 33','Route des états-unis','null'),
(10,'Angela','Merkel','021 333 33 33','Bundespräsidentinnenplatz 45','null'),
(11,'Ruth','Dreifuss','021 333 33 33','Place des quatres jambes 3','null'),
(12,'Stefan','Apfel','021 333 33 33','Apple-Street 90','null'),
(13,'Nicolas','Sarkozy','021 333 33 33','Route du centre-droit 4','null'),
(14,'Heidi','Von der Alp','021 333 33 33','Peterweg 1','null');

INSERT INTO employees VALUES 
	(1, 'Alain', 'Bellatalla', 1), 
	(2, 'Mathieu', 'Noverraz', 2),
	(3, 'Stefan', 'Meier', 3);

INSERT INTO appointments VALUES
('1',1,1,'description 1'),
('2',2,2,'description 2'),
('3',3,3,'description 3'),
('4',4,1,'description 4'),
('5',5,2,'description 5'),
('6',6,3,'description 6'),
('7',7,1,'description 7'),
('8',8,2,'description 8'),
('9',1,3,'description 9'),
('10',2,1,'description 10'),
('11',3,2,'description 11'),
('12',4,3,'description 12'),
('13',5,1,'description 13'),
('14',6,2,'description 14'),
('15',7,3,'description 15'),
('16',8,1,'description 16'),
('17',1,2,'description 17'),
('18',2,3,'description 18'),
('19',3,1,'description 19'),
('20',4,2,'description 20'),
('21',5,3,'description 21'),
('22',6,1,'description 22'),
('23',7,2,'description 23'),
('24',8,3,'description 24'),
('25',1,1,'description 25'),
('26',2,2,'description 26'),
('27',3,3,'description 27'),
('28',4,1,'description 28'),
('29',5,2,'description 29'),
('30',6,3,'description 30'),
('31',7,1,'description 31'),
('32',8,2,'description 32'),
('33',1,3,'description 33'),
('34',2,1,'description 34'),
('35',3,2,'description 35'),
('36',4,3,'description 36'),
('37',5,1,'description 37'),
('38',6,2,'description 38'),
('39',7,3,'description 39'),
('40',8,1,'description 40'),
('41',1,2,'description 41'),
('42',2,3,'description 42'),
('43',3,1,'description 43'),
('44',4,2,'description 44'),
('45',5,3,'description 45'),
('46',6,1,'description 46'),
('47',7,2,'description 47'),
('48',8,3,'description 48'),
('49',1,1,'description 49'),
('50',2,2,'description 50'),
('51',3,3,'description 51'),
('52',4,1,'description 52'),
('53',5,2,'description 53'),
('54',6,3,'description 54'),
('55',7,1,'description 55'),
('56',8,2,'description 56');

INSERT appointment_dates VALUES
('1',1,'2011-6-27 8:00','2011-6-27 11:00'),
('2',2,'2011-6-27 8:30','2011-6-27 11:30'),
('3',3,'2011-6-27 9:00','2011-6-27 12:30'),
('4',4,'2011-6-27 13:30','2011-6-27 17:30'),
('5',5,'2011-6-27 14:00','2011-6-27 18:00'),
('6',6,'2011-6-27 13:00','2011-6-27 18:30'),
('7',7,'2011-6-28 8:00','2011-6-28 11:00'),
('8',8,'2011-6-28 8:30','2011-6-28 11:30'),
('9',9,'2011-6-28 9:00','2011-6-28 12:30'),
('10',10,'2011-6-28 13:30','2011-6-28 17:30'),
('11',11,'2011-6-28 14:00','2011-6-28 18:00'),
('12',12,'2011-6-28 13:00','2011-6-28 18:30'),
('13',13,'2011-6-29 8:00','2011-6-29 11:00'),
('14',14,'2011-6-29 8:30','2011-6-29 11:30'),
('15',15,'2011-6-29 9:00','2011-6-29 12:30'),
('16',16,'2011-6-29 13:30','2011-6-29 17:30'),
('17',17,'2011-6-29 14:00','2011-6-29 18:00'),
('18',18,'2011-6-29 13:00','2011-6-29 18:30'),
('19',19,'2011-6-30 8:00','2011-6-30 11:00'),
('20',20,'2011-6-30 8:30','2011-6-30 11:30'),
('21',21,'2011-6-30 9:00','2011-6-30 12:30'),
('22',22,'2011-6-30 13:30','2011-6-30 17:30'),
('23',23,'2011-6-30 14:00','2011-6-30 18:00'),
('24',24,'2011-6-30 13:00','2011-6-30 18:30'),
('25',25,'2011-7-1 8:00','2011-7-1 11:00'),
('26',26,'2011-7-1 8:30','2011-7-1 11:30'),
('27',27,'2011-7-1 9:00','2011-7-1 12:30'),
('28',28,'2011-7-1 13:30','2011-7-1 17:30'),
('29',29,'2011-7-1 14:00','2011-7-1 18:00'),
('30',30,'2011-7-1 13:00','2011-7-1 18:30'),
('31',31,'2011-7-2 8:00','2011-7-2 11:00'),
('32',32,'2011-7-2 8:30','2011-7-2 11:30'),
('33',33,'2011-7-2 9:00','2011-7-2 12:30'),
('34',34,'2011-7-2 13:30','2011-7-2 17:30'),
('35',35,'2011-7-2 14:00','2011-7-2 18:00'),
('36',36,'2011-7-2 13:00','2011-7-2 18:30'),
('37',37,'2011-7-3 8:00','2011-7-3 11:00'),
('38',38,'2011-7-3 8:30','2011-7-3 11:30'),
('39',39,'2011-7-3 9:00','2011-7-3 12:30'),
('40',40,'2011-7-3 13:30','2011-7-3 17:30'),
('41',41,'2011-7-3 14:00','2011-7-3 18:00'),
('42',42,'2011-7-3 13:00','2011-7-3 18:30'),
('43',43,'2011-7-4 8:00','2011-7-4 11:00'),
('44',44,'2011-7-4 8:30','2011-7-4 11:30'),
('45',45,'2011-7-4 9:00','2011-7-4 12:30'),
('46',46,'2011-7-4 13:30','2011-7-4 17:30'),
('47',47,'2011-7-4 14:00','2011-7-4 18:00'),
('48',48,'2011-7-4 13:00','2011-7-4 18:30'),
('49',49,'2011-7-5 8:00','2011-7-5 11:00'),
('50',50,'2011-7-5 8:30','2011-7-5 11:30'),
('51',51,'2011-7-5 9:00','2011-7-5 12:30'),
('52',52,'2011-7-5 13:30','2011-7-5 17:30'),
('53',53,'2011-7-5 14:00','2011-7-5 18:00'),
('54',54,'2011-7-5 13:00','2011-7-5 18:30'),
('55',55,'2011-7-6 8:00','2011-7-6 11:00'),
('56',56,'2011-7-6 8:30','2011-7-6 11:30');