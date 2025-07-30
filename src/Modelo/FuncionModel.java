
package Modelo;

import Builders.FuncionBuilder;
import DTOs.FuncionDto;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.ZoneId;

public class FuncionModel {
    
    private SimpleORM orm;

    public FuncionModel() throws Exception {
        orm = SimpleORM.getInstance();
    }
    
    public FuncionDto getLatestFuncionFromCarteleraById(int cartelera_id) throws Exception {
        ResultSet rs = orm.simpleProcedure("obtenerUltimaFuncionDeCarteleraPorId")
                            .addParameter(cartelera_id)
                            .executeWithResultSet();
        
        if (rs == null) {
            return null;
        }
        
        rs.next();
        
        int idFromDb = rs.getInt("id");
        LocalDate activeSinceFromDb = rs.getTimestamp("activadesde").toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate activeUntilFromDb = rs.getTimestamp("activahasta").toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int pelicula_idFromDb = rs.getInt("pelicula_id");
        int sala_idFromDb = rs.getInt("sala_id");
        int cartelera_idFromDb = rs.getInt("cartelera_id");
        
        FuncionDto funcionDto = new FuncionBuilder()
                                    .withId(idFromDb)
                                    .withActivoDesde(activeSinceFromDb)
                                    .withActiveHasta(activeUntilFromDb)
                                    .withPeliculaId(pelicula_idFromDb)
                                    .withSalaId(sala_idFromDb)
                                    .withCarteleraId(cartelera_idFromDb)
                                    .build();
        
        return funcionDto;
    }
    
    public int getLatestFuncionId(int cartelera_id) throws Exception {
        FuncionDto funcionDto = getLatestFuncionFromCarteleraById(cartelera_id);
        
        if (funcionDto == null) {
            return 0;
        }
        
        return funcionDto.getId();
    }
}
