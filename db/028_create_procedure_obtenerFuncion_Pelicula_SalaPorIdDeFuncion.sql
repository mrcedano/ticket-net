CREATE PROCEDURE obtenerFuncion_Pelicula_SalaPorIdDeFuncion(IN funcionIdParam INT)
BEGIN
 SELECT funciones.id, funciones.activadesde, funciones.activahasta, peliculas.nombre AS pelicula_nombre, salas.nombre AS sala_nombre
     FROM funciones INNER JOIN peliculas ON funciones.pelicula_id = peliculas.id INNER JOIN salas ON funciones.sala_id = salas.id WHERE funciones.id = funcionIdParam;
END

