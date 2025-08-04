	CREATE PROCEDURE crearBoleto(
		IN p_ninos INT,
		IN p_adultos INT,
		IN p_funcion_id INT,
		IN p_usuario_id INT,
		IN p_asientos VARCHAR(255)
	)
	BEGIN
		INSERT INTO boletos (ninos, adultos, funcion_id, usuario_id, asientos)
		VALUES (p_ninos, p_adultos, p_funcion_id, p_usuario_id, p_asientos);
	END