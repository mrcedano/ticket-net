DROP PROCEDURE AltasCartelera;

CREATE PROCEDURE `AltasCartelera`(
  IN acd DATE, 
  IN ach DATE,
  IN estaAct INT
)
BEGIN
  INSERT INTO carteleras (activadesde, activahasta, estaActivado)
  VALUES (acd, ach, estaAct);
END