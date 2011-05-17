/*
	Auteur: Alain Bellatalla
			Mathieu Noverraz
			Stefan Meier
	Version: 201105.07
	
	Description: script de création de tables pour la base
				 tim)
				 
	Détails: 	 l'ordre de création est à respecter (contraintes)

	Restauration d'un fichier: 
	mysql --user=USR --password=PWD --default-character-set=utf8  < /iafbm_personnes.sql

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


DROP TABLE IF EXISTS employes;
CREATE TABLE IF NOT EXISTS employes (
  employe_id INTEGER(9) NOT NULL AUTO_INCREMENT,
  firstName VARCHAR(30) NOT NULL,
  lastName VARCHAR(30) NOT NULL,
  PRIMARY KEY (employe_id)
) TYPE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO employes VALUES (1, 'Alain', 'Bellatalla');
INSERT INTO employes VALUES (2, 'Mathieu', 'Noverraz');
INSERT INTO employes VALUES (3, 'Stefan', 'Meier');


DROP TABLE IF EXISTS appointments;
CREATE TABLE IF NOT EXISTS appointments (
  appointment_id VARCHAR(255) NOT NULL,
  client_id INTEGER(9) NOT NULL,
  employe_id INTEGER(9) NOT NULL,
  begin DATETIME NOT NULL,
  end DATETIME NOT NULL,
  title VARCHAR(50) NOT NULL DEFAULT '',
  description TEXT NOT NULL DEFAULT '',
  PRIMARY KEY (appointment_id),
  FOREIGN KEY (client_id) REFERENCES clients(client_id)
    ON DELETE cascade,
  FOREIGN KEY (employe_id) REFERENCES employes(employe_id)
    ON DELETE cascade
 ) TYPE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



INSERT INTO appointments VALUES
(1, 1, 1, '2011-05-14 09:00', '2011-05-14 10:00', 'test1', ''),
(2, 2, 2, '2011-05-14 08:00', '2011-05-14 09:00', 'test2', ''),
(3, 2, 3, '2011-05-14 15:00', '2011-05-14 16:30', 'test3', '');