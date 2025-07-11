package Modelo;

import DTOs.UserDto;
import java.sql.ResultSet;

public class UserModel {

    private SimpleORM orm;

    public UserModel() throws Exception {
        orm = SimpleORM.getInstance();
    }

    public UserDto findUserByIdAndRole(int id, int rol) throws Exception {
        ResultSet rs = orm.simpleExecute(
                "SELECT * FROM usuarios WHERE id = " + id + " AND rol = " + rol
        );
        if (rs != null && rs.next()) {
            UserDto user = new UserDto();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("nombre"));
            user.setPassword(rs.getString("contrasenia"));
            user.settype(rs.getShort("rol"));
            return user;
        }

        return null;
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

        if (user == null) {
            return false;
        }

        return user.getUsername().equals(username) && user.getPassword().equals(password);
    }

}
