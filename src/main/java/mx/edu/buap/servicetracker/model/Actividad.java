package mx.edu.buap.servicetracker.model;

import java.time.LocalDate;

public class Actividad {

    private LocalDate fecha;
    private String descripcion;
    private String tecnico;

    public Actividad() {
    }

    public Actividad(
            LocalDate fecha,
            String descripcion,
            String tecnico
    ) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.tecnico = tecnico;
    }

    public LocalDate getFecha() {return fecha;}
    public void setFecha(LocalDate fecha) {this.fecha = fecha;}

    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public String getTecnico() {return tecnico;}
    public void setTecnico(String tecnico) {this.tecnico = tecnico;}
}
