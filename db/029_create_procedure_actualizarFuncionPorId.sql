CREATE PROCEDURE actualizarFuncionPorId(
    IN p_id INT,
    IN p_activadesde DATETIME,
    IN p_activahasta DATETIME,
    IN p_pelicula_id INT,
    IN p_sala_id INT
)
BEGIN
    UPDATE funciones
    SET
        activadesde = p_activadesde,
        activahasta = p_activahasta,
        pelicula_id = p_pelicula_id,
        sala_id = p_sala_id
    WHERE
        id = p_id;
END
