    
package Clases;

public class Administrador {
    private String idusuario;
    private String nombreusuario;
    private String contrasenausuario;

    public Administrador() {
    }

    public Administrador(String idusuario, String nombreusuario, String contrasenausuario) {
        this.idusuario = idusuario;
        this.nombreusuario = nombreusuario;
        this.contrasenausuario = contrasenausuario;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getContrasenausuario() {
        return contrasenausuario;
    }

    public void setContrasenausuario(String contrasenausuario) {
        this.contrasenausuario = contrasenausuario;
    }

    @Override
    public String toString() {
        return "Administrador{" + "idusuario=" + idusuario + ", nombreusuario=" + nombreusuario + ", contrasenausuario=" + contrasenausuario + '}';
    }
              
}
