CREATE PROCEDURE obtenerCarteleras()
BEGIN
    SELECT * FROM carteleras ORDER BY estaActivado DESC;
END