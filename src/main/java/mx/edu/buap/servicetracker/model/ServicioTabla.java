package mx.edu.buap.servicetracker.model;

public class ServicioTabla {

    private String folio;
    private String propietario;
    private String equipo;
    private String estado;
    private String tecnico;
    private String prioridad;

    public ServicioTabla(String folio, String propietario, String equipo, String estado, String tecnico, String prioridad) {
        this.folio = folio;
        this.propietario = propietario;
        this.equipo = equipo;
        this.estado = estado;
        this.tecnico = tecnico;
        this.prioridad = prioridad;
    }

    public String getFolio() {return folio;}

    public String getPropietario() {return propietario;}

    public String getEquipo() {return equipo;}

    public String getEstado() {return estado;}

    public String getTecnico() {return tecnico;}

    public String getPrioridad() {return prioridad;}
}