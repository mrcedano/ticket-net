package Modelo;

import Database.CallableProcedure;
import Database.DbConnection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Connection;

public class SimpleORM {
    private static SimpleORM instance;
    private static Statement statement;
    private static Connection connection;
    
    private static DbConnection db;

    private SimpleORM() {}
    
    public static SimpleORM getInstance() throws Exception {
        if (instance == null) {
            db = DbConnection.getInstance();
            statement = db.getStatement();
            connection = db.getConnection();
            
            instance = new SimpleORM();
        }
        
        return instance;
    }
    
    public CallableProcedure simpleProcedure(String procedureName) throws SQLException {
         CallableProcedure callable = new CallableProcedure(procedureName);
         
         return callable;
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
       db.close();
    }
}


