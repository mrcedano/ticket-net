CREATE PROCEDURE obtenerNumeroDeAsientosOcupadosPorFuncionId(IN p_funcion_id INT)
BEGIN
	SELECT SUM(ninos + adultos) AS total FROM boletos WHERE funcion_id = p_funcion_id;
END
