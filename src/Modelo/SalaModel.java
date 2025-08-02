package Modelo;

import Builders.SalasBuilder;
import DTOs.SalaDto;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SalaModel {

    private SimpleORM orm;

    public SalaModel() throws Exception {
        orm = SimpleORM.getInstance();
    }

    public void createSala(SalaDto sala) throws Exception {
        int id = sala.getId();
        String nombre = sala.getNombre();
        String tipo = sala.getTipo();
        int cantAsientos = sala.getCantAsientos();

        orm.simpleProcedure("crearSala")
                .addParameter(nombre)
                .addParameter(tipo)
                .addParameter(cantAsientos)
                .execute();
    }

    public SalaDto[] getSalas() throws Exception {
        ResultSet rs = orm.simpleProcedure("obtenerSalas")
                .executeWithResultSet();

        if (rs == null) {
            return null;
        }

        List<SalaDto> salas = new ArrayList<>();

        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            String tipo = rs.getString("tipo");
            int asientos = rs.getInt("CantAsientos");
            int disponibilidad = rs.getInt("estaDisponible");

            SalaDto sala = new SalasBuilder()
                    .withId(id)
                    .withNombre(nombre)
                    .withTipo(tipo)
                    .withCantAsientos(asientos)
                    .withDisponibilidad(disponibilidad)
                    .build();

            salas.add(sala);
        }

        return salas.toArray(new SalaDto[0]);
    }
    
    public void updateSala(SalaDto sala) throws Exception {
        orm.simpleProcedure("actualizarSala")
                            .addParameter(sala.getId())
                            .addParameter(sala.getNombre())
                            .addParameter(sala.getTipo())
                            .addParameter(sala.getCantAsientos())
                            .addParameter(sala.getDisponibilidad())
                            .execute();
    }

    public SalaDto getSala(int id) throws Exception {
        ResultSet rs = orm.simpleProcedure("consultarSala")
                                          .addParameter(id)
                                          .executeWithResultSet();

        if (rs.next() == false) {
            return null;
        }
        
        String nombre = rs.getString("nombre");
        String tipo = rs.getString("tipo");
        int cantidadAsientos = rs.getInt("CantAsientos");
        int disponibilidad = rs.getInt("estaDisponible");
        
        return new SalasBuilder()
                .withId(id)
                .withNombre(nombre)
                .withTipo(tipo)
                .withDisponibilidad(disponibilidad)
                .withCantAsientos(cantidadAsientos)
                .build();
    }

    public void deleteSala(int id) throws Exception {
        if (doesSalaExist(id) == false) {
            throw new Exception("SalaModel LOW Tried to delete a movie that doesn't exist");
        }

        orm.simpleProcedure("eliminarSala")
                .addParameter(id)
                .execute();
    }

    public boolean doesSalaExist(int id) {
        return true;
    }

}
