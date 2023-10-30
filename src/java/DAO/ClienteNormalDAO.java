
package DAO;

import Clases.Cliente;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import oracle.jdbc.OracleTypes;
import java.sql.ResultSet;

public class ClienteNormalDAO {
    private Connection conexion;

    public ClienteNormalDAO() {
    }
     //Agregar Cliente normal
    public boolean agregarClienteNormal(Cliente cli) throws SQLException{
        boolean centinela = false;
        try{
            //Abrir la conexion. La variable conexion va a ser igual a la nueva conexion. 
            //El primer conexion despues del new va al package y el segundo a la clase conexion
            this.conexion = new Conexion.Conexion().obtenerConexion();
            //Crear la llamada al procedimiento Agregar o Crear
            String llamada = "{ call PKG_CLIENTE.sp_crearCliente(?,?,?,?,?,?,?,?,?,?)}";
            //Crear el callablestatement para poder ejecutar el procedimiento
            CallableStatement cstmt = this.conexion.prepareCall(llamada);
            //Pasar los datos del admin al procedimiento
            cstmt.setInt(1, cli.getRut());
            cstmt.setString(2, cli.getDv());
            cstmt.setString(3, cli.getNombre());
            cstmt.setString(4, cli.getApellidopat());
            cstmt.setString(5, cli.getApellidomat());
            cstmt.setString(6, cli.getDireccion());
            cstmt.setString(7, cli.getFechanacimiento());
            cstmt.setString(8, cli.getCorreoelectronico());
            cstmt.setString(9, cli.getContrasena());
            cstmt.setString(10, cli.getComuna_idcomuna());
            //Ejecutar el procedimiento y comprobar si guardo algo
            if (cstmt.executeUpdate()>0){
                centinela = true;
            }         
        } catch (Exception e){
            System.out.println("Error al guardar"+e.getMessage());
        } finally{
            this.conexion.close();            
        }    
        return centinela;
        
    }  
    
    //Listar Clientes (Normal y Empresa)
    public List<Cliente> listarClientes() throws SQLException{
        List<Cliente> lista = new ArrayList<>();
        try {
            //Abrir la conexion
            this.conexion = new Conexion.Conexion().obtenerConexion();
            //Crear la llamada al procedimiento Listar
            String llamada = "{call PKG_CLIENTE.sp_listarClientesforadmin(?)}";
            //Crear callablestatement
            CallableStatement cstmt = this.conexion.prepareCall(llamada);
            //Pasamos el cursor del procedimiento
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute(); //Se ejecuta el procedimiento
            //Se usa el ResultSet para obtener la información del cursor (se castea)
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            //Recorrer el rs y sacar los Admin
            while (rs.next()){
                Cliente cli = new Cliente();
                cli.setId_cliente(rs.getString("id_cliente"));
                cli.setRut(rs.getInt("rut"));
                cli.setDv(rs.getString("dv"));
                cli.setNombre(rs.getString("nombre"));
                cli.setApellidopat(rs.getString("apellidopat"));
                cli.setApellidomat(rs.getString("apellidomat"));
                cli.setEstadoactivo(rs.getString("estadoactivo"));
                cli.setDireccion(rs.getString("direccion"));
                cli.setFechanacimiento(rs.getString("fechanacimiento"));
                cli.setCorreoelectronico(rs.getString("correoelectronico"));
                cli.setContrasena(rs.getString("contrasena"));
                cli.setIdentificadorempresa(rs.getString("identificadorempresa"));
                cli.setRazonsocial(rs.getString("razonsocial"));
                cli.setComuna_idcomuna(rs.getString("nombrecomuna"));
                cli.setTipocliente_idcliente(rs.getString("descripciontipo"));          
                //Pasamos el objeto a la lista
                lista.add(cli);     
            }
        } catch (Exception e) {
            System.out.println("Error al listar Clientes"+e.getMessage());
        } finally{
            this.conexion.close();
        }
        return lista;
        }
    
    //Actualizar Cliente normal  
   public boolean modificarClientenormal(int rutabuscar, Cliente cli) throws SQLException {
        boolean centinela = false;
        try {
            // Abrir la conexión
            this.conexion = new Conexion.Conexion().obtenerConexion();
            // Crear la llamada al procedimiento almacenado de modificación
            String llamada = "{ call PKG_CLIENTE.sp_actualizarclientenormal(?,?,?,?,?,?,?,?,?)}";
            // Crear el CallableStatement para ejecutar el procedimiento
            CallableStatement cstmt = this.conexion.prepareCall(llamada);
            // Pasar los datos del admin al procedimiento
            cstmt.setInt(1, rutabuscar);
            cstmt.setString(2, cli.getNombre()); 
            cstmt.setString(3, cli.getApellidopat());
            cstmt.setString(4, cli.getApellidomat());
            cstmt.setString(5, cli.getDireccion());
            cstmt.setString(6, cli.getFechanacimiento());
            cstmt.setString(7, cli.getCorreoelectronico());
            cstmt.setString(8, cli.getContrasena());
            cstmt.setString(9, cli.getComuna_idcomuna());
            // Obtener el resultado del procedimiento almacenado
                if (cstmt.executeUpdate()>0){
                    centinela = true;
                }
        } catch (Exception e) {
            System.out.println("Error al modificar Cliente: " + e.getMessage());
        } finally {
            this.conexion.close();
        }
        return centinela;
        }   
   
    //Eliminar Cliente Normal  
    public boolean eliminarDefinitivoClienteNormal(int rutaeliminar) throws SQLException {
        boolean centinela = false;
        try {
            this.conexion = new Conexion.Conexion().obtenerConexion();
            String llamada = "{call PKG_CLIENTE.sp_eliminarclienteforadminxrut(?)}";
            CallableStatement cstmt = this.conexion.prepareCall(llamada);
            cstmt.setInt(1, rutaeliminar); 
            //Ejecutamos y se revisa si funciona el eliminar
            if(cstmt.executeUpdate()>0){
                centinela = true;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar Cliente"+e.getMessage());
        } finally{
              this.conexion.close();          
        }
        return centinela;
    }
 
    //Listar cliente normal por rut
    public Cliente listarClienteNormalxRut(int rutabuscar) throws SQLException {
        Cliente cli = new Cliente();
    try {
        //Abrir la conexion
        this.conexion = new Conexion.Conexion().obtenerConexion();
        //Crear la llamada al procedimiento Listar
        String llamada = "{call PKG_CLIENTE.sp_listarclientexrut(?,?)}";
        //Crear callablestatement
        CallableStatement cstmt = this.conexion.prepareCall(llamada);
        //Pasamos el nombre de usuario como parámetro
        cstmt.setInt(2, rutabuscar);
        //Pasamos el cursor del procedimiento
        cstmt.registerOutParameter(1, OracleTypes.CURSOR);
        cstmt.execute(); //Se ejecuta el procedimiento
        //Se usa el ResultSet para obtener la información del cursor (se castea)
        ResultSet rs = (ResultSet) cstmt.getObject(1);
        //Recorrer el rs y sacar los Consultoreslientes
        while (rs.next()){
                cli.setId_cliente(rs.getString("id_cliente"));
                cli.setRut(rs.getInt("rut"));
                cli.setDv(rs.getString("dv"));
                cli.setNombre(rs.getString("nombre"));
                cli.setApellidopat(rs.getString("apellidopat"));
                cli.setApellidomat(rs.getString("apellidomat"));
                cli.setDireccion(rs.getString("direccion"));
                cli.setFechanacimiento(rs.getString("fechanacimiento"));
                cli.setCorreoelectronico(rs.getString("correoelectronico"));
                cli.setContrasena(rs.getString("contrasena"));
                cli.setComuna_idcomuna(rs.getString("nombrecomuna"));
                cli.setTipocliente_idcliente(rs.getString("descripciontipo"));
        }    
        } catch (Exception e) {
            System.out.println("Error al listar Clientes"+e.getMessage());
        } finally{
            this.conexion.close();
        }
        return cli;
        }
    
    //Eliminar(DESACTIVAR) Cliente Normal (Cambio de estado Cliente)
    public boolean desactivarCuentaClienteNormal(int rut, Cliente cli) throws SQLException {
        boolean centinela = false;
        try {
            // Abrir la conexión
            this.conexion = new Conexion.Conexion().obtenerConexion();
            // Crear la llamada al procedimiento almacenado de modificación
            String llamada = "{ call PKG_CLIENTE.sp_eliminarclientexrut(?)}";
            // Crear el CallableStatement para ejecutar el procedimiento
            CallableStatement cstmt = this.conexion.prepareCall(llamada);
            // Pasar los datos del admin al procedimiento
            cstmt.setInt(1, rut);
            // Obtener el resultado del procedimiento almacenado
                if (cstmt.executeUpdate()>0){
                    centinela = true;
                }
        } catch (Exception e) {
            System.out.println("Error al desactivar cuenta Cliente: " + e.getMessage());
        } finally {
            this.conexion.close();
        }
        return centinela;
        }
       
    
}
