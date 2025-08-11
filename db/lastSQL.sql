CREATE PROCEDURE obtenerBoletosCompradosPorUsuarioId(IN p_usuario_id INT)
BEGIN
	SELECT boletos.id AS boleto_id, funcion_id, ninos, adultos, total, peliculas.nombre AS pelicula, peliculas.logo_filepath as logo 
	FROM boletos 
    INNER JOIN funciones ON funciones.id = boletos.funcion_id INNER JOIN peliculas ON peliculas.id = funciones.pelicula_id WHERE usuario_id = p_usuario_id;
END

CREATE PROCEDURE actualizarUsuario(IN p_id INT, IN p_rol INT, IN p_nombre VARCHAR(255), IN p_contrasenia VARCHAR(255), IN p_correo VARCHAR(255), IN p_status INT)
BEGIN
	UPDATE usuarios SET rol = p_rol, nombre = p_nombre, contrasenia = p_contrasenia, correo = p_correo, status = p_status WHERE id = p_id;
END

CREATE PROCEDURE crearUsuario(IN p_role INT, IN p_username VARCHAR(45), IN p_password VARCHAR(20), IN p_email VARCHAR(255), IN p_status INT)
BEGIN
	INSERT INTO usuarios(rol, nombre, contrasenia, correo, status) VALUES (p_role, p_username, p_password, p_email, p_status);
END

CREATE PROCEDURE obtenerBoletoPorId(IN p_boleto_id INT)
BEGIN
	SELECT * FROM boletos WHERE id = p_boleto_id;
END

CREATE PROCEDURE obtenerFuncionPorId(IN p_funcion_id INT)
BEGIN
	SELECT * FROM funciones WHERE id = p_funcion_id;
END

	CREATE PROCEDURE crearBoleto(
		IN p_ninos INT,
		IN p_adultos INT,
		IN p_funcion_id INT,
		IN p_usuario_id INT,
		IN p_asientos VARCHAR(255),
		IN p_total INT
	)
	BEGIN
		INSERT INTO boletos (ninos, adultos, funcion_id, usuario_id, asientos, total)
		VALUES (p_ninos, p_adultos, p_funcion_id, p_usuario_id, p_asientos, p_total);
	END