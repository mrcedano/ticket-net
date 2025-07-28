package DTOs;

import java.util.Objects;

public class PeliculaDto {
    private int id;
    private String nombre;
    private String duration;
    private String directors;
    private String public_objetive;
    private String actors;
    private String logo;

    public PeliculaDto(int id, String nombre, String duration, String public_objetive, String actors, String logo, String directors) {
        this.id = id;
        this.nombre = nombre;
        this.duration = duration;
        this.public_objetive = public_objetive;
        this.actors = actors;
        this.logo = logo;
        this.directors = directors;
    }
    
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDuration() {
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

    public String getDirectors() {
        return directors;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PeliculaDto that = (PeliculaDto) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}