package Modelo;

import DTOs.UserDto;
import java.sql.ResultSet;

public class UserModel {
    private SimpleORM orm;
    
   public UserModel() throws Exception {
       orm = SimpleORM.getInstance();
   }
   
   public UserDto findUserByUsername(String username) throws Exception {
      ResultSet resultset = orm.simpleExecute("SELECT * FROM Usuarios WHERE username='" + username + "'");
     
      if (resultset == null) {
          return null;
      }
      
      resultset.next();
      
      int idFromDb = resultset.getInt("id");
      short typeFromDB = resultset.getShort("type");
      String usernameFromDb = resultset.getString("username");
      String passwordFromDb = resultset.getString("password");
      
      UserDto user = new UserDto(idFromDb, usernameFromDb, passwordFromDb, typeFromDB);
      
      return user;
   }
    
   public boolean areCredentialsCorrect(String username, String password) throws Exception {
       UserDto user = findUserByUsername(username);
       
       if (user == null) return false;
       
       return user.getUsername().equals(username) && user.getPassword().equals(password);
   }
    
}
