CREATE PROCEDURE actualizarCarteleraPorId(IN idParam INT, IN activadesdeParam DATE, IN activahastaParam DATE, IN estaActivadoParam INT) 
BEGIN
	UPDATE carteleras SET activadesde = activadesdeParam, activahasta = activahastaParam, estaActivado = estaActivadoParam WHERE id = idParam; 
END
