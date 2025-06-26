DROP DATABASE IF EXISTS TicketNet;
CREATE DATABASE TicketNet;
USE TicketNet;

CREATE TABLE Peliculas (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45),
  duracion TIME,
  publico VARCHAR(45),
  directores VARCHAR(45),
  actores VARCHAR(45),
  PRIMARY KEY (id)
);

CREATE TABLE Salas (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45),
  tipo VARCHAR(45),
  CantAsientos INT,
  PRIMARY KEY (id)
);

CREATE TABLE Funciones (
  id INT NOT NULL AUTO_INCREMENT,
  activadesde DATETIME,
  activahasta DATETIME,
  idPeliculas INT,
  idSalas INT,
  PRIMARY KEY (id),
  FOREIGN KEY (idPeliculas) REFERENCES Peliculas(id),
  FOREIGN KEY (idSalas) REFERENCES Salas(id)
);

CREATE TABLE Carteleras (
  id INT NOT NULL AUTO_INCREMENT,
  idPeliculas INT,
  idFunciones INT,
  activadesde DATETIME,
  activahasta DATETIME,
  PRIMARY KEY (id),
  FOREIGN KEY (idPeliculas) REFERENCES Peliculas(id),
  FOREIGN KEY (idFunciones) REFERENCES Funciones(id)
);

CREATE TABLE Asientos (
  id INT NOT NULL AUTO_INCREMENT,
  idSalas INT,
  estado TINYINT(1),
  PRIMARY KEY (id),
  FOREIGN KEY (idSalas) REFERENCES Salas(id)
);

CREATE TABLE Usuarios (
  id INT NOT NULL AUTO_INCREMENT,
  rol INT NOT NULL,
  nombre VARCHAR(45),
  email VARCHAR(45),
  numero VARCHAR(45),
  PRIMARY KEY (id)
);

DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `AltasCartelera`(in acd datetime, in ach datetime)
BEGIN
	insert into Carteleras (id, idPeliculas, idFunciones, activadesde, activahasta)
    values (default, default, default, acd, ach);
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `AltasFuncion`(in acd datetime, in ach datetime)
BEGIN
	insert into Funciones (id, activadesde, activahasta, idPeliculas, idSalas)
    values (default, acd, ach, default, default);
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `AltasPelicula`(in nom varchar(45),in dur time, in pub varchar(45),in dir varchar(255), in act varchar(255))
BEGIN
	insert into Peliculas (id, nombre, duracion, publico, directores, actores)
    values(default, nom, dur, pub, dir, act);
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `AltasSala`(in nom varchar(45), in tipo varchar(45), in can int)
BEGIN
	insert into Salas (id, nombre, tipo, CantAsientos)
    values (default, nom, tipo, can);
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `BajasCartelera`(in idc int)
BEGIN
	DELETE FROM Carteleras WHERE id = idc;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `BajasFuncion`(in idf int)
BEGIN
	delete from Funciones where id = idf;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `BajasPelicula`(in idp int)
BEGIN
	delete from Peliculas where id = idp;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `BajasSala`(in ids int)
BEGIN
	delete from Salas where id = ids;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CambiosSala`(in nom varchar(45),in tip varchar(45), in can int, in ids int)
BEGIN
	update Salas
    set nombre = nom, tipo = tip, CantAsientos = can
    where id = ids;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CambiosCartelera`(in acd datetime, in ach datetime, in idc int)
BEGIN
	update Carteleras
    set activadesde = acd, activahasta = ach
    where id = idc;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CambiosFuncion`(in acd datetime, in ach datetime, in idf int)
BEGIN
	update Funciones
    set activadesde = acd, activahasta = ach
    where id = idf;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CambiosPelicula`(in nom varchar(45),in dur time,in pub varchar(45),in dir varchar(45),in act varchar(45),in idp int)
BEGIN
	update Peliculas
    set nombre = nom, duracion = dur, publico = pub, directores = dir, actores = act
    where id = idp;
END $$

DELIMITER ;
