CREATE PROCEDURE CrearFuncion(IN activoDesdeArg DATETIME, IN activoHastaArg DATETIME, IN pelicula_idArg INT, IN sala_idArg INT, IN cartelera_idArg INT)
BEGIN
	INSERT INTO funciones(activadesde, activahasta, pelicula_id, sala_id, cartelera_id) VALUES (activoDesdeArg, activoHastaArg, pelicula_idArg, sala_idArg, cartelera_idArg);
END
