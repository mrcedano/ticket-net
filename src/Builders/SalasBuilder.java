package Builders;

import DTOs.SalaDto;

public class SalasBuilder {
    private int id;
    private String nombre;
    private String tipo;
    private int cantAsientos;
    private int disponibilidad;
    
    public SalasBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public SalasBuilder withNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public SalasBuilder withTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public SalasBuilder withCantAsientos(int cantAsientos) {
        this.cantAsientos = cantAsientos;
        return this;
    }
    
    public SalasBuilder withDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
        return this;
    }

    public SalaDto build() {
        return new SalaDto(id, nombre, tipo, cantAsientos, disponibilidad);
    }
}