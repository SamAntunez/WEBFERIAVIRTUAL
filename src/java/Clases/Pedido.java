
package Clases;


public class Pedido {
    private String idpedido;
    private String fechapedido;
    private int totalpedido;
    private float iva;
    private float comisionmaipogrande;
    private int totaltransporte; 
    private int totalfinal;
    private int pesototalpedido;
    private String estadopedido_idestado;
    private String bodegamp_idbodega;
    private String tiposeguro_idtiposeguro; 
    private String cliente_id_cliente; 

    public Pedido() {
    }

    public Pedido(String idpedido, String fechapedido, int totalpedido, float iva, float comisionmaipogrande, int totaltransporte, int totalfinal, int pesototalpedido, String estadopedido_idestado, String bodegamp_idbodega, String tiposeguro_idtiposeguro, String cliente_id_cliente) {
        this.idpedido = idpedido;
        this.fechapedido = fechapedido;
        this.totalpedido = totalpedido;
        this.iva = iva;
        this.comisionmaipogrande = comisionmaipogrande;
        this.totaltransporte = totaltransporte;
        this.totalfinal = totalfinal;
        this.pesototalpedido = pesototalpedido;
        this.estadopedido_idestado = estadopedido_idestado;
        this.bodegamp_idbodega = bodegamp_idbodega;
        this.tiposeguro_idtiposeguro = tiposeguro_idtiposeguro;
        this.cliente_id_cliente = cliente_id_cliente;
    }

    public String getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(String idpedido) {
        this.idpedido = idpedido;
    }

    public String getFechapedido() {
        return fechapedido;
    }

    public void setFechapedido(String fechapedido) {
        this.fechapedido = fechapedido;
    }

    public int getTotalpedido() {
        return totalpedido;
    }

    public void setTotalpedido(int totalpedido) {
        this.totalpedido = totalpedido;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public float getComisionmaipogrande() {
        return comisionmaipogrande;
    }

    public void setComisionmaipogrande(float comisionmaipogrande) {
        this.comisionmaipogrande = comisionmaipogrande;
    }

    public int getTotaltransporte() {
        return totaltransporte;
    }

    public void setTotaltransporte(int totaltransporte) {
        this.totaltransporte = totaltransporte;
    }

    public int getTotalfinal() {
        return totalfinal;
    }

    public void setTotalfinal(int totalfinal) {
        this.totalfinal = totalfinal;
    }

    public int getPesototalpedido() {
        return pesototalpedido;
    }

    public void setPesototalpedido(int pesototalpedido) {
        this.pesototalpedido = pesototalpedido;
    }

    public String getEstadopedido_idestado() {
        return estadopedido_idestado;
    }

    public void setEstadopedido_idestado(String estadopedido_idestado) {
        this.estadopedido_idestado = estadopedido_idestado;
    }

    public String getBodegamp_idbodega() {
        return bodegamp_idbodega;
    }

    public void setBodegamp_idbodega(String bodegamp_idbodega) {
        this.bodegamp_idbodega = bodegamp_idbodega;
    }

    public String getTiposeguro_idtiposeguro() {
        return tiposeguro_idtiposeguro;
    }

    public void setTiposeguro_idtiposeguro(String tiposeguro_idtiposeguro) {
        this.tiposeguro_idtiposeguro = tiposeguro_idtiposeguro;
    }

    public String getCliente_id_cliente() {
        return cliente_id_cliente;
    }

    public void setCliente_id_cliente(String cliente_id_cliente) {
        this.cliente_id_cliente = cliente_id_cliente;
    }

    @Override
    public String toString() {
        return "Pedido{" + "idpedido=" + idpedido + ", fechapedido=" + fechapedido + ", totalpedido=" + totalpedido + ", iva=" + iva + ", comisionmaipogrande=" + comisionmaipogrande + ", totaltransporte=" + totaltransporte + ", totalfinal=" + totalfinal + ", pesototalpedido=" + pesototalpedido + ", estadopedido_idestado=" + estadopedido_idestado + ", bodegamp_idbodega=" + bodegamp_idbodega + ", tiposeguro_idtiposeguro=" + tiposeguro_idtiposeguro + ", cliente_id_cliente=" + cliente_id_cliente + '}';
    }
    
    
    
}
