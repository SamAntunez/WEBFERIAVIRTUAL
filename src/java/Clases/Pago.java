
package Clases;


public class Pago {
    private String idpago;
    private String fechapago;
    private String estadopago;
    private String pedido_idpedido;
    private String estadopago_idpago;

    public Pago() {
    }

    public Pago(String idpago, String fechapago, String estadopago, String pedido_idpedido, String estadopago_idpago) {
        this.idpago = idpago;
        this.fechapago = fechapago;
        this.estadopago = estadopago;
        this.pedido_idpedido = pedido_idpedido;
        this.estadopago_idpago = estadopago_idpago;
    }

    public String getIdpago() {
        return idpago;
    }

    public void setIdpago(String idpago) {
        this.idpago = idpago;
    }

    public String getFechapago() {
        return fechapago;
    }

    public void setFechapago(String fechapago) {
        this.fechapago = fechapago;
    }

    public String getEstadopago() {
        return estadopago;
    }

    public void setEstadopago(String estadopago) {
        this.estadopago = estadopago;
    }

    public String getPedido_idpedido() {
        return pedido_idpedido;
    }

    public void setPedido_idpedido(String pedido_idpedido) {
        this.pedido_idpedido = pedido_idpedido;
    }

    public String getEstadopago_idpago() {
        return estadopago_idpago;
    }

    public void setEstadopago_idpago(String estadopago_idpago) {
        this.estadopago_idpago = estadopago_idpago;
    }

    @Override
    public String toString() {
        return "Pago{" + "idpago=" + idpago + ", fechapago=" + fechapago + ", estadopago=" + estadopago + ", pedido_idpedido=" + pedido_idpedido + ", estadopago_idpago=" + estadopago_idpago + '}';
    }
    
    
}
