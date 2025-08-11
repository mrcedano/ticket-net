CREATE PROCEDURE activarUsuario(IN p_id INT)
BEGIN
	UPDATE usuarios SET status = 1 WHERE id = p_id;
END