CREATE PROCEDURE eliminarSala (
    IN p_id INT
)
BEGIN
    DELETE FROM salas WHERE id = p_id;
END 