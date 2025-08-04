package Builders;

import DTOs.BoletoDto;

public class BoletoBuilder {
    private int id = 0;
    private int ninos = 0;
    private int adultos = 0;
    private int total = 0;
    private int funcion_id = 0;
    private int usuario_id = 0;
    private String asientos = "";

    public BoletoBuilder() {
    }
    
    public BoletoBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public BoletoBuilder withNinos(int ninos) {
        this.ninos = ninos;
        return this;
    }

    public BoletoBuilder withAdultos(int adultos) {
        this.adultos = adultos;
        return this;
    }

    public BoletoBuilder withTotal(int total) {
        this.total = total;
        return this;
    }

    public BoletoBuilder withFuncionId(int funcion_id) {
        this.funcion_id = funcion_id;
        return this;
    }
    
    public BoletoBuilder withAsientos(String asientos) {
        this.asientos = asientos;
        return this;
    }
    
    public BoletoBuilder withUsuarioId(int usuarioId) {
        this.usuario_id = usuarioId;
        return this;
    }

    public BoletoDto build() {
        return new BoletoDto(id, ninos, adultos, total, funcion_id, usuario_id,asientos);
    }
}