package mx.edu.buap.servicetracker.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginController {

    public void iniciarSesion(ActionEvent event) {

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource(
                                    "/mx/edu/buap/servicetracker/view/Registro.fxml"
                            )
                    );

            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) ((javafx.scene.Node)
                    event.getSource()).getScene().getWindow();

            stage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}