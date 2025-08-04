CREATE PROCEDURE obtenerFuncionesDePeliculaPorCarteleraIdAndPeliculaId(IN p_cartelera_id INT, IN p_pelicula_id INT) 
BEGIN
	SELECT * FROM funciones WHERE cartelera_id = p_cartelera_id AND pelicula_id = p_pelicula_id;
END
    