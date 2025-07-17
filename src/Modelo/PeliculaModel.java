package Modelo;

import DTOs.PeliculaDto;

public class PeliculaModel {
    private SimpleORM orm;
    private short lastRandomId;

    public PeliculaModel() throws Exception {
        orm = SimpleORM.getInstance();
    }
    
    public void addMovie(PeliculaDto pelicula) throws Exception {
       short randomId = (short) (new java.util.Random().nextInt(1000 - 0 + 1) + 0);
       lastRandomId = randomId;
       
       orm.simpleProcedure("AltasPelicula")
                .addParameter(pelicula.getNombre())
                .addParameter(pelicula.getDuration())
                .addParameter(pelicula.getPublic_objetive())
                .addParameter(pelicula.getDirectors())
                .addParameter(pelicula.getActors())
                .addParameter("resources/" + randomId + "_" + pelicula.getLogo())
                .execute();
    }
    
    public int getLastMovieLogoIdInserted() {
        return lastRandomId;
    }
}
