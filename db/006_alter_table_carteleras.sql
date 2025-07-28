DELETE FROM carteleras;

ALTER TABLE carteleras CHANGE activadesde activadesde DATE NOT NULL;
ALTER TABLE carteleras CHANGE activahasta activahasta DATE NOT NULL;

ALTER TABLE carteleras ADD COLUMN estaActivado INT DEFAULT 0;
