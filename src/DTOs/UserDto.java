
package DTOs;

import Database.DbConnection;
import Enums.UserTypes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDto {
    private int id;
    private short type;
    private String username;
    private String password;
    private String correo;
    
    public UserDto(int id, String username, String password, short type) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public UserDto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    


    
    public int getId() {
        return id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getCorreo() { 
        return correo; 
    }
    
    public void setCorreo(String correo) { 
        this.correo = correo; 
    }
    
    public void setId(int id) { 
        this.id = id; 
    }
    
    public void setType(short type) { 
        this.type = type; 
    }
    
    public UserTypes getType() {
        switch (type) {
            case 0:
                return UserTypes.ADMINISTRADOR;
            case 1:
                return UserTypes.CAJERO;
        case 2:
                return UserTypes.CLIENTE;
        default:
            return null;
        }
    }

    public void setPassword(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setUsername(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void settype(short aShort) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    
}
