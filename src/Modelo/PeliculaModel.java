package Modelo;

import Builders.PeliculaBuilder;
import DTOs.PeliculaDto;
import Database.CallableProcedure;
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
    
    public PeliculaDto[] getMovies() throws Exception {
        List<PeliculaDto> movies = new ArrayList<>();
        
        ResultSet rs = orm.simpleProcedure("obtenerPeliculas")
                                          .executeWithResultSet();
        
        if (rs == null) {
            return movies.toArray(PeliculaDto[]::new);
        }
        
        while(rs.next()) {
            int idFromDb = rs.getInt("id");
            String nombreFromDb = rs.getString("nombre");
            String publicoFromDb = rs.getString("publico");
            String portadaFromDb = rs.getString("logo_filepath");
            String duracionFromDb = rs.getString("duracion");
            
            PeliculaDto pelicula = new PeliculaBuilder()
                                        .withId(idFromDb)
                                        .withNombre(nombreFromDb)
                                        .withPublicObjetive(publicoFromDb)
                                        .withLogo(portadaFromDb)
                                        .withDuration(duracionFromDb)
                                        .build();
            
            movies.add(pelicula);
        }
        
        return movies.toArray(PeliculaDto[]::new);
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
    
    public void updateMovie(PeliculaDto movie) throws Exception {
       short randomId = (short) (new java.util.Random().nextInt(1000 - 0 + 1) + 0);
       lastRandomId = randomId;
       
        CallableProcedure callableProcedure = orm.simpleProcedure("CambiosPelicula")
                           .addParameter(movie.getNombre())
                           .addParameter(movie.getDuration())
                           .addParameter(movie.getPublic_objetive())
                           .addParameter(movie.getDirectors())
                           .addParameter(movie.getActors());

        if (movie.getLogo().isEmpty() == false) {
            callableProcedure.addParameter("resources/" + randomId + "_" + movie.getLogo());
        } else {
            callableProcedure.addParameter(null);
        }
        
        callableProcedure.addParameter(movie.getId());
        
        callableProcedure.execute();
    }
    
    public boolean doesMovieExist(int id) {
        return true;
    }
    
    public int getLastMovieLogoIdInserted() {
        return lastRandomId;
    }
    
    public PeliculaDto getMovieById(int id) throws Exception {
        ResultSet rs = orm.simpleQuery("SELECT * FROM peliculas WHERE id=" + id);
        
        if (rs == null) {
            return null;
        }
        
        rs.next();
        
        String nombreFromDb = rs.getString("nombre");
        String duracionFromDb = rs.getString("duracion");
        String publicoFromDb = rs.getString("publico");
        String directoresFromDb = rs.getString("directores");
        String actoresFromDb = rs.getString("actores");
        String filepathFromDb = rs.getString("logo_filepath");

        return new PeliculaBuilder()
                                    .withNombre(nombreFromDb)
                                    .withDuration(duracionFromDb)
                                    .withPublicObjetive(publicoFromDb)
                                    .withDirectors(directoresFromDb)
                                    .withActors(actoresFromDb)
                                    .withLogo(filepathFromDb)
                                    .build();
    }
}
