package Modelo;

import Database.DbConnection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class SimpleORM {
    private static SimpleORM instance;
    private static Statement statement;

    private SimpleORM() {}
    
    public static SimpleORM getInstance() throws Exception {
        if (instance == null) {
            DbConnection.init();
            statement = DbConnection.getStatement();
            
            instance = new SimpleORM();
        }
        
        return instance;
    }
    
    public ResultSet simpleExecute(String query) throws SQLException {
        // statement.clearBatch();
        ResultSet rs = statement.executeQuery(query);
        
        if (!rs.isBeforeFirst()) {
            return null;
        }
        
        return rs;
    }
    
    public void closeConnection() throws SQLException {
       DbConnection.close();
    }
}
