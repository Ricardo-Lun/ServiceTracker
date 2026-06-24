package mx.edu.buap.servicetracker.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import mx.edu.buap.servicetracker.model.Servicio;
import mx.edu.buap.servicetracker.model.ServicioTabla;
import mx.edu.buap.servicetracker.service.DatosSistema;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GestionController {

    @FXML
    private TableView<ServicioTabla> tablaServicios;
    @FXML
    private TableColumn<ServicioTabla, String> colFolio;
    @FXML
    private TableColumn<ServicioTabla, String> colPropietario;
    @FXML
    private TableColumn<ServicioTabla, String> colEquipo;
    @FXML
    private TableColumn<ServicioTabla, String> colEstado;
    @FXML
    private TableColumn<ServicioTabla, String> colTecnico;

    @FXML
    private Label lblPropietario;
    @FXML
    private Label lblArea;
    @FXML
    private Label lblMarca;
    @FXML
    private Label lblModelo;
    @FXML
    private Label lblSerie;
    @FXML
    private Label lblTipo;
    @FXML
    private TextArea txtComentarios;

    @FXML
    private ComboBox<String> cbTecnico;
    @FXML
    private DatePicker dpFechaAsignacion;
    @FXML
    private DatePicker dpFechaEstimada;
    @FXML
    private ComboBox<String> cbEstado;

    private Servicio servicioSeleccionado;

    @FXML
    public void initialize() {

        colFolio.setCellValueFactory(
                new PropertyValueFactory<>("folio"));

        colPropietario.setCellValueFactory(
                new PropertyValueFactory<>("propietario"));

        colEquipo.setCellValueFactory(
                new PropertyValueFactory<>("equipo"));

        colEstado.setCellValueFactory(
                new PropertyValueFactory<>("estado"));

        colTecnico.setCellValueFactory(
                new PropertyValueFactory<>("tecnico"));

        cargarServicios();

        tablaServicios.getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (observable, anterior, actual) -> {

                            if (actual != null) {
                                mostrarDetalles(actual);
                            }

                        });

        cbTecnico.getItems().addAll(
                "Juan Pérez",
                "María García",
                "Carlos López"
        );

        cbEstado.getItems().addAll(
                "Recibido",
                "En diagnóstico",
                "En reparación",
                "En mantenimiento",
                "Esperando refacciones",
                "Reparado",
                "Entregado",
                "Cancelado"
        );
    }

    @FXML
    private void volverRegistro(ActionEvent event) {

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource(
                                    "/mx/edu/buap/servicetracker/view/Registro.fxml"
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

    private void cargarServicios() {

        var lista = FXCollections
                .<ServicioTabla>observableArrayList();

        for (Servicio servicio : DatosSistema.servicios) {

            lista.add(
                    new ServicioTabla(
                            servicio.getFolio(),

                            servicio.getDispositivo()
                                    .getPropietario(),

                            servicio.getDispositivo()
                                    .getMarca()
                                    + " "
                                    + servicio.getDispositivo()
                                    .getModelo(),

                            servicio.getEstado(),

                            servicio.getTecnico()
                    )
            );
        }

        tablaServicios.setItems(lista);
    }

    private void mostrarDetalles(
            ServicioTabla servicioTabla
    ) {

        servicioSeleccionado = null;

        for (Servicio s : DatosSistema.servicios) {

            if (s.getFolio()
                    .equals(servicioTabla.getFolio())) {

                servicioSeleccionado = s;
                break;
            }
        }

        if (servicioSeleccionado == null) {
            return;
        }

        var dispositivo = servicioSeleccionado.getDispositivo();

        lblPropietario.setText(
                "Propietario: "
                        + dispositivo.getPropietario());
        lblArea.setText(
                "Área: "
                        + dispositivo.getArea());
        lblMarca.setText(
                "Marca: "
                        + dispositivo.getMarca());
        lblModelo.setText(
                "Modelo: "
                        + dispositivo.getModelo());
        lblSerie.setText(
                "Serie: "
                        + dispositivo.getNumeroSerie());
        lblTipo.setText(
                "Tipo: "
                        + dispositivo.getTipo());
        txtComentarios.setText(
                dispositivo.getComentarios());

        cbTecnico.setValue(
                servicioSeleccionado.getTecnico()
        );
        dpFechaAsignacion.setValue(
                servicioSeleccionado.getFechaAsignacion()
        );
        dpFechaEstimada.setValue(
                servicioSeleccionado.getFechaEstimadaEntrega()
        );
        cbEstado.setValue(
                servicioSeleccionado.getEstado()
        );
    }

    @FXML
    private void actualizarAsignacion() {

        if (servicioSeleccionado == null) {
            return;
        }

        servicioSeleccionado.setTecnico(
                cbTecnico.getValue()
        );

        servicioSeleccionado.setFechaAsignacion(
                dpFechaAsignacion.getValue()
        );

        servicioSeleccionado.setFechaEstimadaEntrega(
                dpFechaEstimada.getValue()
        );

        System.out.println(
                "Asignación actualizada: "
                        + servicioSeleccionado.getFolio()
        );

        cargarServicios();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(
                "Información actualizada correctamente"
        );
        alert.showAndWait();
    }

    @FXML
    private void actualizarEstado() {

        if (servicioSeleccionado == null) {
            return;
        }

        servicioSeleccionado.setEstado(
                cbEstado.getValue()
        );

        System.out.println(
                "Estado actualizado: "
                        + servicioSeleccionado.getEstado()
        );

        cargarServicios();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(
                "Información actualizada correctamente"
        );
        alert.showAndWait();
    }
}