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

import java.time.LocalDate;

public class RegistroController {

    // Variables de obtención de detalles
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
        cbTipo.getItems().addAll("Laptop", "PC Escritorio", "Impresora", "Servidor", "Monitor", "Otro");
        cbPrioridad.getItems().addAll("Alta", "Media", "Baja");
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
        if (validarFormulario()) {
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

            //Se almacenan "Servicios" con "Dispositivos" dentro, posteriormente se les asigna "Técnico" y "Estado"
            Servicio servicio = new Servicio();

            servicio.setFolio(String.format(DatosSistema.generarNuevoFolio()));
            servicio.setDispositivo(dispositivo);
            servicio.setEstado("Recibido");
            servicio.setTecnico("Sin asignar");
            DatosSistema.servicios.add(servicio);

            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Registro exitoso");
            alerta.setHeaderText(null);
            alerta.setContentText("Servicio registrado con folio: " + servicio.getFolio());
            alerta.showAndWait();

            limpiarFormulario();
            JsonService.guardarServicios();
        }
    }

    //Metodo para abrir la pantalla de "Gestion"
    @FXML
    private void abrirGestion(ActionEvent event) {
        try {FXMLLoader loader = new FXMLLoader(getClass().getResource("/mx/edu/buap/servicetracker/view/Gestion.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setMaximized(true);
            stage.setResizable(false);

            stage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean validarFormulario() {

        if (txtPropietario.getText().isBlank()) {
            mostrarError("El propietario es obligatorio.");
            return false;
        }

        if (txtArea.getText().isBlank()) {
            mostrarError("El área/departamento es obligatorio.");
            return false;
        }

        if (txtMarca.getText().isBlank()) {
            mostrarError("La marca es obligatoria.");
            return false;
        }

        if (txtModelo.getText().isBlank()) {
            mostrarError("El modelo es obligatorio.");
            return false;
        }

        if (cbTipo.getValue() == null || cbTipo.getValue().isBlank()) {
            mostrarError("El tipo de dispositivo es obligatorio.");
            return false;
        }

        if (cbPrioridad.getValue() == null || cbPrioridad.getValue().isBlank()) {
            mostrarError("La prioridad es obligatoria");
            return false;
        }

        if (dpFechaIngreso.getValue() == null) {
            mostrarError("Selecciona una fecha.");
            return false;
        }

        if (dpFechaIngreso.getValue().isAfter(LocalDate.now())) {
            mostrarError("La fecha no puede ser posterior a hoy.");
            return false;
        }

        return true;
    }

    private void mostrarError(String mensaje){
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Campos faltantes");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}