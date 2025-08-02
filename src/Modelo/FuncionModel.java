
package Modelo;

import Builders.FuncionBuilder;
import DTOs.FuncionDto;
import java.sql.ResultSet;
import java.time.LocalDateTime;
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
        
        if(rs.next() == false) {
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
}
