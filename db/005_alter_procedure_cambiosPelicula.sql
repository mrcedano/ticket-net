DROP PROCEDURE IF EXISTS CambiosPelicula;

DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CambiosPelicula`(
  IN nom VARCHAR(45),
  IN dur VARCHAR(25),
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