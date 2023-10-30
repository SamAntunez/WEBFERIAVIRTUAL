
package Clases;


public class ContratoTransporte {
    private String id_contrato;
    private String fechacontrato;
    private String idordent;

    public ContratoTransporte() {
    }

    public ContratoTransporte(String id_contrato, String fechacontrato, String idordent) {
        this.id_contrato = id_contrato;
        this.fechacontrato = fechacontrato;
        this.idordent = idordent;
    }

    public String getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(String id_contrato) {
        this.id_contrato = id_contrato;
    }

    public String getFechacontrato() {
        return fechacontrato;
    }

    public void setFechacontrato(String fechacontrato) {
        this.fechacontrato = fechacontrato;
    }

    public String getIdordent() {
        return idordent;
    }

    public void setIdordent(String idordent) {
        this.idordent = idordent;
    }

    @Override
    public String toString() {
        return "ContratoTransporte{" + "id_contrato=" + id_contrato + ", fechacontrato=" + fechacontrato + ", idordent=" + idordent + '}';
    }
    
    
}
