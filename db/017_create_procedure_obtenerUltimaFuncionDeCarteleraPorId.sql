CREATE PROCEDURE obtenerUltimaFuncionDeCarteleraPorId(IN cartelera_idParam INT)
BEGIN
	SELECT * FROM funciones WHERE cartelera_id = cartelera_idParam ORDER BY id DESC LIMIT 1;
END