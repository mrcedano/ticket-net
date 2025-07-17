package Database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbConnection {

    // The single, static instance of the DbConnection class
    private static DbConnection instance;
    
    // The connection object is now an instance variable
    private Connection connection;
    
    // The constructor is private to prevent instantiation from outside
    private DbConnection() throws IOException, SQLException {
        Properties props = new Properties();
        // Using a relative path might be fragile. Consider class loaders for robustness.
        FileInputStream file = new FileInputStream("./src/config.properties");
        props.load(file);
        
        String url = props.getProperty("DB_URL");
        String user = props.getProperty("DB_USER");
        String password = props.getProperty("DB_PASS");
        
        this.connection = DriverManager.getConnection(url, user, password);
    }    
    
    /**
     * Gets the single instance of the DbConnection class.
     * The method is synchronized to be thread-safe during the first instantiation.
     *
     * @return The singleton instance of DbConnection.
     * @throws IOException  If the properties file cannot be read.
     * @throws SQLException If a database access error occurs.
     */
    public static synchronized DbConnection getInstance() throws IOException, SQLException {
        if (instance == null) {
            instance = new DbConnection();
        }
        return instance;
    }
    
    /**
     * Returns the active database connection.
     *
     * @return The java.sql.Connection object.
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Creates a Statement object for sending SQL statements to the database.
     *
     * @return a new default Statement object.
     * @throws SQLException if a database access error occurs or this method is
     *                      called on a closed connection.
     */
    public Statement getStatement() throws SQLException {
      return connection.createStatement();
    }
    
    /**
     * Closes the database connection.
     *
     * @throws SQLException if a database access error occurs.
     */
    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}