--Connection à la base donnée  ( \c);


-- sudo -s -u postgres

-- Creation de l'utilisateur d la base de donnée s'il n'existe pas 
CREATE USER tintin WITH PASSWORD 'milou'; 

-- supression et recreation de la base de donnée
DROP DATABASE testbd;
CREATE DATABASE testbd;

-- connexion à la base de donnée 
\c testbd;     

--supression de la table utilisation si elle existe
DROP TABLE IF EXISTS utilisateur;

--creation de la table
CREATE TABLE utilisateur(
   	id SERIAL  PRIMARY KEY,
 	email varchar(60) not null,
 	mot_de_passe VARCHAR( 32 ) NOT NULL ,
 	nom VARCHAR( 20 ) NOT NULL

);


--INSERT INTO utilisateur (email, mot_de_passe, nom) VALUES ('coyote@mail.acme', 'bipbip', 'Coyote');
--INSERT INTO utilisateur (email, mot_de_passe, nom) VALUES ('jadorejquery@unefois.be', 'avecdesfrites', 'Thunderseb');

-- droits de l'utilisteur "tintin"
GRANT SELECT ON utilisateur TO tintin;
GRANT INSERT ON utilisateur TO tintin;
GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA public TO tintin;

-- requette test
SELECT id, email, nom FROM utilisateur;

