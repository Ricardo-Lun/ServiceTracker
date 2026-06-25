package mx.edu.buap.servicetracker.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import mx.edu.buap.servicetracker.service.UserService;

public class LoginController {

    //Variables de obtención
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtPassword;

    // Metodo para el inicio de sesión
    @FXML
    private void iniciarSesion() {

        String usuario = txtUsuario.getText();
        String password = txtPassword.getText();

        boolean valido = UserService.autenticar(usuario, password);

        if (!valido) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Acceso denegado");
            alerta.setHeaderText(null);
            alerta.setContentText("Usuario o contraseña incorrectos.");
            alerta.showAndWait();

            txtPassword.clear();
            txtPassword.requestFocus();

            return;
        }

        if (usuario.isBlank() || password.isBlank()) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Campos requeridos");
            alerta.setHeaderText(null);
            alerta.setContentText("Ingrese usuario y contraseña.");
            alerta.showAndWait();

            return;
        }

        abrirRegistro();
    }

    //Metodo para acceder a la pantalla de "Registro"
    private void abrirRegistro() {

        try {FXMLLoader loader = new FXMLLoader(getClass().getResource("/mx/edu/buap/servicetracker/view/Registro.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) txtUsuario.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Registro de Dispositivos");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}