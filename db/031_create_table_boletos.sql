CREATE TABLE boletos(
	id INT AUTO_INCREMENT,
	ninos INT DEFAULT 0,
	adultos INT NOT NULL,
	total INT DEFAULT 0,
	funcion_id INT NOT NULL,
	asiento VARCHAR(15) NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(funcion_id) REFERENCES funciones(id)
);