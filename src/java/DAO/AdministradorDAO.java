
package DAO;

import Clases.Administrador;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import oracle.jdbc.OracleTypes;
import java.sql.ResultSet;

public class AdministradorDAO {
    private Connection conexion;

    public AdministradorDAO() {
    }
    
    //Agregar Administrador
    public boolean agregarAdministrador(Administrador admin) throws SQLException{
        boolean centinela = false;
        try{
            //Abrir la conexion. La variable conexion va a ser igual a la nueva conexion. 
            //El primer conexion despues del new va al package y el segundo a la clase conexion
            this.conexion = new Conexion.Conexion().obtenerConexion();
            //Crear la llamada al procedimiento Agregar o Crear
            String llamada = "{ call PKG_ADMIN.sp_creacionadmin(?,?)}";
            //Crear el callablestatement para poder ejecutar el procedimiento
            CallableStatement cstmt = this.conexion.prepareCall(llamada);
            //Pasar los datos del admin al procedimiento
            cstmt.setString(1, admin.getNombreusuario());
            cstmt.setString(2, admin.getContrasenausuario());
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
    
    //Listar Administrador
    public List<Administrador> listarAdmin() throws SQLException{
        List<Administrador> lista = new ArrayList<>();
        try {
            //Abrir la conexion
            this.conexion = new Conexion.Conexion().obtenerConexion();
            //Crear la llamada al procedimiento Listar
            String llamada = "{call PKG_ADMIN.sp_listaradmin(?)}";
            //Crear callablestatement
            CallableStatement cstmt = this.conexion.prepareCall(llamada);
            //Pasamos el cursor del procedimiento
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute(); //Se ejecuta el procedimiento
            //Se usa el ResultSet para obtener la información del cursor (se castea)
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            //Recorrer el rs y sacar los Admin
            while (rs.next()){
                Administrador admin = new Administrador();
                admin.setIdusuario(rs.getString("idusuario"));
                admin.setNombreusuario(rs.getString("nombreusuario"));
                admin.setContrasenausuario(rs.getString("contrasenausuario"));
                //Pasamos el objeto a la lista
                lista.add(admin);     
            }
        } catch (Exception e) {
            System.out.println("Error al listar Administradores"+e.getMessage());
        } finally{
            this.conexion.close();
        }
        return lista;
        
    }
           
    //Actualizar Administrador
    public boolean modificarAdministrador(String nombreusuarioabuscar, Administrador admin) throws SQLException {
    boolean centinela = false;
    try {
        // Abrir la conexión
        this.conexion = new Conexion.Conexion().obtenerConexion();
        // Crear la llamada al procedimiento almacenado de modificación
        String llamada = "{ call PKG_ADMIN.sp_actualizaradmin(?,?)}";
        // Crear el CallableStatement para ejecutar el procedimiento
        CallableStatement cstmt = this.conexion.prepareCall(llamada);
        // Pasar los datos del admin al procedimiento
        cstmt.setString(1, nombreusuarioabuscar);
        cstmt.setString(2, admin.getContrasenausuario()); 

        // Obtener el resultado del procedimiento almacenado
            if (cstmt.executeUpdate()>0){
                centinela = true;
            }
    } catch (Exception e) {
        System.out.println("Error al modificar administrador: " + e.getMessage());
    } finally {
        this.conexion.close();
    }
    return centinela;
}  
    
    //Eliminar Administrador
    public boolean eliminarAdmin(String nombreusuarioaeliminar) throws SQLException {
        boolean centinela = false;
        try {
            this.conexion = new Conexion.Conexion().obtenerConexion();
            String llamada = "DELETE FROM ADMINISTRADOR WHERE nombreusuario = (?)";
            CallableStatement cstmt = this.conexion.prepareCall(llamada);
            cstmt.setString(1, nombreusuarioaeliminar);   
            if(cstmt.executeUpdate()>0){
                centinela = true;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar administrador"+e.getMessage());
        } finally{
              this.conexion.close();          
        }
        return centinela;
    }
    
    //Listar Administrador por nombre de usuario
    public Administrador listarAdminpornombre(String nombreusuarioporbuscar) throws SQLException {
        Administrador admin = new Administrador();
    try {
        //Abrir la conexion
        this.conexion = new Conexion.Conexion().obtenerConexion();
        //Crear la llamada al procedimiento Listar
        String llamada = "{call PKG_ADMIN.sp_LISTARADMINxnombre(?,?)}";
        //Crear callablestatement
        CallableStatement cstmt = this.conexion.prepareCall(llamada);
        //Pasamos el nombre de usuario como parámetro
        cstmt.setString(2, nombreusuarioporbuscar);
        //Pasamos el cursor del procedimiento
        cstmt.registerOutParameter(1, OracleTypes.CURSOR);
        cstmt.execute(); //Se ejecuta el procedimiento
        //Se usa el ResultSet para obtener la información del cursor (se castea)
        ResultSet rs = (ResultSet) cstmt.getObject(1);
        //Recorrer el rs y sacar los Admin
        while (rs.next()){              
                admin.setIdusuario(rs.getString("idusuario"));
                admin.setNombreusuario(rs.getString("nombreusuario"));
                admin.setContrasenausuario(rs.getString("contrasenausuario"));  
            }
        } catch (Exception e) {
            System.out.println("Error al listar Administradores"+e.getMessage());
        } finally{
            this.conexion.close();
        }
        return admin;       
    }   
}
