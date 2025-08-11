CREATE PROCEDURE buscarFuncionesPorMesYAnioYCarteleraId(IN p_mes INT, IN p_anio INT, IN p_cartelera_id INT)
BEGIN
	SELECT DATE(activadesde) AS activadesde FROM funciones WHERE MONTH(activadesde) = p_mes AND YEAR(activadesde) = p_anio AND cartelera_id = p_cartelera_id GROUP BY DATE(activadesde);
END