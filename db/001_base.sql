-- 1. Películas table
CREATE TABLE peliculas (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45),
  duracion TIME,
  publico VARCHAR(45),
  directores VARCHAR(255),
  actores VARCHAR(255),
  logo_filepath VARCHAR(255),
  PRIMARY KEY (id)
);

-- 2. Salas table
CREATE TABLE salas (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45),
  tipo VARCHAR(45),
  CantAsientos INT,
  PRIMARY KEY (id)
);

-- 3. Carteleras table
CREATE TABLE carteleras (
  id INT NOT NULL AUTO_INCREMENT,
  activadesde DATETIME,
  activahasta DATETIME,
  PRIMARY KEY (id)
);

-- 4. Función table
CREATE TABLE funciones (
  id INT NOT NULL AUTO_INCREMENT,
  activadesde DATETIME,
  activahasta DATETIME,
  pelicula_id INT,
  sala_id INT,
  PRIMARY KEY (id),
  FOREIGN KEY (pelicula_id) REFERENCES peliculas(id) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (sala_id) REFERENCES salas(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- 5. Películas_Carteleras table (junction table)
CREATE TABLE peliculas_carteleras(
  id INT NOT NULL AUTO_INCREMENT,
  pelicula_id INT NOT NULL,
  cartelera_id INT NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY(pelicula_id) REFERENCES peliculas(id) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY(cartelera_id) REFERENCES carteleras(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- 6. Asientos table
CREATE TABLE asientos (
  id INT NOT NULL AUTO_INCREMENT,
  sala_id INT,
  estado TINYINT(1),
  PRIMARY KEY (id),
  FOREIGN KEY (sala_id) REFERENCES salas(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- 7. Usuarios table
CREATE TABLE usuarios (
  id INT NOT NULL AUTO_INCREMENT,
  rol INT NOT NULL,
  nombre VARCHAR(45) NOT NULL,
  contrasenia VARCHAR(20) NOT NULL,
  PRIMARY KEY (id)
);

-- DELIMITER for stored procedures
DELIMITER $$

-- Altas (Insert) Procedures

CREATE DEFINER=`root`@`localhost` PROCEDURE `AltasCartelera`(
  IN acd DATETIME, 
  IN ach DATETIME
)
BEGIN
  INSERT INTO carteleras (activadesde, activahasta)
  VALUES (acd, ach);
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `AltasFuncion`(
  IN acd DATETIME, 
  IN ach DATETIME,
  IN pelicula INT,
  IN sala INT
)
BEGIN
  INSERT INTO funcion (activadesde, activahasta, pelicula_id, sala_id)
  VALUES (acd, ach, pelicula, sala);
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `AltasPelicula`(
  IN nom VARCHAR(45),
  IN dur TIME, 
  IN pub VARCHAR(45),
  IN dir VARCHAR(255), 
  IN act VARCHAR(255),
  IN logo VARCHAR(255)
)
BEGIN
  INSERT INTO peliculas (nombre, duracion, publico, directores, actores, logo_filepath)
  VALUES(nom, dur, pub, dir, act, logo);
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `AltasSala`(
  IN nom VARCHAR(45), 
  IN tipo VARCHAR(45), 
  IN can INT
)
BEGIN
  INSERT INTO salas (nombre, tipo, CantAsientos)
  VALUES (nom, tipo, can);
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `AltasAsiento`(
  IN sala INT,
  IN est TINYINT(1)
)
BEGIN
  INSERT INTO asientos (sala_id, estado)
  VALUES (sala, est);
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `AltasUsuario`(
  IN rol INT,
  IN nom VARCHAR(45),
  IN con VARCHAR(20)
)
BEGIN
  INSERT INTO usuarios (rol, nombre, contrasenia)
  VALUES (rol, nom, con);
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `AltasPeliculaCartelera`(
  IN pelicula INT,
  IN cartelera INT
)
BEGIN
  INSERT INTO peliculas_carteleras (pelicula_id, cartelera_id)
  VALUES (pelicula, cartelera);
END $$

-- Bajas (Delete) Procedures

CREATE DEFINER=`root`@`localhost` PROCEDURE `BajasCartelera`(IN idc INT)
BEGIN
  DELETE FROM carteleras WHERE id = idc;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `BajasFuncion`(IN idf INT)
BEGIN
  DELETE FROM funcion WHERE id = idf;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `BajasPelicula`(IN idp INT)
BEGIN
  DELETE FROM peliculas WHERE id = idp;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `BajasSala`(IN ids INT)
BEGIN
  DELETE FROM salas WHERE id = ids;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `BajasAsiento`(IN ida INT)
BEGIN
  DELETE FROM asientos WHERE id = ida;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `BajasUsuario`(IN idu INT)
BEGIN
  DELETE FROM usuarios WHERE id = idu;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `BajasPeliculaCartelera`(IN idpc INT)
BEGIN
  DELETE FROM peliculas_carteleras WHERE id = idpc;
END $$

-- Cambios (Update) Procedures

CREATE DEFINER=`root`@`localhost` PROCEDURE `CambiosSala`(
  IN nom VARCHAR(45),
  IN tip VARCHAR(45), 
  IN can INT,
  IN ids INT
)
BEGIN
  UPDATE salas
  SET nombre = nom, tipo = tip, CantAsientos = can
  WHERE id = ids;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CambiosCartelera`(
  IN acd DATETIME, 
  IN ach DATETIME, 
  IN idc INT
)
BEGIN
  UPDATE carteleras
  SET activadesde = acd, activahasta = ach
  WHERE id = idc;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CambiosFuncion`(
  IN acd DATETIME, 
  IN ach DATETIME, 
  IN pelicula INT,
  IN sala INT,
  IN idf INT
)
BEGIN
  UPDATE funcion
  SET activadesde = acd, activahasta = ach, pelicula_id = pelicula, sala_id = sala
  WHERE id = idf;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CambiosPelicula`(
  IN nom VARCHAR(45),
  IN dur TIME,
  IN pub VARCHAR(45),
  IN dir VARCHAR(255),
  IN act VARCHAR(255),
  IN logo VARCHAR(255),
  IN idp INT
)
BEGIN
  UPDATE peliculas
  SET nombre = nom, duracion = dur, publico = pub, directores = dir, actores = act, logo_filepath = logo
  WHERE id = idp;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CambiosAsiento`(
  IN sala INT,
  IN est TINYINT(1),
  IN ida INT
)
BEGIN
  UPDATE asientos
  SET sala_id = sala, estado = est
  WHERE id = ida;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CambiosUsuario`(
  IN rol INT,
  IN nom VARCHAR(45),
  IN con VARCHAR(20),
  IN idu INT
)
BEGIN
  UPDATE usuarios
  SET rol = rol, nombre = nom, contrasenia = con
  WHERE id = idu;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CambiosPeliculaCartelera`(
  IN pelicula INT,
  IN cartelera INT,
  IN idpc INT
)
BEGIN
  UPDATE peliculas_carteleras
  SET pelicula_id = pelicula, cartelera_id = cartelera
  WHERE id = idpc;
END $$

DELIMITER ;