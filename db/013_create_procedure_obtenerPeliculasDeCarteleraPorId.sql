CREATE PROCEDURE obtenerPeliculasDeCarteraPorId(IN carteleraIdParam INT)
BEGIN
    SELECT * FROM peliculas INNER JOIN peliculas_carteleras AS pc ON peliculas.id = pc.pelicula_id WHERE pc.cartelera_id = carteleraIdParam; 
END
