package DTOs;

import java.time.LocalDateTime;

public class FuncionDto {
    private int id = 0;
    private LocalDateTime activoDesde = null;
    private LocalDateTime activeHasta = null;
    private int pelicula_id = 0;
    private int sala_id = 0;
    private int cartelera_id = 0;

    public FuncionDto(int id, LocalDateTime activoDesde, LocalDateTime activeHasta, int pelicula_id, int sala_id, int cartelera_id) {
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

    public LocalDateTime getActivoDesde() {
        return activoDesde;
    }

    public LocalDateTime getActiveHasta() {
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