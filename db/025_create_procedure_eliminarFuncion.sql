CREATE PROCEDURE eliminarFuncionPorId(IN funcionId INT)
BEGIN
	DELETE FROM funciones WHERE id = funcionId;
END
