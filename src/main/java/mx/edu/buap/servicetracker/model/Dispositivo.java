package mx.edu.buap.servicetracker.model;

import java.time.LocalDate;

public class Dispositivo {

    private String propietario;
    private String area;

    private String marca;
    private String modelo;
    private String numeroSerie;
    private String tipo;

    private LocalDate fechaIngreso;

    private String prioridad;

    private String comentarios;

    public Dispositivo() {
    }

    public Dispositivo(
            String propietario,
            String area,
            String marca,
            String modelo,
            String numeroSerie,
            String tipo,
            LocalDate fechaIngreso,
            String prioridad,
            String comentarios
    ) {
        this.propietario = propietario;
        this.area = area;
        this.marca = marca;
        this.modelo = modelo;
        this.numeroSerie = numeroSerie;
        this.tipo = tipo;
        this.fechaIngreso = fechaIngreso;
        this.prioridad = prioridad;
        this.comentarios = comentarios;
    }

    public String getPropietario() {return propietario;}
    public void setPropietario(String propietario) {this.propietario = propietario;}

    public String getArea() {return area;}
    public void setArea(String area) {this.area = area;}

    public String getMarca() {return marca;}
    public void setMarca(String marca) {this.marca = marca;}

    public String getModelo() {return modelo;}
    public void setModelo(String modelo) {this.modelo = modelo;}

    public String getNumeroSerie() {return numeroSerie;}
    public void setNumeroSerie(String numeroSerie) {this.numeroSerie = numeroSerie;}

    public String getTipo() {return tipo;}
    public void setTipo(String tipo) {this.tipo = tipo;}

    public LocalDate getFechaIngreso() {return fechaIngreso;}
    public void setFechaIngreso(LocalDate fechaIngreso) {this.fechaIngreso = fechaIngreso;}

    public String getPrioridad() {return prioridad;}
    public void setPrioridad(String prioridad) {this.prioridad = prioridad;}

    public String getComentarios() {return comentarios;}
    public void setComentarios(String comentarios) {this.comentarios = comentarios;}

    @Override
    public String toString() {
        return "Dispositivo{" +
                "propietario='" + propietario + '\'' +
                ", area='" + area + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", numeroSerie='" + numeroSerie + '\'' +
                ", tipo='" + tipo + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                ", prioridad='" + prioridad + '\'' +
                '}';
    }
}