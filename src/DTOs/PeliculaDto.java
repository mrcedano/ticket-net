package DTOs;

public class PeliculaDto {
    private String nombre;
    private String duration;
    private String directors;
    private String public_objetive;
    private String actors;
    private String logo;

    public PeliculaDto(String nombre, String duration, String public_objetive, String actors, String logo, String directors) {
        this.nombre = nombre;
        this.duration = duration;
        this.public_objetive = public_objetive;
        this.actors = actors;
        this.logo = logo;
        this.directors = directors;
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
}