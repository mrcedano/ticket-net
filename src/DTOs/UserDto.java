
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
    private int status;
    
    public UserDto(int id, String username, String password, String email, short type, int status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.correo = email;
        this.type = type;
        this.status = status;
    }

    public UserDto() {
        throw new UnsupportedOperationException("Not supported yet.");
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
    
    public int getStatus() {
        return status;
    }
    
    public void setCorreo(String correo) { 
        this.correo = correo; 
    }
    
    public UserTypes getType() {
        return switch (type) {
            case 0 -> UserTypes.ADMINISTRADOR;
            case 1 -> UserTypes.CAJERO;
            case 2 -> UserTypes.CLIENTE;
            default -> null;
        };
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setType(short type) {
        this.type = type;
    }
    
    public void setId(int id) { 
        this.id = id; 
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
    
}
