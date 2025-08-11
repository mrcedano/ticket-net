CREATE PROCEDURE  (IN p_id INT)
BEGIN
	UPDATE usuarios SET status = 0 WHERE id = p_id;
END
