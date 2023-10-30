
package Clases;


public class OrdenTransporte {
    private String idordent;
    private String descordent;
    private String fechatransporte;
    private Integer diasdepacho;
    private String direccionorigen;
    private String direcciondestino;
    private String pedido_idpedido;
    private Integer transportista_rut;

    public OrdenTransporte() {
    }

    public OrdenTransporte(String idordent, String descordent, String fechatransporte, Integer diasdepacho, String direccionorigen, String direcciondestino, String pedido_idpedido, Integer transportista_rut) {
        this.idordent = idordent;
        this.descordent = descordent;
        this.fechatransporte = fechatransporte;
        this.diasdepacho = diasdepacho;
        this.direccionorigen = direccionorigen;
        this.direcciondestino = direcciondestino;
        this.pedido_idpedido = pedido_idpedido;
        this.transportista_rut = transportista_rut;
    }

    public String getIdordent() {
        return idordent;
    }

    public void setIdordent(String idordent) {
        this.idordent = idordent;
    }

    public String getDescordent() {
        return descordent;
    }

    public void setDescordent(String descordent) {
        this.descordent = descordent;
    }

    public String getFechatransporte() {
        return fechatransporte;
    }

    public void setFechatransporte(String fechatransporte) {
        this.fechatransporte = fechatransporte;
    }

    public Integer getDiasdepacho() {
        return diasdepacho;
    }

    public void setDiasdepacho(Integer diasdepacho) {
        this.diasdepacho = diasdepacho;
    }

    public String getDireccionorigen() {
        return direccionorigen;
    }

    public void setDireccionorigen(String direccionorigen) {
        this.direccionorigen = direccionorigen;
    }

    public String getDirecciondestino() {
        return direcciondestino;
    }

    public void setDirecciondestino(String direcciondestino) {
        this.direcciondestino = direcciondestino;
    }

    public String getPedido_idpedido() {
        return pedido_idpedido;
    }

    public void setPedido_idpedido(String pedido_idpedido) {
        this.pedido_idpedido = pedido_idpedido;
    }

    public Integer getTransportista_rut() {
        return transportista_rut;
    }

    public void setTransportista_rut(Integer transportista_rut) {
        this.transportista_rut = transportista_rut;
    }

    @Override
    public String toString() {
        return "OrdenTransporte{" + "idordent=" + idordent + ", descordent=" + descordent + ", fechatransporte=" + fechatransporte + ", diasdepacho=" + diasdepacho + ", direccionorigen=" + direccionorigen + ", direcciondestino=" + direcciondestino + ", pedido_idpedido=" + pedido_idpedido + ", transportista_rut=" + transportista_rut + '}';
    }
    
    
}
