CREATE PROCEDURE obtenerCarteleraActiva()
BEGIN
	SELECT * FROM carteleras WHERE estaActivado = 1 LIMIT 1;
END
