-- 1. Películas
INSERT INTO peliculas (nombre, duracion, publico, directores, actores, logo_filepath) VALUES
('Matrix',      '02:16:00', 'Adultos',     'Lana Wachowski, Lilly Wachowski', 'Keanu Reeves, Carrie-Anne Moss', 'resources/matrix.png'),
('Toy Story',   '01:21:00', 'Todos',       'John Lasseter',                   'Tom Hanks, Tim Allen',           'resources/toystory.png'),
('Titanic',     '03:14:00', 'Mayores 13',  'James Cameron',                   'Leonardo DiCaprio, Kate Winslet','resources/titanic.png'),
('Forrest Gump','02:22:00', 'Mayores 13',  'Robert Zemeckis',                 'Tom Hanks, Robin Wright',        'resources/forrestgump.png'),
('Inception',   '02:28:00', 'Mayores 13',  'Christopher Nolan',               'Leonardo DiCaprio, Ellen Page',  'resources/inception.png');

-- 2. Salas
INSERT INTO salas (nombre, tipo, CantAsientos) VALUES
('Sala 1', '2D', 100),
('Sala 2', '3D', 80),
('Sala 3', 'IMAX', 120),
('Sala 4', '4DX', 60),
('Sala 5', '2D', 90);

-- 3. Carteleras
INSERT INTO carteleras (activadesde, activahasta) VALUES
('2025-06-01 00:00:00', '2025-06-30 23:59:59'),
('2025-07-01 00:00:00', '2025-07-31 23:59:59'),
('2025-08-01 00:00:00', '2025-08-31 23:59:59'),
('2025-09-01 00:00:00', '2025-09-30 23:59:59'),
('2025-10-01 00:00:00', '2025-10-31 23:59:59');

-- 4. Usuarios
INSERT INTO usuarios (rol, nombre, contrasenia) VALUES
(1, 'admin',    'adminpass'),
(2, 'juan',     'juan123'),
(2, 'maria',    'maria123'),
(3, 'pedro',    'pedro123'),
(3, 'lucia',    'lucia123');

-- 5. Funciones (use valid pelicula_id and sala_id, e.g. 1-5 for both)
INSERT INTO funciones (activadesde, activahasta, pelicula_id, sala_id) VALUES
('2025-06-05 18:00:00', '2025-06-05 20:30:00', 1, 1), -- Matrix en Sala 1
('2025-06-06 15:00:00', '2025-06-06 17:00:00', 2, 2), -- Toy Story en Sala 2
('2025-06-07 20:00:00', '2025-06-07 23:30:00', 3, 3), -- Titanic en Sala 3
('2025-06-08 19:00:00', '2025-06-08 21:30:00', 4, 4), -- Forrest Gump en Sala 4
('2025-06-09 21:00:00', '2025-06-09 23:30:00', 5, 5); -- Inception en Sala 5

-- 6. Asientos (for Sala 1-5, estado alternando 1 y 0)
INSERT INTO asientos (sala_id, estado) VALUES
(1, 1),
(2, 0),
(3, 1),
(4, 0),
(5, 1);

-- 7. Películas_Carteleras (link pelicula_id to cartelera_id)
INSERT INTO peliculas_carteleras (pelicula_id, cartelera_id) VALUES
(1, 1), -- Matrix en cartelera 1
(2, 1), -- Toy Story en cartelera 1
(3, 2), -- Titanic en cartelera 2
(4, 3), -- Forrest Gump en cartelera 3
(5, 4); -- Inception en cartelera 4