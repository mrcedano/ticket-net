package DTOs;

import java.util.Objects;

public class BoletoDto {
    private int id;
    private int ninos;
    private int adultos;
    private int total;
    private int funcion_id;
    private int usuario_id;
    private String asientos;

    public BoletoDto(int id, int ninos, int adultos, int total, int funcion_id, int usuario_id,String asientos) {
        this.id = id;
        this.ninos = ninos;
        this.adultos = adultos;
        this.total = total;
        this.funcion_id = funcion_id;
        this.usuario_id = usuario_id;
        this.asientos = asientos;
    }
    
    public int getId() {
        return id;
    }

    public int getNinos() {
        return ninos;
    }

    public int getAdultos() {
        return adultos;
    }

    public int getTotal() {
        return total;
    }

    public int getFuncion_id() {
        return funcion_id;
    }
    
    public int getUsuario_id() {
        return usuario_id;
    }
    
    public String getAsientos() {
        return asientos;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BoletoDto that = (BoletoDto) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    @Override
    public String toString() {
        return "Boleto #" + getId() + " - Adultos: " + getAdultos() + ", Niños: " + getNinos();
    }
}