package Builders;

import DTOs.PeliculaDto;

public class PeliculaBuilder {
    private String nombre = "";
    private String duration = "";
    private String public_objetive = "";
    private String actors = "";
    private String logo = "";
    private String directors = "";

    public PeliculaBuilder() {
    }

    public PeliculaBuilder withNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public PeliculaBuilder withDuration(String duration) {
        this.duration = duration;
        return this;
    }

    public PeliculaBuilder withPublicObjetive(String public_objetive) {
        this.public_objetive = public_objetive;
        return this;
    }

    public PeliculaBuilder withActors(String actors) {
        this.actors = actors;
        return this;
    }

    public PeliculaBuilder withLogo(String logo) {
        this.logo = logo;
        return this;
    }

    public PeliculaBuilder withDirectors(String directors) {
        this.directors = directors;
        return this;
    }

    public PeliculaDto build() {
        return new PeliculaDto(nombre, duration, public_objetive, actors, logo, directors);
    }
}