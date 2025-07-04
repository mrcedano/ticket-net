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
        ResultSet rsCartelera = orm.simpleExecute("SELECT * FROM carteleras WHERE id=" + id);

        if (rsCartelera == null || !rsCartelera.next()) {
            return null;
        }

        int carteleraId = rsCartelera.getInt("id");
        Date activeSince = rsCartelera.getTimestamp("activadesde");
        Date activeUntil = rsCartelera.getTimestamp("activahasta");
        // Optionally: String logoPath = rsCartelera.getString("logo_filepath");

        CarteleraDto cartelera = new CarteleraDto(carteleraId, activeSince, activeUntil);

        // Query all movies for this cartelera
        ResultSet rsPeliculas = orm.simpleExecute(
            "SELECT p.nombre, p.duracion, p.publico, p.actores, p.portada " +
            "FROM Peliculas p " +
            "JOIN peliculas_carteleras pc ON p.id = pc.pelicula_id " +
            "WHERE pc.cartelera_id=" + id
        );

        List<PeliculaDto> movies = new ArrayList<>();
        
        while (rsPeliculas != null && rsPeliculas.next()) {
            String nombre = rsPeliculas.getString("nombre");
            Time duracion = rsPeliculas.getTime("duracion");
            String publico = rsPeliculas.getString("publico");
            String actores = rsPeliculas.getString("actores");
            String portada = rsPeliculas.getString("portada");
            PeliculaDto pelicula = new PeliculaDto(nombre, duracion, publico, actores, portada);
            movies.add(pelicula);
        }
        
        cartelera.movies = movies;

        return cartelera;
    }
    
    
    public CarteleraDto[] getAllCarteleras() throws Exception {
        ResultSet rsCarteleras = orm.simpleExecute("SELECT * FROM carteleras");
        if (rsCarteleras == null) {
            return new CarteleraDto[0];
        }

        List<CarteleraDto> carteleraList = new ArrayList<>();
        while (rsCarteleras.next()) {
            int carteleraId = rsCarteleras.getInt("id");
            Date activeSince = rsCarteleras.getTimestamp("activadesde");
            Date activeUntil = rsCarteleras.getTimestamp("activahasta");

            CarteleraDto cartelera = new CarteleraDto(carteleraId, activeSince, activeUntil);

            ResultSet rsPeliculas = orm.simpleExecute(
                "SELECT p.nombre, p.duracion, p.publico, p.actores, p.portada " +
                "FROM peliculas p " +
                "JOIN peliculas_carteleras pc ON p.id = pc.pelicula_id " +
                "WHERE pc.cartelera_id=" + carteleraId
            );
            List<PeliculaDto> movies = new ArrayList<>();
            while (rsPeliculas != null && rsPeliculas.next()) {
                String nombre = rsPeliculas.getString("nombre");
                Time duracion = rsPeliculas.getTime("duracion");
                String publico = rsPeliculas.getString("publico");
                String actores = rsPeliculas.getString("actores");
                String portada = rsPeliculas.getString("portada");
                PeliculaDto pelicula = new PeliculaDto(nombre, duracion, publico, actores, portada);
                movies.add(pelicula);
            }
            cartelera.movies = movies;

            carteleraList.add(cartelera);
        }

        return carteleraList.toArray(new CarteleraDto[0]);
    }
    
    public PeliculaDto[] getAllPeliculasFromCarteleras() throws Exception {
        List<PeliculaDto> moviesList = new ArrayList<PeliculaDto>();
        
        ResultSet rs = orm.simpleExecute("SELECT peliculas.nombre, peliculas.publico, peliculas.logo_filepath, peliculas.duracion FROM peliculas\n" +
"INNER JOIN peliculas_carteleras ON peliculas_carteleras.pelicula_id = peliculas.id;");
        
        if (rs == null) {
            return null;
        }
        
        while(rs.next()) {
            String nombreFromDb = rs.getString("peliculas.nombre");
            String publicoFromDb = rs.getString("peliculas.publico");
            String portadaFromDb = rs.getString("peliculas.logo_filepath");
            String duracionFromDb = rs.getString("peliculas.duracion");

            moviesList.add(new PeliculaDto(nombreFromDb, null, publicoFromDb, duracionFromDb, portadaFromDb));
        }
        
        return moviesList.toArray(new PeliculaDto[0]);
    }
}