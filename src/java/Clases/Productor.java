
package Clases;


public class Productor {
    private int rut;
    private String dv;
    private String nombre;
    private String apellidopat;
    private String apellidomat;
    private String estadoactivo;
    private String fechanacimiento; 
    private String direccion;
    private String correoelectronico; 
    private String contrasena; 
    private String comuna_idcomuna;

    public Productor() {
    }

    public Productor(int rut, String dv, String nombre, String apellidopat, String apellidomat, String estadoactivo, String fechanacimiento, String direccion, String correoelectronico, String contrasena, String comuna_idcomuna) {
        this.rut = rut;
        this.dv = dv;
        this.nombre = nombre;
        this.apellidopat = apellidopat;
        this.apellidomat = apellidomat;
        this.estadoactivo = estadoactivo;
        this.fechanacimiento = fechanacimiento;
        this.direccion = direccion;
        this.correoelectronico = correoelectronico;
        this.contrasena = contrasena;
        this.comuna_idcomuna = comuna_idcomuna;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }
    
    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidopat() {
        return apellidopat;
    }

    public void setApellidopat(String apellidopat) {
        this.apellidopat = apellidopat;
    }

    public String getApellidomat() {
        return apellidomat;
    }

    public void setApellidomat(String apellidomat) {
        this.apellidomat = apellidomat;
    }

    public String getEstadoactivo() {
        return estadoactivo;
    }

    public void setEstadoactivo(String estadoactivo) {
        this.estadoactivo = estadoactivo;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public String getComuna_idcomuna() {
        return comuna_idcomuna;
    }

    public void setComuna_idcomuna(String comuna_idcomuna) {
        this.comuna_idcomuna = comuna_idcomuna;
    }

    @Override
    public String toString() {
        return "Productor{" + "rut=" + rut + ", dv=" + dv + ", nombre=" + nombre + ", apellidopat=" + apellidopat + ", apellidomat=" + apellidomat + ", estadoactivo=" + estadoactivo + ", fechanacimiento=" + fechanacimiento + ", direccion=" + direccion + ", correoelectronico=" + correoelectronico + ", contrasena=" + contrasena + ", comuna_idcomuna=" + comuna_idcomuna + '}';
    }

    
     
    
}
