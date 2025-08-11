CREATE PROCEDURE buscarFuncionesPorMesYAnioYPeliculaIdYCarteleraId(IN p_mes INT, IN p_anio INT, IN p_pelicula_id INT, IN p_cartelera_id INT)
BEGIN
	SELECT * FROM funciones WHERE MONTH(activadesde) = p_mes AND YEAR(activadesde) = p_anio AND pelicula_id = p_pelicula_id AND cartelera_id = p_cartelera_id;
END
