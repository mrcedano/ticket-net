CREATE PROCEDURE obtenerFuncionPorId(IN funcionId INT)
BEGIN
	SELECT * FROM funciones WHERE id = funcionId;
END