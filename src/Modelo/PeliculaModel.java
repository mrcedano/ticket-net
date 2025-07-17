package Modelo;

import Builders.PeliculaBuilder;
import DTOs.PeliculaDto;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PeliculaModel {
    private SimpleORM orm;
    private short lastRandomId;

    public PeliculaModel() throws Exception {
        orm = SimpleORM.getInstance();
    }
    
    public PeliculaDto[] getAllMovies() throws Exception {
        List<PeliculaDto> moviesList = new ArrayList<>();
        
        ResultSet rs = orm.simpleQuery("SELECT peliculas.id, peliculas.nombre, peliculas.publico, peliculas.logo_filepath, peliculas.duracion FROM peliculas");
        
        if (rs == null) {
            return null;
        }
        
        while(rs.next()) {
            int idFromDb = rs.getInt("peliculas.id");
            String nombreFromDb = rs.getString("peliculas.nombre");
            String publicoFromDb = rs.getString("peliculas.publico");
            String portadaFromDb = rs.getString("peliculas.logo_filepath");
            String duracionFromDb = rs.getString("peliculas.duracion");

            moviesList.add(new PeliculaDto(idFromDb, nombreFromDb, duracionFromDb ,publicoFromDb, "", portadaFromDb, ""));
        }
        
        return moviesList.toArray(PeliculaDto[]::new);
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
    
    public void deleteMovie(int id) throws Exception {
       if (doesMovieExist(id) == false) {
           throw new Exception("PeliculaModel LOW Tried to delete a movie that doesn't exist");
       }
       
       orm.simpleUpdate("DELETE FROM peliculas WHERE id=" + id);
    }
    
    public void updateMovie(PeliculaBuilder movie) {
        
    }
    
    public boolean doesMovieExist(int id) {
        return true;
    }
    
    public int getLastMovieLogoIdInserted() {
        return lastRandomId;
    }
}
