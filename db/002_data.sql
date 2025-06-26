-- Peliculas
INSERT INTO Peliculas (nombre, duracion, publico, directores, actores) VALUES
('Inception', '02:28:00', 'PG-13', 'Christopher Nolan', 'Leonardo DiCaprio'),
('The Matrix', '02:16:00', 'R', 'The Wachowskis', 'Keanu Reeves'),
('Interstellar', '02:49:00', 'PG-13', 'Christopher Nolan', 'Matthew McConaughey'),
('Toy Story', '01:21:00', 'G', 'John Lasseter', 'Tom Hanks'),
('The Godfather', '02:55:00', 'R', 'Francis Ford Coppola', 'Marlon Brando');

-- Salas
INSERT INTO Salas (nombre, tipo, CantAsientos) VALUES
('Sala 1', 'IMAX', 120),
('Sala 2', '3D', 100),
('Sala 3', 'Normal', 80),
('Sala 4', 'VIP', 60),
('Sala 5', 'Normal', 90);

-- Funciones (assuming pelicula_id 1-5 and sala_id 1-5)
INSERT INTO Funciones (activadesde, activahasta, peliculas_id, salas_id) VALUES
('2025-07-01 18:00:00', '2025-07-01 20:30:00', 1, 1),
('2025-07-01 21:00:00', '2025-07-01 23:16:00', 2, 2),
('2025-07-02 17:00:00', '2025-07-02 19:49:00', 3, 3),
('2025-07-02 15:00:00', '2025-07-02 16:21:00', 4, 4),
('2025-07-03 19:00:00', '2025-07-03 21:55:00', 5, 5);

-- Carteleras (assuming peliculas_id 1-5, funciones_id 1-5)
INSERT INTO Carteleras (peliculas_id, funciones_id, activadesde, activahasta) VALUES
(1, 1, '2025-07-01 18:00:00', '2025-07-01 20:30:00'),
(2, 2, '2025-07-01 21:00:00', '2025-07-01 23:16:00'),
(3, 3, '2025-07-02 17:00:00', '2025-07-02 19:49:00'),
(4, 4, '2025-07-02 15:00:00', '2025-07-02 16:21:00'),
(5, 5, '2025-07-03 19:00:00', '2025-07-03 21:55:00');

-- Asientos (assuming salas_id 1-5)
INSERT INTO Asientos (salas_id, estado) VALUES
(1, 1),
(2, 1),
(3, 0),
(4, 1),
(5, 0);

-- Usuarios
INSERT INTO Usuarios (rol, nombre, contrasenia) VALUES
(0, 'admin', 'admin123'),   
(1, 'juan', 'juanpass'),   
(1, 'maria', 'mariapass'),  
(2, 'carlos', 'carlospass'),
(2, 'sofia', 'sofiapass');  
