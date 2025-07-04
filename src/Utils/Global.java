package Utils;

import DTOs.UserDto;

public class Global {
    public static UserDto user = null;
    
    public static void destroySession() {
        user = null;
    }
}
