package Modelo;

import DTOs.UserDto;
import Database.DbConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {
    private SimpleORM orm;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ticketnet";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "admincisco";

    public UserDto findUserByIdAndRole(int id, int rol) {
        String sql = "SELECT * FROM usuarios WHERE id = ? AND rol = ?";
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setInt(2, rol);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    UserDto user = new UserDto();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("nombre"));
                    user.setPassword(rs.getString("contrasenia"));
                    user.settype(rs.getShort("rol"));
                    return user;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



   public UserModel() throws Exception {
       orm = SimpleORM.getInstance();
   }
   
   public UserDto findUserByUsername(String username) throws Exception {
      ResultSet resultset = orm.simpleExecute("SELECT * FROM usuarios WHERE nombre='" + username + "'");
     
      if (resultset == null) {
          return null;
      }
      
      resultset.next();
      
      int idFromDb = resultset.getInt("id");
      short typeFromDB = resultset.getShort("rol");
      String usernameFromDb = resultset.getString("nombre");
      String passwordFromDb = resultset.getString("contrasenia");
      
      UserDto user = new UserDto(idFromDb, usernameFromDb, passwordFromDb, typeFromDB);
      
      return user;
   }
    
   public boolean areCredentialsCorrect(String username, String password) throws Exception {
       UserDto user = findUserByUsername(username);
       
       if (user == null) return false;
       
       return user.getUsername().equals(username) && user.getPassword().equals(password);
   }


   
    
}
