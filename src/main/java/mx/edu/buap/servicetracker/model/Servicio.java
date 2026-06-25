package mx.edu.buap.servicetracker.model;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Servicio {

    private String folio;
    private Dispositivo dispositivo;
    private String tecnico;
    private String estado;
    private LocalDate fechaAsignacion;
    private LocalDate fechaEstimadaEntrega;
    private LocalDate fechaEntrega;

    private List<Actividad> actividades = new ArrayList<>();

    public Servicio() {
    }

    public String getFolio() {return folio;}
    public void setFolio(String folio) {this.folio = folio;}

    public Dispositivo getDispositivo() {return dispositivo;}
    public void setDispositivo(Dispositivo dispositivo) {this.dispositivo = dispositivo;}

    public String getTecnico() {return tecnico;}
    public void setTecnico(String tecnico) {this.tecnico = tecnico;}

    public String getEstado() {return estado;}
    public void setEstado(String estado) {this.estado = estado;}

    public LocalDate getFechaAsignacion() {return fechaAsignacion;}
    public void setFechaAsignacion(LocalDate fechaAsignacion) {this.fechaAsignacion = fechaAsignacion;}

    public LocalDate getFechaEstimadaEntrega() {return fechaEstimadaEntrega;}
    public void setFechaEstimadaEntrega(LocalDate fechaEstimadaEntrega) {this.fechaEstimadaEntrega = fechaEstimadaEntrega;}

    public LocalDate getFechaEntrega() {return fechaEntrega;}
    public void setFechaEntrega(LocalDate fechaEntrega) {this.fechaEntrega = fechaEntrega;}

    public List<Actividad> getActividades() {return actividades;}
    public void setActividades(List<Actividad> actividades) {this.actividades = actividades;}

    private String diagnostico;
    private String comentariosFinales;

    //Metodo para convertir el "Servicio" a formato JSON
    @Override
    public String toString() {
        return "Servicio{" +
                "folio='" + folio + '\'' +
                ", tecnico='" + tecnico + '\'' +
                ", estado='" + estado + '\'' +
                ", dispositivo=" + dispositivo +
                '}';
    }
}