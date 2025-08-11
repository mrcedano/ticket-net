package Modelo;

import Builders.FuncionBuilder;
import Builders.PeliculaBuilder;
import Builders.SalasBuilder;
import DTOs.FuncionDto;
import DTOs.PeliculaDto;
import DTOs.SalaDto;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FuncionModel {

    private SimpleORM orm;

    public FuncionModel() throws Exception {
        orm = SimpleORM.getInstance();
    }

    public FuncionDto getLatestFuncionFromCarteleraById(int cartelera_id) throws Exception {

        ResultSet rs = orm.simpleProcedure("obtenerUltimaFuncionDeCarteleraPorId")
                .addParameter(cartelera_id)
                .executeWithResultSet();

        if (rs.next() == false) {
            return null;
        }

        int idFromDb = rs.getInt("id");
        LocalDateTime activeSinceFromDb = rs.getTimestamp("activadesde").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime activeUntilFromDb = rs.getTimestamp("activahasta").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        int pelicula_idFromDb = rs.getInt("pelicula_id");
        int sala_idFromDb = rs.getInt("sala_id");
        int cartelera_idFromDb = rs.getInt("cartelera_id");

        FuncionDto funcionDto = new FuncionBuilder()
                .withId(idFromDb)
                .withActivoDesde(activeSinceFromDb)
                .withActivoHasta(activeUntilFromDb)
                .withPeliculaId(pelicula_idFromDb)
                .withSalaId(sala_idFromDb)
                .withCarteleraId(cartelera_idFromDb)
                .build();

        return funcionDto;
    }

    public FuncionDto[] getFuncionesByCarteleraIdAndPeliculaId(int cartelera_id, int pelicula_id) throws Exception {
        List<FuncionDto> funciones = new ArrayList<>();

        ResultSet rs = orm.simpleProcedure("obtenerFuncionesDePeliculaPorCarteleraIdAndPeliculaId")
                .addParameter(cartelera_id)
                .addParameter(pelicula_id)
                .executeWithResultSet();

        while (rs.next()) {
            int idFromDb = rs.getInt("id");
            LocalDateTime activeSinceFromDb = rs.getTimestamp("activadesde").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            LocalDateTime activeUntilFromDb = rs.getTimestamp("activahasta").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            int sala_idFromDb = rs.getInt("sala_id");

            FuncionDto pelicula = new FuncionBuilder()
                    .withId(idFromDb)
                    .withActivoDesde(activeSinceFromDb)
                    .withActivoHasta(activeUntilFromDb)
                    .withPeliculaId(pelicula_id)
                    .withSalaId(sala_idFromDb)
                    .withCarteleraId(cartelera_id)
                    .build();

            funciones.add(pelicula);
        }

        return funciones.toArray(FuncionDto[]::new);
    }

    public int getLatestFuncionId(int cartelera_id) throws Exception {
        FuncionDto funcionDto = getLatestFuncionFromCarteleraById(cartelera_id);

        if (funcionDto == null) {
            return 0;
        }

        return funcionDto.getId();
    }

    public void createFuncion(FuncionDto funcionDto) throws Exception {
        LocalDateTime activeSince = funcionDto.getActivoDesde();
        LocalDateTime activeUntil = funcionDto.getActiveHasta();
        int peliculaId = funcionDto.getPelicula_id();
        int salaId = funcionDto.getSala_id();
        int carteleraId = funcionDto.getCartelera_id();

        orm.simpleProcedure("CrearFuncion")
                .addParameter(activeSince.toString())
                .addParameter(activeUntil.toString())
                .addParameter(peliculaId)
                .addParameter(salaId)
                .addParameter(carteleraId)
                .execute();
    }

    public HashMap<FuncionDto, HashMap<SalaDto, PeliculaDto>>[] getFuncionesFromCarteleraById(int carteleraId) throws Exception {
        ResultSet rs = orm.simpleProcedure("obtenerFuncionesDeCarteleraPorId")
                .addParameter(carteleraId)
                .executeWithResultSet();

        List<HashMap<FuncionDto, HashMap<SalaDto, PeliculaDto>>> funciones = new ArrayList<>();

        while (rs.next()) {
            int id = rs.getInt("id");
            LocalDateTime activoDesde = rs.getTimestamp("activadesde").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            LocalDateTime activoHasta = rs.getTimestamp("activahasta").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            String peliculaNombre = rs.getString("pelicula_nombre");
            String salaNombre = rs.getString("sala_nombre");

            FuncionDto funcion = new FuncionBuilder()
                    .withId(id)
                    .withActivoDesde(activoDesde)
                    .withActivoHasta(activoHasta)
                    .build();

            PeliculaDto pelicula = new PeliculaBuilder()
                    .withNombre(peliculaNombre)
                    .build();

            SalaDto sala = new SalasBuilder()
                    .withNombre(salaNombre)
                    .build();

            HashMap<SalaDto, PeliculaDto> salaPeliculaMap = new HashMap<>();
            salaPeliculaMap.put(sala, pelicula);

            HashMap<FuncionDto, HashMap<SalaDto, PeliculaDto>> funcionInformation = new HashMap<>();
            funcionInformation.put(funcion, salaPeliculaMap);

            funciones.add(funcionInformation);
        }

        return funciones.toArray(new HashMap[0]);
    }

    public HashMap<FuncionDto, HashMap<SalaDto, PeliculaDto>> getFuncionAndSalaAndPeliculaByFuncionId(int id) throws Exception {
        ResultSet rs = orm.simpleProcedure("obtenerFuncion_Pelicula_SalaPorIdDeFuncion")
                .addParameter(id)
                .executeWithResultSet();

        if (!rs.next()) {
            return null;
        }

        LocalDateTime activoDesde = rs.getTimestamp("activadesde").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime activoHasta = rs.getTimestamp("activahasta").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        int peliculaId = rs.getInt("pelicula_id");
        String peliculaNombre = rs.getString("pelicula_nombre");
        String peliculaLogo = rs.getString("pelicula_logo");

        int salaId = rs.getInt("sala_id");
        String salaNombre = rs.getString("sala_nombre");
        int salaCantAsientos = rs.getInt("sala_CantAsientos");

        FuncionDto funcion = new FuncionBuilder()
                .withId(id)
                .withActivoDesde(activoDesde)
                .withActivoHasta(activoHasta)
                .withPeliculaId(peliculaId)
                .withSalaId(salaId)
                .build();

        PeliculaDto pelicula = new PeliculaBuilder()
                .withId(peliculaId)
                .withNombre(peliculaNombre)
                .withLogo(peliculaLogo)
                .build();

        SalaDto sala = new SalasBuilder()
                .withId(salaId)
                .withNombre(salaNombre)
                .withCantAsientos(salaCantAsientos)
                .build();

        HashMap<SalaDto, PeliculaDto> salaPeliculaMap = new HashMap<>();
        salaPeliculaMap.put(sala, pelicula);

        HashMap<FuncionDto, HashMap<SalaDto, PeliculaDto>> funcionInformation = new HashMap<>();
        funcionInformation.put(funcion, salaPeliculaMap);

        return funcionInformation;
    }

    public void deleteFuncion(int id) throws Exception {
        orm.simpleProcedure("eliminarFuncionPorId")
                .addParameter(id)
                .execute();
    }

    public void updateFuncion(FuncionDto funcion) throws Exception {
        orm.simpleProcedure("actualizarFuncionPorId")
                .addParameter(funcion.getId())
                .addParameter(funcion.getActivoDesde().toString())
                .addParameter(funcion.getActiveHasta().toString())
                .addParameter(funcion.getPelicula_id())
                .addParameter(funcion.getSala_id())
                .execute();
    }

    public FuncionDto[] getFuncionesByMonthAndYearAndCarteleraId(int month, int year, int carteleraId) throws Exception {
        ResultSet rs = orm.simpleProcedure("buscarFuncionesPorMesYAnioYCarteleraId")
                .addParameter(month)
                .addParameter(year)
                .addParameter(carteleraId)
                .executeWithResultSet();

        List<FuncionDto> funciones = new ArrayList<>();

        while (rs.next()) {
            LocalDateTime activoDesde = rs.getTimestamp("activadesde").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

            FuncionDto funcion = new FuncionBuilder()
                    .withActivoDesde(activoDesde)
                    .build();

            funciones.add(funcion);
        }

        return funciones.toArray(FuncionDto[]::new);
    }

    public FuncionDto[] getFuncionesOfMovieByDateAndPeliculaIdAndCarteleraId(LocalDate date, int pelicula_id, int cartelera_id) throws Exception {
        ResultSet rs = orm.simpleProcedure("buscarFuncionesPorDiaYPorMesYAnioYPeliculaIdYCarteleraId")
                .addParameter(date.getDayOfMonth())
                .addParameter(date.getMonthValue())
                .addParameter(date.getYear())
                .addParameter(pelicula_id)
                .addParameter(cartelera_id)
                .executeWithResultSet();

        List<FuncionDto> funciones = new ArrayList<>();
        
        while (rs.next()) {
            LocalDateTime activoDesde = rs.getTimestamp("activadesde").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            LocalDateTime activoHasta = rs.getTimestamp("activahasta").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            int peliculaId = rs.getInt("pelicula_id");
            int salaId = rs.getInt("sala_id");
            int id = rs.getInt("id");

            FuncionDto funcion = new FuncionBuilder()
                    .withId(id)
                    .withActivoDesde(activoDesde)
                    .withActivoHasta(activoHasta)
                    .withPeliculaId(peliculaId)
                    .withSalaId(salaId)
                    .withCarteleraId(cartelera_id)
                    .build();

            funciones.add(funcion);
        }
        
        return funciones.toArray(FuncionDto[]::new);
    }
}
