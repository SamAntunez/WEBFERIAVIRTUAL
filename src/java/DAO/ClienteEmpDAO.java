
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

/**
 *
 * @author baroc
 */
public class ClienteEmpDAO {
    private Connection conexion;

    public ClienteEmpDAO() {
    }
         //Agregar Cliente Empresa 
    public boolean agregarClienteEmp(Cliente cli) throws SQLException{
        boolean centinela = false;
        try{
            //Abrir la conexion. La variable conexion va a ser igual a la nueva conexion. 
            //El primer conexion despues del new va al package y el segundo a la clase conexion
            this.conexion = new Conexion.Conexion().obtenerConexion();
            //Crear la llamada al procedimiento Agregar o Crear
            String llamada = "{ call sp_clienteemp(?,?,?,?,?,?)}";
            //Crear el callablestatement para poder ejecutar el procedimiento
            CallableStatement cstmt = this.conexion.prepareCall(llamada);
            //Pasar los datos del admin al procedimiento
            cstmt.setString(1, cli.getDireccion());
            cstmt.setString(2, cli.getCorreoelectronico());
            cstmt.setString(3, cli.getContrasena());
            cstmt.setString(4, cli.getIdentificadorempresa());
            cstmt.setString(5, cli.getRazonsocial());
            cstmt.setString(6, cli.getComuna_idcomuna());
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
    //Modificar Cliente Empresa
    public boolean modificarClienteEmpresa(String identificadorabuscar, Cliente cli) throws SQLException {
        boolean centinela = false;
        try {
            // Abrir la conexión
            this.conexion = new Conexion.Conexion().obtenerConexion();
            // Crear la llamada al procedimiento almacenado de modificación
            String llamada = "{ call PKG_CLIENTE.sp_actualizarclienteemp(?,?,?,?,?,?)}";
            // Crear el CallableStatement para ejecutar el procedimiento
            CallableStatement cstmt = this.conexion.prepareCall(llamada);
            // Pasar los datos del admin al procedimiento
            cstmt.setString(1, identificadorabuscar);
            cstmt.setString(2, cli.getDireccion());
            cstmt.setString(3, cli.getCorreoelectronico());
            cstmt.setString(4, cli.getContrasena());
            cstmt.setString(5, cli.getRazonsocial());
            cstmt.setString(6, cli.getComuna_idcomuna());
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
   
    //Eliminar Cliente Empresa
    public boolean eliminarDefinitivoClienteEmpresa(String identificadoraeliminar) throws SQLException {
        boolean centinela = false;
        try {
            this.conexion = new Conexion.Conexion().obtenerConexion();
            String llamada = "{call PKG_CLIENTE.sp_eliminarclienteforadminxemp(?)}";
            CallableStatement cstmt = this.conexion.prepareCall(llamada);
            cstmt.setString(11, identificadoraeliminar); 
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
    
    //Listar cliente empresa por identificador empresa
    public Cliente listarClienteEmpresaxidentificador(String identificadorabuscar) throws SQLException {
        Cliente cli = new Cliente();
    try {
        //Abrir la conexion
        this.conexion = new Conexion.Conexion().obtenerConexion();
        //Crear la llamada al procedimiento Listar
        String llamada = "{call PKG_CLIENTE.sp_listarclientexidentificadoremp(?,?)}";
        //Crear callablestatement
        CallableStatement cstmt = this.conexion.prepareCall(llamada);
        //Pasamos el nombre de usuario como parámetro
        cstmt.setString(2,identificadorabuscar);
        //Pasamos el cursor del procedimiento
        cstmt.registerOutParameter(1, OracleTypes.CURSOR);
        cstmt.execute(); //Se ejecuta el procedimiento
        //Se usa el ResultSet para obtener la información del cursor (se castea)
        ResultSet rs = (ResultSet) cstmt.getObject(1);
        //Recorrer el rs y sacar los clientes
        while (rs.next()){
                cli.setId_cliente(rs.getString("id_cliente"));
                cli.setDireccion(rs.getString("direccion"));
                cli.setCorreoelectronico(rs.getString("correoelectronico"));
                cli.setContrasena(rs.getString("contrasena"));
                cli.setIdentificadorempresa(rs.getString("identificadorempresa"));
                cli.setRazonsocial(rs.getString("razonsocial"));
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
    
    //Eliminar(DESACTIVAR) Cliente Empresa (Cambio de estado Cliente)
    public boolean desactivarCuentaClienteEmpresa(String identificadorabuscar, Cliente cli) throws SQLException {
        boolean centinela = false;
        try {
            // Abrir la conexión
            this.conexion = new Conexion.Conexion().obtenerConexion();
            // Crear la llamada al procedimiento almacenado de modificación
            String llamada = "{ call PKG_CLIENTE.sp_eliminarclientexemp(?)}";
            // Crear el CallableStatement para ejecutar el procedimiento
            CallableStatement cstmt = this.conexion.prepareCall(llamada);
            // Pasar los datos del admin al procedimiento
            cstmt.setString(1, identificadorabuscar);
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
