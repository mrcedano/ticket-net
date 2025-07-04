package Database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbConnection {

    private static Connection connection;
    
    public static void init() throws IOException, SQLException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("./src/config.properties");
        props.load(file);
        
        String url = props.getProperty("DB_URL");
        String user = props.getProperty("DB_USER");
        String password = props.getProperty("DB_PASS");
        
        connection = DriverManager.getConnection(url, user, password);
    }    
    
    public static Connection getConnection() {
        return connection;
    }

    
    public static Statement getStatement() throws SQLException {
      return connection.createStatement();
    }
    
    public static void close() throws SQLException {
        connection.close();
    }
}
