package mx.edu.buap.servicetracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mx.edu.buap.servicetracker.service.JsonService;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        JsonService.cargarServicios();

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "/mx/edu/buap/servicetracker/view/Login.fxml"
                )
        );

        Scene scene = new Scene(loader.load());

        stage.setTitle("Service Tracker");

        stage.setScene(scene);

        stage.show();
    }
}
