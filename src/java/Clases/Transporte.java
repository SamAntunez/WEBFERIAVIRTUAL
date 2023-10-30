
package Clases;


public class Transporte {
    private String patente; 
    private int capacidadcarga; 
    private String frigorificotrans;
    private String permisocirculacion; 
    private int transportista_rut; 
    private String modelo_idmodelo; 

    public Transporte() {
    }

    public Transporte(String patente, int capacidadcarga, String frigorificotrans, String permisocirculacion, int transportista_rut, String modelo_idmodelo) {
        this.patente = patente;
        this.capacidadcarga = capacidadcarga;
        this.frigorificotrans = frigorificotrans;
        this.permisocirculacion = permisocirculacion;
        this.transportista_rut = transportista_rut;
        this.modelo_idmodelo = modelo_idmodelo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getCapacidadcarga() {
        return capacidadcarga;
    }

    public void setCapacidadcarga(int capacidadcarga) {
        this.capacidadcarga = capacidadcarga;
    }

    public String getFrigorificotrans() {
        return frigorificotrans;
    }

    public void setFrigorificotrans(String frigorificotrans) {
        this.frigorificotrans = frigorificotrans;
    }

    public String getPermisocirculacion() {
        return permisocirculacion;
    }

    public void setPermisocirculacion(String permisocirculacion) {
        this.permisocirculacion = permisocirculacion;
    }

    public int getTransportista_rut() {
        return transportista_rut;
    }

    public void setTransportista_rut(int transportista_rut) {
        this.transportista_rut = transportista_rut;
    }

    public String getModelo_idmodelo() {
        return modelo_idmodelo;
    }

    public void setModelo_idmodelo(String modelo_idmodelo) {
        this.modelo_idmodelo = modelo_idmodelo;
    }

    @Override
    public String toString() {
        return "Transporte{" + "patente=" + patente + ", capacidadcarga=" + capacidadcarga + ", frigorificotrans=" + frigorificotrans + ", permisocirculacion=" + permisocirculacion + ", transportista_rut=" + transportista_rut + ", modelo_idmodelo=" + modelo_idmodelo + '}';
    }
    
    
}
