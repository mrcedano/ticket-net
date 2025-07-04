package DTOs;
import java.sql.Time;

public class PeliculaDto {
    private String nombre;
    private Time duration;
    private String public_objetive;
    private String actors;
    private String logo;

    public PeliculaDto(String nombre, Time duration, String public_objetive, String actors, String logo) {
        this.nombre = nombre;
        this.duration = duration;
        this.public_objetive = public_objetive;
        this.actors = actors;
        this.logo = logo;
    }

    public String getNombre() {
        return nombre;
    }

    public Time getDuration() {
        return duration;
    }

    public String getPublic_objetive() {
        return public_objetive;
    }

    public String getActors() {
        return actors;
    }

    public String getLogo() {
        return logo;
    }
}