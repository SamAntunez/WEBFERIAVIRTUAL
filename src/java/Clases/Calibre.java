package Clases;


public class Calibre {
    private String idcalibre;
    private String desccalibre;

    public Calibre() {
    }

    public String getIdcalibre() {
        return idcalibre;
    }

    public void setIdcalibre(String idcalibre) {
        this.idcalibre = idcalibre;
    }

    public String getDesccalibre() {
        return desccalibre;
    }

    public void setDesccalibre(String desccalibre) {
        this.desccalibre = desccalibre;
    }

    @Override
    public String toString() {
        return "Calibre{" + "idcalibre=" + idcalibre + ", desccalibre=" + desccalibre + '}';
    }


}