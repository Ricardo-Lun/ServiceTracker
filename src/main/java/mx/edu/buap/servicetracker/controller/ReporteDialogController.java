package mx.edu.buap.servicetracker.controller;

import javafx.scene.control.Alert;
import mx.edu.buap.servicetracker.model.Servicio;
import mx.edu.buap.servicetracker.service.PdfService;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class ReporteDialogController {

    @FXML
    private TextArea txtDiagnostico;

    @FXML
    private TextArea txtComentariosFinales;

    private Servicio servicio;

    public void setServicio(Servicio servicio) {this.servicio = servicio;}

    @FXML
    private void generar() {

        boolean generado =
                PdfService.generarReporte(
                        servicio,
                        txtDiagnostico.getText(),
                        txtComentariosFinales.getText()
                );

        if (!generado) {

            Alert alerta = new Alert(
                    Alert.AlertType.ERROR
            );

            alerta.setTitle(
                    "Error"
            );

            alerta.setHeaderText(
                    "No se pudo generar el reporte"
            );

            alerta.setContentText(
                    "El archivo PDF ya está abierto o está siendo utilizado por otro programa."
            );

            alerta.showAndWait();

            return;
        }

        Alert alerta = new Alert(
                Alert.AlertType.INFORMATION
        );

        alerta.setTitle(
                "Reporte generado"
        );

        alerta.setHeaderText(null);

        alerta.setContentText(
                "El PDF fue generado correctamente."
        );

        alerta.showAndWait();

        Stage stage =
                (Stage) txtDiagnostico
                        .getScene()
                        .getWindow();

        stage.close();
    }

    @FXML
    private void cancelar() {

        Stage stage =
                (Stage) txtDiagnostico
                        .getScene()
                        .getWindow();

        stage.close();
    }
}