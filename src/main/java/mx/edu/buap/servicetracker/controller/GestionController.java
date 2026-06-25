package mx.edu.buap.servicetracker.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import mx.edu.buap.servicetracker.model.Servicio;
import mx.edu.buap.servicetracker.model.ServicioTabla;
import mx.edu.buap.servicetracker.model.Actividad;
import mx.edu.buap.servicetracker.service.DatosSistema;
import mx.edu.buap.servicetracker.service.JsonService;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.time.LocalDate;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
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
    private TextArea txtActividad;
    @FXML
    private TableView<Actividad> tablaActividades;
    @FXML
    private TableColumn<Actividad, String>
            colFechaActividad;
    @FXML
    private TableColumn<Actividad, String>
            colDescripcionActividad;
    @FXML
    private TableColumn<Actividad, String>
            colTecnicoActividad;

    @FXML
    private TextField txtBuscarPropietario;
    @FXML
    private ComboBox<String> cbFiltroTecnico;
    @FXML
    private ComboBox<String> cbFiltroEstado;
    @FXML
    private ComboBox<String> cbFiltroPrioridad;

    @FXML
    public void initialize() {

        colFolio.setCellValueFactory(new PropertyValueFactory<>("folio"));
        colPropietario.setCellValueFactory(new PropertyValueFactory<>("propietario"));
        colEquipo.setCellValueFactory(new PropertyValueFactory<>("equipo"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        colTecnico.setCellValueFactory(new PropertyValueFactory<>("tecnico"));

        colFechaActividad.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colDescripcionActividad.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        colTecnicoActividad.setCellValueFactory(new PropertyValueFactory<>("tecnico"));

        cbFiltroTecnico.getItems().addAll(
                "Todos",
                "Juan Pérez",
                "María García",
                "Carlos López"
        );
        cbFiltroTecnico.setValue("Todos");

        cbFiltroEstado.getItems().addAll(
                "Todos",
                "Recibido",
                "En diagnóstico",
                "En reparación",
                "En mantenimiento",
                "Esperando refacciones",
                "Reparado",
                "Entregado",
                "Cancelado"
        );
        cbFiltroEstado.setValue("Todos");

        cbFiltroPrioridad.getItems().addAll(
                "Todos",
                "Alta",
                "Media",
                "Baja"
        );
        cbFiltroPrioridad.setValue("Todos");

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

    private void mostrarDetalles(ServicioTabla servicioTabla) {

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

        lblPropietario.setText("Propietario: " + dispositivo.getPropietario());
        lblArea.setText("Área: " + dispositivo.getArea());
        lblMarca.setText("Marca: " + dispositivo.getMarca());
        lblModelo.setText("Modelo: " + dispositivo.getModelo());
        lblSerie.setText("Serie: " + dispositivo.getNumeroSerie());
        lblTipo.setText("Tipo: " + dispositivo.getTipo());

        txtComentarios.setText(dispositivo.getComentarios());
        cbTecnico.setValue(servicioSeleccionado.getTecnico());
        dpFechaAsignacion.setValue(servicioSeleccionado.getFechaAsignacion());
        dpFechaEstimada.setValue(servicioSeleccionado.getFechaEstimadaEntrega());
        cbEstado.setValue(servicioSeleccionado.getEstado());

        cargarActividades();
    }

    @FXML
    private void eliminarServicio() {

        if (servicioSeleccionado == null) {
            return;
        }

        Alert confirmacion =
                new Alert(
                        Alert.AlertType.CONFIRMATION
                );

        confirmacion.setTitle(
                "Eliminar servicio"
        );

        confirmacion.setHeaderText(null);

        confirmacion.setContentText(
                "¿Desea eliminar el servicio "
                        + servicioSeleccionado.getFolio()
                        + "?"
        );

        var resultado =
                confirmacion.showAndWait();

        if (resultado.isPresent()
                && resultado.get() == ButtonType.OK) {

            DatosSistema.servicios.remove(
                    servicioSeleccionado
            );

            JsonService.guardarServicios();

            cargarServicios();

            limpiarDetalle();
        }
    }

    private void limpiarDetalle() {

        servicioSeleccionado = null;

        lblPropietario.setText("Propietario:");
        lblArea.setText("Área:");
        lblMarca.setText("Marca:");
        lblModelo.setText("Modelo:");
        lblSerie.setText("Serie:");
        lblTipo.setText("Tipo:");

        txtComentarios.clear();

        tablaActividades.getItems().clear();

        cbTecnico.setValue(null);

        dpFechaAsignacion.setValue(null);

        dpFechaEstimada.setValue(null);

        cbEstado.setValue(null);
    }

    @FXML
    private void actualizarAsignacion() {

        if (servicioSeleccionado == null) {
            return;
        }

        servicioSeleccionado.setTecnico(cbTecnico.getValue());
        servicioSeleccionado.setFechaAsignacion(dpFechaAsignacion.getValue());
        servicioSeleccionado.setFechaEstimadaEntrega(dpFechaEstimada.getValue());

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

        JsonService.guardarServicios();
    }

    @FXML
    private void actualizarEstado() {

        if (servicioSeleccionado == null) {
            return;
        }

        servicioSeleccionado.setEstado(cbEstado.getValue());

        System.out.println("Estado actualizado: " + servicioSeleccionado.getEstado());

        cargarServicios();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(
                "Información actualizada correctamente"
        );
        alert.showAndWait();

        JsonService.guardarServicios();
    }

    @FXML
    private void agregarActividad() {

        if (servicioSeleccionado == null) {
            return;
        }
        if (txtActividad.getText().isBlank()) {

            mostrarAlerta(
                    "Debe ingresar una descripción de actividad."
            );

            return;
        }
        if (servicioSeleccionado.getTecnico() == null || servicioSeleccionado.getTecnico().isBlank()) {
            mostrarAlerta("Debe asignar un técnico antes de registrar actividades.");
            return;
        }

        String estado = servicioSeleccionado.getEstado();
        if ("Entregado".equals(estado) || "Cancelado".equals(estado)) {
            mostrarAlerta("No se pueden agregar actividades a un servicio concluido.");
            return;
        }

        Actividad actividad =
                new Actividad(

                        LocalDate.now(),

                        txtActividad.getText(),

                        servicioSeleccionado
                                .getTecnico()
                );

        servicioSeleccionado.getActividades().add(actividad);
        txtActividad.clear();

        cargarActividades();
        JsonService.guardarServicios();
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void cargarActividades() {

        if (servicioSeleccionado == null) {

            tablaActividades.getItems().clear();

            return;
        }

        tablaActividades.setItems(
                FXCollections.observableArrayList(
                        servicioSeleccionado.getActividades()
                )
        );
    }

    @FXML
    private void buscarServicios() {

        var lista =
                FXCollections
                        .<ServicioTabla>observableArrayList();

        for (Servicio servicio : DatosSistema.servicios) {

            boolean coincide = true;

            String propietario =
                    servicio.getDispositivo()
                            .getPropietario();

            String tecnico =
                    servicio.getTecnico();

            String estado =
                    servicio.getEstado();

            String prioridad =
                    servicio.getDispositivo()
                            .getPrioridad();

            if (!txtBuscarPropietario
                    .getText()
                    .isBlank()) {

                coincide &= propietario
                        .toLowerCase()
                        .contains(
                                txtBuscarPropietario
                                        .getText()
                                        .toLowerCase()
                        );
            }

            if (!cbFiltroTecnico
                    .getValue()
                    .equals("Todos")) {

                coincide &= tecnico.equals(
                        cbFiltroTecnico.getValue()
                );
            }

            if (!cbFiltroEstado
                    .getValue()
                    .equals("Todos")) {

                coincide &= estado.equals(
                        cbFiltroEstado.getValue()
                );
            }

            if (!cbFiltroPrioridad
                    .getValue()
                    .equals("Todos")) {

                coincide &= prioridad.equals(
                        cbFiltroPrioridad.getValue()
                );
            }

            if (coincide) {

                lista.add(
                        new ServicioTabla(
                                servicio.getFolio(),

                                propietario,

                                servicio.getDispositivo()
                                        .getMarca()
                                        + " "
                                        + servicio.getDispositivo()
                                        .getModelo(),

                                estado,

                                tecnico
                        )
                );
            }
        }

        tablaServicios.setItems(lista);
    }

    @FXML
    private void limpiarFiltros() {

        txtBuscarPropietario.clear();
        cbFiltroTecnico.setValue("Todos");
        cbFiltroEstado.setValue("Todos");
        cbFiltroPrioridad.setValue("Todos");

        cargarServicios();
    }

    @FXML
    private void abrirDialogReporte() {

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource(
                                    "/mx/edu/buap/servicetracker/view/ReporteDialog.fxml"
                            )
                    );

            Scene scene =
                    new Scene(loader.load());

            ReporteDialogController controller = loader.getController();
            controller.setServicio(servicioSeleccionado);

            Stage stage =
                    new Stage();

            stage.setTitle(
                    "Reporte Técnico"
            );

            stage.initModality(
                    Modality.APPLICATION_MODAL
            );

            stage.setScene(scene);

            stage.showAndWait();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}