package Clases;

public class Login {
    private String identificador;
    private String tipousuario;
    private String correoelectronico;
    private String contrasena;
    private String nombre;

    public Login() {
    }

    public Login(String identificador, String tipousuario, String correoelectronico, String contrasena, String nombre) {
        this.identificador = identificador;
        this.tipousuario = tipousuario;
        this.correoelectronico = correoelectronico;
        this.contrasena = contrasena;
        this.nombre = nombre;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(String tipousuario) {
        this.tipousuario = tipousuario;
    }

    public String getCorreoelectronico() {
        return correoelectronico;
    }

    public void setCorreoelectronico(String correoelectronico) {
        this.correoelectronico = correoelectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Login{" + "identificador=" + identificador + ", tipousuario=" + tipousuario + ", correoelectronico=" + correoelectronico + ", contrasena=" + contrasena + ", nombre=" + nombre + '}';
    }





}