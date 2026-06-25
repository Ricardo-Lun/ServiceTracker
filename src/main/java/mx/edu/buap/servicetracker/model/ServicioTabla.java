package mx.edu.buap.servicetracker.model;

public class ServicioTabla {

    private String folio;
    private String propietario;
    private String equipo;
    private String estado;
    private String tecnico;

    public ServicioTabla(String folio, String propietario, String equipo, String estado, String tecnico) {
        this.folio = folio;
        this.propietario = propietario;
        this.equipo = equipo;
        this.estado = estado;
        this.tecnico = tecnico;
    }

    public String getFolio() {return folio;}

    public String getPropietario() {return propietario;}

    public String getEquipo() {return equipo;}

    public String getEstado() {return estado;}

    public String getTecnico() {return tecnico;}
}