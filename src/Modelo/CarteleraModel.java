package Modelo;

import DTOs.CarteleraDto;
import DTOs.PeliculaDto;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarteleraModel {

    private SimpleORM orm;

    public CarteleraModel() throws Exception {
        orm = SimpleORM.getInstance();
    }

    public CarteleraDto findOneCarteleraById(int id) throws Exception {
        // Query the Carteleras table for this id
        ResultSet rsCartelera = orm.simpleQuery("SELECT * FROM carteleras WHERE id=" + id);

        if (rsCartelera == null || !rsCartelera.next()) {
            return null;
        }

        int carteleraId = rsCartelera.getInt("id");
        Date activeSince = rsCartelera.getTimestamp("activadesde");
        Date activeUntil = rsCartelera.getTimestamp("activahasta");
        // Optionally: String logoPath = rsCartelera.getString("logo_filepath");

        CarteleraDto cartelera = new CarteleraDto(carteleraId, activeSince, activeUntil);

        // Query all movies for this cartelera
        ResultSet rsPeliculas = orm.simpleQuery(
            "SELECT  p.id, p.nombre, p.duracion, p.publico, p.actores, p.portada " +
            "FROM Peliculas p " +
            "JOIN peliculas_carteleras pc ON p.id = pc.pelicula_id " +
            "WHERE pc.cartelera_id=" + id
        );

        List<PeliculaDto> movies = new ArrayList<>();
        
        while (rsPeliculas != null && rsPeliculas.next()) {
            int idFromMovie = rsPeliculas.getInt("id");
            String nombre = rsPeliculas.getString("nombre");
            Time duracion = rsPeliculas.getTime("duracion");
            String publico = rsPeliculas.getString("publico");
            String actores = rsPeliculas.getString("actores");
            String portada = rsPeliculas.getString("portada");
            String directores = rsPeliculas.getString("directores");
            PeliculaDto pelicula = new PeliculaDto(idFromMovie, nombre, duracion.toString(), publico, actores, portada, directores);
            movies.add(pelicula);
        }
        
        cartelera.movies = movies;

        return cartelera;
    }
    
    
    public CarteleraDto[] getAllCarteleras() throws Exception {
        ResultSet rsCarteleras = orm.simpleQuery("SELECT * FROM carteleras");
        if (rsCarteleras == null) {
            return new CarteleraDto[0];
        }

        List<CarteleraDto> carteleraList = new ArrayList<>();
        while (rsCarteleras.next()) {
            int carteleraId = rsCarteleras.getInt("id");
            Date activeSince = rsCarteleras.getTimestamp("activadesde");
            Date activeUntil = rsCarteleras.getTimestamp("activahasta");

            CarteleraDto cartelera = new CarteleraDto(carteleraId, activeSince, activeUntil);

            
            ResultSet rsPeliculas = orm.simpleQuery(
                "SELECT p.nombre, p.duracion, p.publico, p.actores, p.logo_filepath " +
                "FROM peliculas AS p"
            );
            
            List<PeliculaDto> movies = new ArrayList<>();
            while (rsPeliculas != null && rsPeliculas.next()) {
                int id = rsPeliculas.getInt("id");
                String nombre = rsPeliculas.getString("nombre");
                Time duracion = rsPeliculas.getTime("duracion");
                String publico = rsPeliculas.getString("publico");
                String actores = rsPeliculas.getString("actores");
                String portada = rsPeliculas.getString("portada");
                PeliculaDto pelicula = new PeliculaDto(id, nombre, duracion.toString(), publico, actores, portada, "");
                movies.add(pelicula);
            }
            cartelera.movies = movies;

            carteleraList.add(cartelera);
        }

        return carteleraList.toArray(new CarteleraDto[0]);
    }
    
    public PeliculaDto[] getAllPeliculasFromCarteleras() throws Exception {
        List<PeliculaDto> moviesList = new ArrayList<PeliculaDto>();
        
        ResultSet rs = orm.simpleQuery("SELECT peliculas.nombre, peliculas.publico, peliculas.logo_filepath, peliculas.duracion FROM peliculas");
        
        if (rs == null) {
            return null;
        }
        
        while(rs.next()) {
            int idFromDb = rs.getInt("peliculas.id");
            String nombreFromDb = rs.getString("peliculas.nombre");
            String publicoFromDb = rs.getString("peliculas.publico");
            String portadaFromDb = rs.getString("peliculas.logo_filepath");
            String duracionFromDb = rs.getString("peliculas.duracion");

            moviesList.add(new PeliculaDto(idFromDb, nombreFromDb, "", publicoFromDb, duracionFromDb, portadaFromDb, ""));
        }
        
        return moviesList.toArray(new PeliculaDto[0]);
    }
}