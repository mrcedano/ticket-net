package Modelo;

import Builders.CarteleraBuilder;
import Builders.PeliculaBuilder;
import DTOs.CarteleraDto;
import DTOs.PeliculaDto;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class CarteleraModel {

    private SimpleORM orm;

    public CarteleraModel() throws Exception {
        orm = SimpleORM.getInstance();
    }

    public CarteleraDto getCarteleraById(int id) throws Exception {
        ResultSet rs = orm.simpleProcedure("buscarCarteleraPorId")
                .addParameter(id)
                .executeWithResultSet();

        if (rs == null) {
            return null;
        }

        rs.next();

        LocalDate activeSince = rs.getTimestamp("activadesde").toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate activeUntil = rs.getTimestamp("activahasta").toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int isActivated = rs.getInt("estaActivado");

        CarteleraDto cartelera = new CarteleraBuilder()
                .withId(id)
                .withFromDate(activeSince)
                .withToDate(activeUntil)
                .withIsActivated(isActivated)
                .build();

        return cartelera;
    }

    public CarteleraDto findOneCarteleraAndMoviesById(int id) throws Exception {
        ResultSet rsCartelera = orm.simpleQuery("SELECT * FROM carteleras WHERE id=" + id);

        if (rsCartelera == null || !rsCartelera.next()) {
            return null;
        }

        int carteleraId = rsCartelera.getInt("id");
        LocalDate activeSince = rsCartelera.getTimestamp("activadesde").toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate activeUntil = rsCartelera.getTimestamp("activahasta").toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int isActivated = rsCartelera.getInt("estaActivado");

        CarteleraDto cartelera = new CarteleraDto(carteleraId, activeSince, activeUntil, isActivated);

        ResultSet rsPeliculas = orm.simpleQuery(
                "SELECT  p.id, p.nombre, p.duracion, p.publico, p.actores, p.portada "
                + "FROM Peliculas p "
                + "JOIN peliculas_carteleras pc ON p.id = pc.pelicula_id "
                + "WHERE pc.cartelera_id=" + id
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
            LocalDate activeSince = rsCarteleras.getTimestamp("activadesde").toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate activeUntil = rsCarteleras.getTimestamp("activahasta").toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int isActivated = rsCarteleras.getInt("estaActivado");

            CarteleraDto cartelera = new CarteleraDto(carteleraId, activeSince, activeUntil, isActivated);

            ResultSet rsPeliculas = orm.simpleQuery(
                    "SELECT p.nombre, p.duracion, p.publico, p.actores, p.logo_filepath "
                    + "FROM peliculas AS p"
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

    public CarteleraDto[] getCarteleras() throws Exception {
        ResultSet rs = orm.simpleProcedure("obtenerCarteleras")
                .executeWithResultSet();

        if (rs == null) {
            return null;
        }

        List<CarteleraDto> carteleras = new ArrayList<>();

        while (rs.next()) {
            int id = rs.getInt("id");
            LocalDate fromDate = rs.getDate("activadesde").toLocalDate();
            LocalDate toDate = rs.getDate("activahasta").toLocalDate();
            int estaActivado = rs.getInt("estaActivado");

            CarteleraDto cartelera = new CarteleraBuilder()
                    .withId(id)
                    .withFromDate(fromDate)
                    .withToDate(toDate)
                    .withIsActivated(estaActivado)
                    .build();

            carteleras.add(cartelera);
        }

        return carteleras.toArray(new CarteleraDto[0]);
    }

    public PeliculaDto[] getAllPeliculasFromCarteleras() throws Exception {
        List<PeliculaDto> moviesList = new ArrayList<PeliculaDto>();

        ResultSet rs = orm.simpleQuery("SELECT peliculas.id, peliculas.nombre, peliculas.publico, peliculas.logo_filepath, peliculas.duracion FROM peliculas");

        while (rs.next()) {
            int idFromDb = rs.getInt("peliculas.id");
            String nombreFromDb = rs.getString("peliculas.nombre");
            String publicoFromDb = rs.getString("peliculas.publico");
            String portadaFromDb = rs.getString("peliculas.logo_filepath");
            String duracionFromDb = rs.getString("peliculas.duracion");

            moviesList.add(new PeliculaDto(idFromDb, nombreFromDb, "", publicoFromDb, duracionFromDb, portadaFromDb, ""));
        }

        return moviesList.toArray(new PeliculaDto[0]);
    }

    public void addCartelera(CarteleraDto cartelera) throws Exception {
        orm.simpleProcedure("AltasCartelera")
                .addParameter(cartelera.getActiveSince().toString())
                .addParameter(cartelera.getActiveUntil().toString())
                .addParameter(cartelera.getIsActivated())
                .execute();
    }

    public void updateCarteleraById(int id, CarteleraDto cartelera) throws Exception {
        orm.simpleProcedure("actualizarCarteleraPorId")
                .addParameter(id)
                .addParameter(cartelera.getActiveSince().toString())
                .addParameter(cartelera.getActiveUntil().toString())
                .addParameter(cartelera.getIsActivated())
                .execute();
    }

    public PeliculaDto[] getPeliculasFromCarteleraById(int idCartelera) throws Exception {
        ResultSet rs = orm.simpleProcedure("obtenerPeliculasDeCarteraPorId")
                .addParameter(idCartelera)
                .executeWithResultSet();

        List<PeliculaDto> peliculas = new ArrayList<>();

        while (rs.next()) {
            int idFromDb = rs.getInt("id");
            String nameFromDb = rs.getString("nombre");
            String durationFromDb = rs.getString("duracion");
            String publicObjectiveFromDb = rs.getString("publico");
            String directorsFromDb = rs.getString("directores");
            String actorsFromDb = rs.getString("actores");
            String logoFilePathFromDb = rs.getString("logo_filepath");

            PeliculaDto pelicula = new PeliculaBuilder()
                    .withId(idFromDb)
                    .withNombre(nameFromDb)
                    .withDuration(durationFromDb)
                    .withPublicObjetive(publicObjectiveFromDb)
                    .withDirectors(directorsFromDb)
                    .withActors(actorsFromDb)
                    .withLogo(logoFilePathFromDb)
                    .build();

            peliculas.add(pelicula);
        }

        return peliculas.toArray(PeliculaDto[]::new);
    }

    public void addMovieToCarteleraById(int id, int... moviesId) throws Exception {
        String format = "(%s,%s)";

        String query = "INSERT INTO peliculas_carteleras(pelicula_id, cartelera_id) VALUES ";
        StringBuilder values = new StringBuilder();

        for (int i = 0; i < moviesId.length; i++) {
            System.out.println(moviesId[i]);
            
            String value = String.format(format, moviesId[i], id);

            values.append(value);

            if (i != moviesId.length - 1) {
                values.append(",");
            }
        }

        removeMoviesFromCarteleraById(id);

        orm.simpleInsert(query + values.toString());
    }

    public boolean isThereACarteleraActivated() throws Exception {
        return getNumberOfCartelerasActivated() > 0;
    }

    public void removeMoviesFromCarteleraById(int id) throws Exception {
        orm.simpleProcedure("removerPeliculasDeCarteleraPorId")
                .addParameter(id)
                .execute();
    }

    public int getNumberOfCartelerasActivated() throws Exception {
        ResultSet rs = orm.simpleProcedure("obtenerCartelerasActivas")
                .executeWithResultSet();

        if (rs == null) {
            return 0;
        }

        rs.next();

        return rs.getInt("carteleras_activadas");
    }

    public CarteleraDto getCarteleraActivated() throws Exception {
        ResultSet rs = orm.simpleProcedure("obtenerCarteleraActiva")
                .executeWithResultSet();

        if (rs == null || !rs.next()) {
            return null;
        }
        
        int id = rs.getInt("id");
        LocalDate activeSince = rs.getTimestamp("activadesde").toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate activeUntil = rs.getTimestamp("activahasta").toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int isActivated = rs.getInt("estaActivado");

        CarteleraDto carteleraDto = new CarteleraBuilder()
                .withId(id)
                .withFromDate(activeSince)
                .withToDate(activeUntil)
                .withIsActivated(isActivated)
                .build();

        return carteleraDto;
    }

    public void deleteCarteleraById(int id) throws Exception {
        orm.simpleProcedure("eliminarCarteleraPorId")
                .addParameter(id)
                .execute();
    }
}
