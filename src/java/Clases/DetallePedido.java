
package Clases;


public class DetallePedido {
    private int cantidad;
    private String idproducto;
    private int productor_rut;
    private String pedido_idpedido;

    public DetallePedido() {
    }

    public DetallePedido(int cantidad, String idproducto, int productor_rut, String pedido_idpedido) {
        this.cantidad = cantidad;
        this.idproducto = idproducto;
        this.productor_rut = productor_rut;
        this.pedido_idpedido = pedido_idpedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
    }

    public int getProductor_rut() {
        return productor_rut;
    }

    public void setProductor_rut(int productor_rut) {
        this.productor_rut = productor_rut;
    }

    public String getPedido_idpedido() {
        return pedido_idpedido;
    }

    public void setPedido_idpedido(String pedido_idpedido) {
        this.pedido_idpedido = pedido_idpedido;
    }

    @Override
    public String toString() {
        return "DetallePedido{" + "cantidad=" + cantidad + ", idproducto=" + idproducto + ", productor_rut=" + productor_rut + ", pedido_idpedido=" + pedido_idpedido + '}';
    }
    
    
    
    
}
