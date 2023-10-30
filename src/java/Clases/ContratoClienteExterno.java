
package Clases;


public class ContratoClienteExterno {
    private String idcontrato;
    private String fechainiciocontrato;
    private String fechaterminocontrato;
    private String cliente_id_cliente;

    public ContratoClienteExterno() {
    }

    public ContratoClienteExterno(String idcontrato, String fechainiciocontrato, String fechaterminocontrato, String cliente_id_cliente) {
        this.idcontrato = idcontrato;
        this.fechainiciocontrato = fechainiciocontrato;
        this.fechaterminocontrato = fechaterminocontrato;
        this.cliente_id_cliente = cliente_id_cliente;
    }

    public String getIdcontrato() {
        return idcontrato;
    }

    public void setIdcontrato(String idcontrato) {
        this.idcontrato = idcontrato;
    }

    public String getFechainiciocontrato() {
        return fechainiciocontrato;
    }

    public void setFechainiciocontrato(String fechainiciocontrato) {
        this.fechainiciocontrato = fechainiciocontrato;
    }

    public String getFechaterminocontrato() {
        return fechaterminocontrato;
    }

    public void setFechaterminocontrato(String fechaterminocontrato) {
        this.fechaterminocontrato = fechaterminocontrato;
    }

    public String getCliente_id_cliente() {
        return cliente_id_cliente;
    }

    public void setCliente_id_cliente(String cliente_id_cliente) {
        this.cliente_id_cliente = cliente_id_cliente;
    }

    @Override
    public String toString() {
        return "ContratoClienteExterno{" + "idcontrato=" + idcontrato + ", fechainiciocontrato=" + fechainiciocontrato + ", fechaterminocontrato=" + fechaterminocontrato + ", cliente_id_cliente=" + cliente_id_cliente + '}';
    }
    
    
    
}
