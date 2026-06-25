package mx.edu.buap.servicetracker.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import mx.edu.buap.servicetracker.model.Usuario;
import mx.edu.buap.servicetracker.util.SecurityUtils;

import java.io.File;
import java.util.UUID;

public class UserService {

    private static final String FILE = "data/usuarios.json";

    private static final ObjectMapper mapper = new ObjectMapper();

    // Metodo para el primer ingreso al programa, creará un usuario y contraseña nuevos
    public static String inicializarUsuario() {
        try {
            File archivo = new File(FILE);

            if (archivo.exists()) {
                return null;
            }

            String password = UUID.randomUUID().toString().substring(0, 8);
            Usuario usuario = new Usuario("admin", SecurityUtils.hashPassword(password));

            mapper.writerWithDefaultPrettyPrinter().writeValue(archivo, usuario);

            return password;

        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    // Metodo para consultar el usuario desde el archivo cifrado
    public static Usuario obtenerUsuario() {
        try {
            File archivo = new File(FILE);
            if (!archivo.exists()) {
                return null;
            }

            return mapper.readValue(archivo, Usuario.class);

        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    // Metodo para autenticar los campos de la interfaz y del archivo cifrado
    public static boolean autenticar(
            String username,
            String password
    ) {

        Usuario usuario = obtenerUsuario();
        if (usuario == null) {return false;}
        String hashIngresado = SecurityUtils.hashPassword(password);
        return usuario.getUsername().equals(username) && usuario.getPasswordHash().equals(hashIngresado);
    }
}