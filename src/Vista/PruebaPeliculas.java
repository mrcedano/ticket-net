
package Vista;

public class PruebaPeliculas {
    public static void main(String[] args) {
        Pelicula lilo = new Pelicula(
            "Lilo y Stitch (2025)",
            "105 min",
            "A",
            "Español",
            "2D / 3D",
            "Lilo y Stitch nos llevan a una aventura inolvidable sobre la importancia de la familia, la amistad y el perdón.",
            "Zoe Saldaña, Chris Sanders / Dir. Fulano",
            "lilo_stich.jpg"
        );

        Pelicula titanic = new Pelicula(
            "Titanic (Reestreno)",
            "195 min",
            "B",
            "Español / Inglés",
            "2D",
            "Jack y Rose viven un amor imposible a bordo del Titanic.",
            "Leonardo DiCaprio, Kate Winslet / Dir. James Cameron",
            "titanic.jpg"
        );

        new DetallesPelicula(lilo);
        new DetallesPelicula(titanic);
    }
}