package Modelo;

import DTOs.UserDto;
import static Enums.UserTypes.ADMINISTRADOR;
import static Enums.UserTypes.CAJERO;
import static Enums.UserTypes.CLIENTE;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserModel {

    private SimpleORM orm;

    public UserModel() throws Exception {
        orm = SimpleORM.getInstance();
    }

    public UserDto findUserByIdAndRole(int id, int rol) throws Exception {
        ResultSet rs = orm.simpleQuery(
                "SELECT * FROM usuarios WHERE id = " + id + " AND rol = " + rol
        );
        if (rs != null && rs.next()) {
            UserDto user = new UserDto();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("nombre"));
            user.setPassword(rs.getString("contrasenia"));
            user.setType(rs.getShort("rol"));
            user.setCorreo(rs.getString("correo"));

            return user;
        }

        return null;
    }

    public UserDto findUserByUsername(String username) throws Exception {
        ResultSet resultset = orm.simpleQuery("SELECT * FROM usuarios WHERE nombre='" + username + "' AND status = 1");

        if (resultset == null) {
            return null;
        }

        resultset.next();

        int idFromDb = resultset.getInt("id");
        short typeFromDB = resultset.getShort("rol");
        String usernameFromDb = resultset.getString("nombre");
        String passwordFromDb = resultset.getString("contrasenia");
        String emailFromDb = resultset.getString("correo");
        int statusFromDb = resultset.getInt("status");

        UserDto user = new UserDto(idFromDb, usernameFromDb, passwordFromDb, emailFromDb, typeFromDB, statusFromDb);

        return user;
    }

    public UserDto findUserById(int id) throws Exception {
        ResultSet resultset = orm.simpleProcedure("obtenerUsuarioPorId")
                .addParameter(id)
                .executeWithResultSet();

        if (resultset.next() == false) {
            return null;
        }

        int idFromDb = resultset.getInt("id");
        short typeFromDB = resultset.getShort("rol");
        String usernameFromDb = resultset.getString("nombre");
        String passwordFromDb = resultset.getString("contrasenia");
        String emailFromDb = resultset.getString("correo");
        int statusFromDb = resultset.getInt("status");

        UserDto user = new UserDto(idFromDb, usernameFromDb, passwordFromDb, emailFromDb, typeFromDB, statusFromDb);

        return user;
    }

    public boolean areCredentialsCorrect(String username, String password) throws Exception {
        UserDto user = findUserByUsername(username);

        if (user == null) {
            return false;
        }

        return user.getUsername().equals(username) && user.getPassword().equals(password);
    }

    public void updateUser(UserDto user) throws Exception {
        int rol = 0;

        switch (user.getType()) {
            case ADMINISTRADOR ->
                rol = 0;
            case CAJERO ->
                rol = 1;
            case CLIENTE ->
                rol = 2;
        }

        orm.simpleProcedure("actualizarUsuario")
                .addParameter(user.getId())
                .addParameter(rol)
                .addParameter(user.getUsername())
                .addParameter(user.getPassword())
                .addParameter(user.getCorreo())
                .addParameter(user.getStatus())
                .execute();
    }

    public void desactivateUser(UserDto user) throws Exception {
        orm.simpleProcedure("desactivarUsuario")
                .addParameter(user.getId())
                .execute();
    }

    public void desactivateUserById(int id) throws Exception {
        orm.simpleProcedure("desactivarUsuario")
                .addParameter(id)
                .execute();
    }

    public UserDto[] getUsers() throws Exception {
        ResultSet rs = orm.simpleProcedure("obtenerUsuarios")
                .executeWithResultSet();

        List<UserDto> usuarios = new ArrayList<>();

        while (rs.next()) {
            int id = rs.getInt("id");
            short role = rs.getShort("rol");
            String name = rs.getString("nombre");
            String password = rs.getString("contrasenia");
            String email = rs.getString("correo");
            int status = rs.getInt("status");

            UserDto user = new UserDto(id, name, password, email, role, status);

            usuarios.add(user);
        }

        return usuarios.toArray(UserDto[]::new);
    }

    public void addUser(UserDto user) throws Exception {
        int role = 0;

        switch (user.getType()) {
            case ADMINISTRADOR ->
                role = 0;
            case CAJERO ->
                role = 1;
            case CLIENTE ->
                role = 2;
        }

        orm.simpleProcedure("crearUsuario")
                .addParameter(role)
                .addParameter(user.getUsername())
                .addParameter(user.getPassword())
                .addParameter(user.getCorreo())
                .addParameter(user.getStatus())
                .execute();
    }

    public UserDto getLastUserCreated() throws Exception {
        ResultSet resultset = orm.simpleProcedure("obtenerUltimoUsuarioRegistrado")
                .executeWithResultSet();

        if (resultset.next() == false) {
            return null;
        }

        int idFromDb = resultset.getInt("id");
        short typeFromDB = resultset.getShort("rol");
        String usernameFromDb = resultset.getString("nombre");
        String passwordFromDb = resultset.getString("contrasenia");
        String emailFromDb = resultset.getString("correo");
        int statusFromDb = resultset.getInt("status");

        UserDto user = new UserDto(idFromDb, usernameFromDb, passwordFromDb, emailFromDb, typeFromDB, statusFromDb);

        return user;
    }
    
    public void addUserFromClient(UserDto user) throws Exception {
        int rol = 0;

        switch (user.getType()) {
            case ADMINISTRADOR ->
                rol = 0;
            case CAJERO ->
                rol = 1;
            case CLIENTE ->
                rol = 2;
        }
        
        orm.simpleProcedure("crearUsuario")
                           .addParameter(rol)
                           .addParameter(user.getUsername())
                           .addParameter(user.getPassword())
                           .addParameter(user.getCorreo())
                           .addParameter(1)
                           .execute();
    }
}
