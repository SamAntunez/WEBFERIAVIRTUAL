package Clases;


public class Producto {
    private String idproducto;
    private String nombreproducto;
    private String descproducto;
    private String caterogia_idcategoria;

    public Producto() {
    }

    public Producto(String idproducto, String nombreproducto, String descproducto, String caterogia_idcategoria) {
        this.idproducto = idproducto;
        this.nombreproducto = nombreproducto;
        this.descproducto = descproducto;
        this.caterogia_idcategoria = caterogia_idcategoria;
    }

    public String getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombreproducto() {
        return nombreproducto;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    public String getDescproducto() {
        return descproducto;
    }

    public void setDescproducto(String descproducto) {
        this.descproducto = descproducto;
    }

    public String getCaterogia_idcategoria() {
        return caterogia_idcategoria;
    }

    public void setCaterogia_idcategoria(String caterogia_idcategoria) {
        this.caterogia_idcategoria = caterogia_idcategoria;
    }

    @Override
    public String toString() {
        return "Producto{" + "idproducto=" + idproducto + ", nombreproducto=" + nombreproducto + ", descproducto=" + descproducto + ", caterogia_idcategoria=" + caterogia_idcategoria + '}';
    }



}
