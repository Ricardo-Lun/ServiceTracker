package mx.edu.buap.servicetracker.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CredencialesDialogController {

    @FXML
    private Label lblUsuario;

    @FXML
    private Label lblPassword;

    public void setDatos(String usuario, String password) {
        lblUsuario.setText("Usuario: " + usuario);
        lblPassword.setText("Contraseña: " + password);
    }

    @FXML
    private void cerrar() {
        Stage stage = (Stage) lblUsuario.getScene().getWindow();
        stage.close();
    }
}