/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Clases.Transporte;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import oracle.jdbc.OracleTypes;
import java.sql.ResultSet;

public class TransporteDAO {
    private Connection conexion;

    public TransporteDAO() {
    }
    
    //Agregar Transporte
    public boolean agregarTransporte(Transporte transp) throws SQLException{
        boolean centinela = false;
        try{
            //Abrir la conexion. La variable conexion va a ser igual a la nueva conexion. 
            //El primer conexion despues del new va al package y el segundo a la clase conexion
            this.conexion = new Conexion.Conexion().obtenerConexion();
            //Crear la llamada al procedimiento Agregar o Crear
            String llamada = "{ call PKG_TRANSPORTE.sp_crearTansporte(?,?,?,?,?,?)}";
            //Crear el callablestatement para poder ejecutar el procedimiento
            CallableStatement cstmt = this.conexion.prepareCall(llamada);
            //Pasar los datos del admin al procedimiento
            cstmt.setString(1, transp.getPatente());
            cstmt.setInt(2, transp.getCapacidadcarga());
            cstmt.setString(3, transp.getFrigorificotrans());
            cstmt.setString(4,transp.getPermisocirculacion());
            cstmt.setInt(5, transp.getTransportista_rut());
            cstmt.setString(6, transp.getModelo_idmodelo());
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
    
     //Listar transporte x rut del transportista
    public Transporte listarTransportexRut(int rutabuscar) throws SQLException {
        Transporte transp = new Transporte();
    try {
        //Abrir la conexion
        this.conexion = new Conexion.Conexion().obtenerConexion();
        //Crear la llamada al procedimiento Listar
        String llamada = "{call PKG_TRANSPORTE.sp_listartransportexrut(?,?)}";
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
                transp.setPatente(rs.getString("patente"));
                transp.setCapacidadcarga(rs.getInt("capacidadcarga"));
                transp.setFrigorificotrans(rs.getString("frigorificotrans"));
                transp.setPermisocirculacion(rs.getString("permisocirculacion"));
                transp.setModelo_idmodelo(rs.getString("descmodelo"));
                transp.setModelo_idmodelo(rs.getString("descmarca"));
        }    
        } catch (Exception e) {
            System.out.println("Error al listar Clientes"+e.getMessage());
        } finally{
            this.conexion.close();
        }
        return transp;
        }
    
    //Modificar Transporte
    public boolean modificarTransporte(int rutabuscar, Transporte transp) throws SQLException {
        boolean centinela = false;
        try {
            // Abrir la conexión
            this.conexion = new Conexion.Conexion().obtenerConexion();
            // Crear la llamada al procedimiento almacenado de modificación
            String llamada = "{ call PKG_CLIENTE.sp_actualizarclientenormal(?,?,?,?)}";
            // Crear el CallableStatement para ejecutar el procedimiento
            CallableStatement cstmt = this.conexion.prepareCall(llamada);
            // Pasar los datos del admin al procedimiento
            cstmt.setInt(1, rutabuscar);
            cstmt.setInt(2, transp.getCapacidadcarga()); 
            cstmt.setString(3, transp.getFrigorificotrans());
            cstmt.setString(4, transp.getPermisocirculacion());
            // Obtener el resultado del procedimiento almacenado
                if (cstmt.executeUpdate()>0){
                    centinela = true;
                }
        } catch (Exception e) {
            System.out.println("Error al modificar Transporte: " + e.getMessage());
        } finally {
            this.conexion.close();
        }
        return centinela;
        }
    
    //Eliminar Transporte x Patente 
    public boolean eliminarTransportexPatente(String patenteaeliminar) throws SQLException {
        boolean centinela = false;
        try {
            this.conexion = new Conexion.Conexion().obtenerConexion();
            String llamada = "{call PKG_TRANSPORTE.sp_eliminarTRansporte(?)}";
            CallableStatement cstmt = this.conexion.prepareCall(llamada);
            cstmt.setString(1, patenteaeliminar); 
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
    
}
