package DTOs;

import java.time.LocalDate;

public class FuncionDto {
    private int id;
    private LocalDate activoDesde;
    private LocalDate activeHasta;
    private int pelicula_id;
    private int sala_id;
    private int cartelera_id;

    public FuncionDto(int id, LocalDate activoDesde, LocalDate activeHasta, int pelicula_id, int sala_id, int cartelera_id) {
        this.id = id;
        this.activoDesde = activoDesde;
        this.activeHasta = activeHasta;
        this.pelicula_id = pelicula_id;
        this.sala_id = sala_id;
        this.cartelera_id = cartelera_id;
    }

    public int getId() {
        return id;
    }

    public LocalDate getActivoDesde() {
        return activoDesde;
    }

    public LocalDate getActiveHasta() {
        return activeHasta;
    }

    public int getPelicula_id() {
        return pelicula_id;
    }

    public int getSala_id() {
        return sala_id;
    }

    public int getCartelera_id() {
        return cartelera_id;
    }
}