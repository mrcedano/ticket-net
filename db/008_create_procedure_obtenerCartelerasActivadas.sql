CREATE PROCEDURE obtenerCartelerasActivas ()
BEGIN
	SELECT COUNT(id) AS carteleras_activadas FROM carteleras WHERE estaActivado = 1;
END