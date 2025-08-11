CREATE PROCEDURE eliminarCarteleraPorId(IN p_cartelera_id INT) 
BEGIN
	DELETE FROM carteleras WHERE id = p_cartelera_id;
END