CREATE PROCEDURE actualizarSala (
    IN p_id INT,
    IN p_nombre VARCHAR(45),
    IN p_tipo VARCHAR(45),
    IN p_CantAsientos INT,
    IN p_estaDisponible INT
)
BEGIN
    UPDATE salas
    SET
        nombre = p_nombre,
        tipo = p_tipo,
        CantAsientos = p_CantAsientos,
        estaDisponible = p_estaDisponible
    WHERE
        id = p_id;
END
