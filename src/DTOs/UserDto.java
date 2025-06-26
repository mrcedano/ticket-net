
package DTOs;

import Enums.UserTypes;

public class UserDto {
    private int id;
    private short type;
    private String username;
    private String password;
    
    public UserDto(int id, String username, String password, short type) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.type = type;
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
    
    public UserTypes getType() {
        switch (type) {
            case 0 -> {
                return UserTypes.ADMINISTRADOR;
            }
            case 1 -> {
                return UserTypes.CAJERO;
            }
            case 2 -> {
                return UserTypes.CLIENTE;
            }
        }
        
        return null;
    }
}
