package DTOs;

import java.util.Objects;

public class SalaDto {
    private int id;
    private String nombre;
    private String tipo;
    private int cantAsientos;
    private int estaDisponible = 0;

    public SalaDto(int id, String nombre, String tipo, int cantAsientos, int estaDisponible) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantAsientos = cantAsientos;
        this.estaDisponible = estaDisponible;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCantAsientos() {
        return cantAsientos;
    }
    
    public int getDisponibilidad() {
        return estaDisponible;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SalaDto that = (SalaDto) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    @Override
    public String toString() {
        return getNombre();
    }
}