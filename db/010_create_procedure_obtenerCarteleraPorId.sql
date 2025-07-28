CREATE PROCEDURE buscarCarteleraPorId(IN idParam INT)
BEGIN
	SELECT * FROM carteleras WHERE id = idParam;
END
