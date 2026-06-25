package mx.edu.buap.servicetracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mx.edu.buap.servicetracker.controller.CredencialesDialogController;
import mx.edu.buap.servicetracker.service.JsonService;
import mx.edu.buap.servicetracker.service.UserService;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        JsonService.cargarServicios();
        String password = UserService.inicializarUsuario();

        // Si es la primera vez ingresando al programa, mostrar la pantalla donde se brindarán las credenciales al usuario
        if(password != null) {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("view/CredencialesDialog.fxml"));

            Scene scene = new Scene(loader.load());
            CredencialesDialogController controller = loader.getController();
            controller.setDatos("admin", password);
            Stage dialog = new Stage();

            dialog.setTitle("Credenciales Iniciales");
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.setScene(scene);

            dialog.showAndWait();
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mx/edu/buap/servicetracker/view/Login.fxml"));

        Scene scene = new Scene(loader.load());
        stage.setTitle("Service Tracker");
        stage.setScene(scene);

        stage.show();
    }
}