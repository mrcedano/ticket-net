 
package Vista;


public class Pelicula {
    private String titulo;
    private String duracion;
    private String clasificacion;
    private String idioma;
    private String formato;
    private String sinopsis;
    private String reparto;
    private String rutaImagen;

    public Pelicula(String titulo, String duracion, String clasificacion, String idioma, String formato, String sinopsis, String reparto, String rutaImagen) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.clasificacion = clasificacion;
        this.idioma = idioma;
        this.formato = formato;
        this.sinopsis = sinopsis;
        this.reparto = reparto;
        this.rutaImagen = rutaImagen;
    }

    // Getters
    public String getTitulo() { return titulo; }
    public String getDuracion() { return duracion; }
    public String getClasificacion() { return clasificacion; }
    public String getIdioma() { return idioma; }
    public String getFormato() { return formato; }
    public String getSinopsis() { return sinopsis; }
    public String getReparto() { return reparto; }
    public String getRutaImagen() { return rutaImagen; }
}


