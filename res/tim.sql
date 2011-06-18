/*
	Auteur: Alain Bellatalla
			Mathieu Noverraz
			Stefan Meier
	Version: 201105.07
	
	Description: script de création de tables pour la base
				 tim)
				 
	Détails: 	 l'ordre de création est à respecter (contraintes)

	Restauration d'un fichier depuis la ligne de commande: 
	mysql --user=USR --password=PWD --default-character-set=utf8  < /tim.sql

*/
DROP DATABASE IF EXISTS tim;
CREATE DATABASE tim DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE tim;



DROP TABLE IF EXISTS colors;
CREATE TABLE IF NOT EXISTS colors (
  color_id INTEGER(9) NOT NULL AUTO_INCREMENT,
  r INTEGER(3) NOT NULL,
  g INTEGER(3) NOT NULL,
  b INTEGER(3) NOT NULL,
  PRIMARY KEY (color_id)
) DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


INSERT INTO colors VALUES 
	(1, 255, 0, 0),
	(2, 0, 255, 0),
	(3, 0, 0, 255),
	(4, 255, 6, 200);

DROP TABLE IF EXISTS calendars;
CREATE TABLE IF NOT EXISTS calendars (
  calendar_id INTEGER(9) NOT NULL AUTO_INCREMENT,
  color_id INTEGER(9) NOT NULL,
  PRIMARY KEY (calendar_id),
  FOREIGN KEY (color_id) REFERENCES colors(color_id)
  	ON DELETE cascade
) DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO calendars VALUES 
	(1, 1),
	(2, 2),
	(3, 3),
	(4, 4);

DROP TABLE IF EXISTS clients;
CREATE TABLE IF NOT EXISTS clients (
  client_id INTEGER(9) NOT NULL AUTO_INCREMENT,
  firstName VARCHAR(30) NOT NULL,
  lastName VARCHAR(30) NOT NULL,
  phone VARCHAR(30) NOT NULL,
  address VARCHAR(30) NOT NULL,
  description TEXT,
  PRIMARY KEY (client_id)
) DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO clients VALUES 
	(1, 'Mireille', 'Goud', '021 333 33 33', 'rue du c', ''),
	(2, 'Patrick', 'Lachaize', '021 444 44 44', 'rue du java', '');

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

INSERT INTO employees VALUES 
	(1, 'Alain', 'Bellatalla', 1), 
	(2, 'Mathieu', 'Noverraz', 2),
	(3, 'Stefan', 'Meier', 3);


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
 
INSERT INTO appointments VALUES
	(1, 1, 1, 'description 1'),
	(2, 2, 2, 'description 2'),
	(3, 2, 3, 'description 3');

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

INSERT INTO appointment_dates VALUES
	(1, 1, '2011-05-14 09:00', '2011-05-14 10:00'),
	(2, 2, '2011-05-14 08:00', '2011-05-14 09:00'),
	(3, 3, '2011-05-14 15:00', '2011-05-14 16:30');
