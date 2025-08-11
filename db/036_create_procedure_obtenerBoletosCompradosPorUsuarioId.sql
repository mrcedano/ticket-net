CREATE PROCEDURE obtenerBoletosCompradosPorUsuarioId(IN p_usuario_id INT)
BEGIN
	SELECT funcion_id, SUM(ninos) AS ninos, SUM(adultos) AS adultos, SUM(total) AS total, peliculas.nombre AS pelicula, peliculas.logo_filepath as logo 
	FROM boletos 
    INNER JOIN funciones ON funciones.id = boletos.funcion_id INNER JOIN peliculas ON peliculas.id = funciones.pelicula_id WHERE usuario_id = p_usuario_id
	GROUP BY funciones.id;
END
