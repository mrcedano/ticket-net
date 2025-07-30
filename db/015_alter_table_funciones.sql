ALTER TABLE funciones ADD cartelera_id INT NOT NULL;

ALTER TABLE funciones
ADD CONSTRAINT fk_cartelera_id
FOREIGN KEY (cartelera_id)
REFERENCES carteleras(id);