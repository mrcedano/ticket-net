package Builders;

import DTOs.AsientoDto;

public class AsientoBuilder {
    private int id;
    private int sala_id;
    private String asiento;

    public AsientoBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public AsientoBuilder withSalaId(int sala_id) {
        this.sala_id = sala_id;
        return this;
    }

    public AsientoBuilder withAsiento(String asiento) {
        this.asiento = asiento;
        return this;
    }
    
    public AsientoDto build() {
        return new AsientoDto(id, sala_id, asiento);
    }
}