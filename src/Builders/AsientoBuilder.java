package Builders;

import DTOs.AsientoDto;

public class AsientoBuilder {
    private int id;
    private int sala_id;
    private int asientoNumero;

    public AsientoBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public AsientoBuilder withSalaId(int sala_id) {
        this.sala_id = sala_id;
        return this;
    }

    public AsientoBuilder withAsientoNumero(int asientoNumero) {
        this.asientoNumero = asientoNumero;
        return this;
    }

    public AsientoDto build() {
        return new AsientoDto(id, sala_id, asientoNumero);
    }
}