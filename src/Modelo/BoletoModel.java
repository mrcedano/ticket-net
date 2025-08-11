package Modelo;

import Builders.BoletoBuilder;
import DTOs.BoletoDto;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoletoModel {

    private SimpleORM orm;

    public BoletoModel() throws Exception {
        orm = SimpleORM.getInstance();
    }

    public String[] getSelectedAsientosByFuncionId(int funcionId) throws Exception {
        ResultSet rs = orm.simpleProcedure("obtenerAsientosOcupadosPorFuncionId")
                .addParameter(funcionId)
                .executeWithResultSet();

        List<String> asientos = new ArrayList<>();

        while (rs.next()) {
            String[] asientosByDb = rs.getString("asientos").split(",");

            asientos.addAll(Arrays.asList(asientosByDb));
        }

        return asientos.toArray(new String[0]);
    }

    public void createBoleto(BoletoDto boleto) throws Exception {
        orm.simpleProcedure("crearBoleto")
                .addParameter(boleto.getNinos())
                .addParameter(boleto.getAdultos())
                .addParameter(boleto.getFuncion_id())
                .addParameter(boleto.getUsuario_id())
                .addParameter(boleto.getAsientos())
                .addParameter(boleto.getTotal())
                .execute();
    }

    public Map<String, Object>[] getBoletosCompradosByUserId(int userId) throws Exception {
        List<Map<String, Object>> boletosWithPeliculasAndFunciones = new ArrayList<>();

        ResultSet rs = orm.simpleProcedure("obtenerBoletosCompradosPorUsuarioId")
                .addParameter(userId)
                .executeWithResultSet();

        while (rs.next()) {
            int boletoid = rs.getInt("boleto_id");
            int funcionId = rs.getInt("funcion_id");
            int cantNinos = rs.getInt("ninos");
            int cantAdultos = rs.getInt("adultos");
            int total = rs.getInt("total");
            String pelicula = rs.getString("pelicula");
            String logo = rs.getString("logo");

            Map<String, Object> boleto = new HashMap<String, Object>();

            boleto.put("boletoId", boletoid);
            boleto.put("funcionId", funcionId);
            boleto.put("cantNinos", cantNinos);
            boleto.put("cantAdultos", cantAdultos);
            boleto.put("total", total);
            boleto.put("pelicula", pelicula);
            boleto.put("logo", logo);

            boletosWithPeliculasAndFunciones.add(boleto);
        }

        return boletosWithPeliculasAndFunciones.toArray(new Map[0]);
    }

    public int getNumberOfSelectedAsientosByFuncionId(int funcionId) throws Exception {
        ResultSet rs = orm.simpleProcedure("obtenerNumeroDeAsientosOcupadosPorFuncionId")
                .addParameter(funcionId)
                .executeWithResultSet();
        if (!rs.next()) {
            return 0;
        }

        int total = rs.getInt("total");

        return total;
    }

    public BoletoDto findBoletoById(int boletoId) throws Exception {
        ResultSet rs = orm.simpleProcedure("obtenerBoletoPorId")
                .addParameter(boletoId)
                .executeWithResultSet();

        if (rs.next() == false) {
            return null;
        }

        int id = rs.getInt("id");
        int ninos = rs.getInt("ninos");
        int adultos = rs.getInt("adultos");
        int funcionId = rs.getInt("funcion_id");
        int usuarioId = rs.getInt("usuario_id");
        int total = rs.getInt("total");
        String asientos = rs.getString("asientos");

        BoletoDto boleto = new BoletoBuilder()
                .withId(id)
                .withNinos(ninos)
                .withAdultos(adultos)
                .withFuncionId(funcionId)
                .withUsuarioId(usuarioId)
                .withTotal(total)
                .withAsientos(asientos)
                .build();

        return boleto;
    }

    public BoletoDto getLastBoletoInserted() throws Exception {
        ResultSet rs = orm.simpleProcedure("obtenerUltimoBoleto")
                .executeWithResultSet();

        if (rs.next() == false) {
            return null;
        }

        int id = rs.getInt("id");
        int ninos = rs.getInt("ninos");
        int adultos = rs.getInt("adultos");
        int funcionId = rs.getInt("funcion_id");
        int usuarioId = rs.getInt("usuario_id");
        int total = rs.getInt("total");
        String asientos = rs.getString("asientos");

        BoletoDto boleto = new BoletoBuilder()
                .withId(id)
                .withNinos(ninos)
                .withAdultos(adultos)
                .withFuncionId(funcionId)
                .withUsuarioId(usuarioId)
                .withTotal(total)
                .withAsientos(asientos)
                .build();

        return boleto;
    }
}
