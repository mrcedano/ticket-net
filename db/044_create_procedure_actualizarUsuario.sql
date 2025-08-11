CREATE PROCEDURE actualizarUsuario(IN p_id INT, IN p_rol INT, IN p_nombre VARCHAR(255), IN p_contrasenia VARCHAR(255), IN p_correo VARCHAR(255), IN p_status INT)
BEGIN
	UPDATE usuarios SET rol = p_rol, nombre = p_nombre, contrasenia = p_contrasenia, correo = p_correo, status = p_status WHERE id = p_id;
END