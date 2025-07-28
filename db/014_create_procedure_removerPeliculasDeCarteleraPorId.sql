CREATE PROCEDURE removerPeliculasDeCarteleraPorId(IN carteleraIdParam INT)
BEGIN
	DELETE FROM peliculas_carteleras WHERE cartelera_id = carteleraIdParam;
END