
package Clases;


public class ProductorProducto {
    private int precio; 
    private int stock; 
    private String calibre_idcalibre;
    private String producto_idproducto; 
    private int productor_rut;
    private String img;
    private String nombre_productor;

    public ProductorProducto() {
    }

    public ProductorProducto(int precio, int stock, String calibre_idcalibre, String producto_idproducto, int productor_rut, String img, String nombre_productor) {
        this.precio = precio;
        this.stock = stock;
        this.calibre_idcalibre = calibre_idcalibre;
        this.producto_idproducto = producto_idproducto;
        this.productor_rut = productor_rut;
        this.img = img;
        this.nombre_productor = nombre_productor;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCalibre_idcalibre() {
        return calibre_idcalibre;
    }

    public void setCalibre_idcalibre(String calibre_idcalibre) {
        this.calibre_idcalibre = calibre_idcalibre;
    }

    public String getProducto_idproducto() {
        return producto_idproducto;
    }

    public void setProducto_idproducto(String producto_idproducto) {
        this.producto_idproducto = producto_idproducto;
    }

    public int getProductor_rut() {
        return productor_rut;
    }

    public void setProductor_rut(int productor_rut) {
        this.productor_rut = productor_rut;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNombre_productor() {
        return nombre_productor;
    }

    public void setNombre_productor(String nombre_productor) {
        this.nombre_productor = nombre_productor;
    }

    @Override
    public String toString() {
        return "ProductorProducto{" + "precio=" + precio + ", stock=" + stock + ", calibre_idcalibre=" + calibre_idcalibre + ", producto_idproducto=" + producto_idproducto + ", productor_rut=" + productor_rut + ", img=" + img + ", nombre_productor=" + nombre_productor + '}';
    }

   
    
    
}
