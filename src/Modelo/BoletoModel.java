package Modelo;

import DTOs.BoletoDto;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                                         .execute();
    }

    public int getNumberOfSelectedAsientosByFuncionId(int funcionId) throws Exception {
        ResultSet rs = orm.simpleProcedure("obtenerNumeroDeAsientosOcupadosPorFuncionId")
                                                                                        .addParameter(funcionId)
                                                                                        .executeWithResultSet();
        if(!rs.next()) {
            return 0;
        }
        
        int total = rs.getInt("total");
        
        return total;
    }

}
