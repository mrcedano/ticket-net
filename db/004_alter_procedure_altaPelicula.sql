DROP PROCEDURE IF EXISTS AltasPelicula;

DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `AltasPelicula`(
  IN nom VARCHAR(45),
  IN dur VARCHAR(25), 
  IN pub VARCHAR(45),
  IN dir VARCHAR(255), 
  IN act VARCHAR(255),
  IN logo VARCHAR(255)
)
BEGIN
  INSERT INTO peliculas (nombre, duracion, publico, directores, actores, logo_filepath)
  VALUES(nom, dur, pub, dir, act, logo);
END $$

DELIMITER ;
