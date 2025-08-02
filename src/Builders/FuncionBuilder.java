package Builders;

import DTOs.FuncionDto;
import java.time.LocalDateTime;

public class FuncionBuilder {
    private int id;
    private LocalDateTime activoDesde;
    private LocalDateTime activeHasta;
    private int pelicula_id;
    private int sala_id;
    private int cartelera_id;

    public FuncionBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public FuncionBuilder withActivoDesde(LocalDateTime activoDesde) {
        this.activoDesde = activoDesde;
        return this;
    }

    public FuncionBuilder withActivoHasta(LocalDateTime activeHasta) {
        this.activeHasta = activeHasta;
        return this;
    }

    public FuncionBuilder withPeliculaId(int pelicula_id) {
        this.pelicula_id = pelicula_id;
        return this;
    }

    public FuncionBuilder withSalaId(int sala_id) {
        this.sala_id = sala_id;
        return this;
    }

    public FuncionBuilder withCarteleraId(int cartelera_id) {
        this.cartelera_id = cartelera_id;
        return this;
    }

    public FuncionDto build() {
        return new FuncionDto(id, activoDesde, activeHasta, pelicula_id, sala_id, cartelera_id);
    }
}