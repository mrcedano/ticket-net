CREATE PROCEDURE obtenerFuncion_Pelicula_SalaPorIdDeFuncion(IN funcionIdParam INT)
BEGIN
 SELECT 
 	funciones.id, funciones.activadesde, funciones.activahasta, peliculas.id AS pelicula_id, peliculas.nombre AS pelicula_nombre, peliculas.logo_filepath AS pelicula_logo, salas.id AS sala_id , salas.nombre AS sala_nombre, 
 		salas.CantAsientos AS sala_CantAsientos 
     FROM funciones INNER JOIN peliculas ON funciones.pelicula_id = peliculas.id INNER JOIN salas ON funciones.sala_id = salas.id 
 WHERE funciones.id = funcionIdParam;
END