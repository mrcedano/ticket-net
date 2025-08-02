CREATE PROCEDURE consultarSala (
    IN p_id INT
)
BEGIN
    SELECT * 
    FROM salas 
    WHERE id = p_id;
END