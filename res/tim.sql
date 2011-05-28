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

DROP TABLE IF EXISTS clients;
CREATE TABLE IF NOT EXISTS clients (
  client_id INTEGER(9) NOT NULL AUTO_INCREMENT,
  firstName VARCHAR(30) NOT NULL,
  lastName VARCHAR(30) NOT NULL,
  phone VARCHAR(30) NOT NULL,
  address VARCHAR(30) NOT NULL,
  description TEXT DEFAULT '',
  PRIMARY KEY (client_id)
) TYPE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO clients VALUES (1, 'Mireille', 'Goud', '021 333 33 33', 'rue du c', '');
INSERT INTO clients VALUES (2, 'Patrick', 'Lachaize', '021 444 44 44', 'rue du java', '');


DROP TABLE IF EXISTS employees;
CREATE TABLE IF NOT EXISTS employees (
  employee_id INTEGER(9) NOT NULL AUTO_INCREMENT,
  firstName VARCHAR(30) NOT NULL,
  lastName VARCHAR(30) NOT NULL,
  PRIMARY KEY (employee_id)
) TYPE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO employees VALUES (1, 'Alain', 'Bellatalla');
INSERT INTO employees VALUES (2, 'Mathieu', 'Noverraz');
INSERT INTO employees VALUES (3, 'Stefan', 'Meier');


DROP TABLE IF EXISTS appointments;
CREATE TABLE IF NOT EXISTS appointments (
  appointment_id VARCHAR(255) NOT NULL,
  client_id INTEGER(9) NOT NULL,
  employee_id INTEGER(9) NOT NULL,
  title VARCHAR(50) NOT NULL DEFAULT '',
  description TEXT NOT NULL DEFAULT '',
  PRIMARY KEY (appointment_id),
  FOREIGN KEY (client_id) REFERENCES clients(client_id)
    ON DELETE cascade,
  FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
    ON DELETE cascade
 ) TYPE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
 
 INSERT INTO appointments VALUES
(1, 1, 1, 'test1', 'description 1'),
(2, 2, 2, 'test2', 'description 2'),
(3, 2, 3, 'test3', 'description 3');

DROP TABLE IF EXISTS appointment_dates;
CREATE TABLE IF NOT EXISTS appointment_dates (
  appointment_date_id INTEGER(9) NOT NULL AUTO_INCREMENT,
  appointment_id VARCHAR(255) NOT NULL,
  begin DATETIME NOT NULL,
  end DATETIME NOT NULL,
  PRIMARY KEY (appointment_date_id),
  FOREIGN KEY (appointment_id) REFERENCES appointments(appointment_id)
    ON DELETE cascade
) TYPE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO appointment_dates VALUES
(1, 1, '2011-05-14 09:00', '2011-05-14 10:00'),
(2, 2, '2011-05-14 08:00', '2011-05-14 09:00'),
(3, 3, '2011-05-14 15:00', '2011-05-14 16:30');