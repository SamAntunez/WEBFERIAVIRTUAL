
package Clases;

public class Cliente {
    private String id_cliente;
    private int rut;
    private String dv;
    private String nombre;
    private String apellidopat;
    private String apellidomat;
    private String estadoactivo;
    private String direccion;
    private String fechanacimiento;
    private String correoelectronico;
    private String contrasena;
    private String identificadorempresa;
    private String razonsocial;
    private String comuna_idcomuna;
    private String tipocliente_idcliente;

    public Cliente() {
    }

    public Cliente(String id_cliente, int rut, String dv, String nombre, String apellidopat, String apellidomat, String estadoactivo, String direccion, String fechanacimiento, String correoelectronico, String contrasena, String identificadorempresa, String razonsocial, String comuna_idcomuna, String tipocliente_idcliente) {
        this.id_cliente = id_cliente;
        this.rut = rut;
        this.dv = dv;
        this.nombre = nombre;
        this.apellidopat = apellidopat;
        this.apellidomat = apellidomat;
        this.estadoactivo = estadoactivo;
        this.direccion = direccion;
        this.fechanacimiento = fechanacimiento;
        this.correoelectronico = correoelectronico;
        this.contrasena = contrasena;
        this.identificadorempresa = identificadorempresa;
        this.razonsocial = razonsocial;
        this.comuna_idcomuna = comuna_idcomuna;
        this.tipocliente_idcliente = tipocliente_idcliente;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
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

    public String getIdentificadorempresa() {
        return identificadorempresa;
    }

    public void setIdentificadorempresa(String identificadorempresa) {
        this.identificadorempresa = identificadorempresa;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getComuna_idcomuna() {
        return comuna_idcomuna;
    }

    public void setComuna_idcomuna(String comuna_idcomuna) {
        this.comuna_idcomuna = comuna_idcomuna;
    }

    public String getTipocliente_idcliente() {
        return tipocliente_idcliente;
    }

    public void setTipocliente_idcliente(String tipocliente_idcliente) {
        this.tipocliente_idcliente = tipocliente_idcliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id_cliente=" + id_cliente + ", rut=" + rut + ", dv=" + dv + ", nombre=" + nombre + ", apellidopat=" + apellidopat + ", apellidomat=" + apellidomat + ", estadoactivo=" + estadoactivo + ", direccion=" + direccion + ", fechanacimiento=" + fechanacimiento + ", correoelectronico=" + correoelectronico + ", contrasena=" + contrasena + ", identificadorempresa=" + identificadorempresa + ", razonsocial=" + razonsocial + ", comuna_idcomuna=" + comuna_idcomuna + ", tipocliente_idcliente=" + tipocliente_idcliente + '}';
    }
    
    
}
