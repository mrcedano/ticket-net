CREATE PROCEDURE crearSala (
    IN p_nombre VARCHAR(45),
    IN p_tipo VARCHAR(45),
    IN p_CantAsientos INT
)
BEGIN
    INSERT INTO salas (nombre, tipo, CantAsientos)
    VALUES (p_nombre, p_tipo, p_CantAsientos);
END