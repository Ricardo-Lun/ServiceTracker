package mx.edu.buap.servicetracker.controller;

// Paquetes para acceder a los modelos y servicios del programa
import mx.edu.buap.servicetracker.model.Dispositivo;
import mx.edu.buap.servicetracker.model.Servicio;
import mx.edu.buap.servicetracker.service.DatosSistema;
import mx.edu.buap.servicetracker.service.JsonService;

// Implementación con las interfaces gráficas
import javafx.fxml.FXML;
import javafx.scene.control.*;

// Cambio de pantallas
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegistroController {

    @FXML
    private TextField txtPropietario;
    @FXML
    private TextField txtArea;
    @FXML
    private TextField txtMarca;
    @FXML
    private TextField txtModelo;
    @FXML
    private TextField txtSerie;
    @FXML
    private ComboBox<String> cbTipo;
    @FXML
    private DatePicker dpFechaIngreso;
    @FXML
    private ComboBox<String> cbPrioridad;
    @FXML
    private TextArea txtComentarios;

    @FXML
    public void initialize() {

        cbTipo.getItems().addAll(
                "Laptop",
                "PC Escritorio",
                "Impresora",
                "Servidor",
                "Monitor",
                "Otro"
        );

        cbPrioridad.getItems().addAll(
                "Alta",
                "Media",
                "Baja"
        );
    }

    @FXML
    private void limpiarFormulario() {

        txtPropietario.clear();
        txtArea.clear();

        txtMarca.clear();
        txtModelo.clear();
        txtSerie.clear();

        cbTipo.getSelectionModel().clearSelection();

        dpFechaIngreso.setValue(null);

        cbPrioridad.getSelectionModel().clearSelection();

        txtComentarios.clear();
    }

    @FXML
    private void guardarDispositivo() {

        Dispositivo dispositivo = new Dispositivo(
                txtPropietario.getText(),
                txtArea.getText(),
                txtMarca.getText(),
                txtModelo.getText(),
                txtSerie.getText(),
                cbTipo.getValue(),
                dpFechaIngreso.getValue(),
                cbPrioridad.getValue(),
                txtComentarios.getText()
        );



        Servicio servicio = new Servicio();

        servicio.setFolio(
                String.format(
                        DatosSistema.generarNuevoFolio()
                )
        );

        servicio.setDispositivo(dispositivo);
        servicio.setEstado("Recibido");
        servicio.setTecnico("Sin asignar");
        DatosSistema.servicios.add(servicio);

        System.out.println("Servicio creado:");

        System.out.println(servicio);
        System.out.println("Total servicios: " + DatosSistema.servicios.size());


        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Registro exitoso");
        alerta.setHeaderText(null);
        alerta.setContentText("Servicio registrado con folio: " + servicio.getFolio());
        alerta.showAndWait();

        limpiarFormulario();

        JsonService.guardarServicios();
    }

    @FXML
    private void abrirGestion(ActionEvent event) {

        try {
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource(
                                    "/mx/edu/buap/servicetracker/view/Gestion.fxml"
                            )
                    );
            Scene scene = new Scene(loader.load());

            Stage stage =
                    (Stage) ((Node) event.getSource())
                            .getScene()
                            .getWindow();
            stage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}