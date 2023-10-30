
package DAO;

import Clases.Consultor;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import oracle.jdbc.OracleTypes;
import java.sql.ResultSet;

public class ConsultorDAO {
    private Connection conexion;

    public ConsultorDAO() {
    }
    //Agregar Consultor
    public boolean agregarConsultor(Consultor consul) throws SQLException{
        boolean centinela = false;
        try{
            //Abrir la conexion. La variable conexion va a ser igual a la nueva conexion. 
            //El primer conexion despues del new va al package y el segundo a la clase conexion
            this.conexion = new Conexion.Conexion().obtenerConexion();
            //Crear la llamada al procedimiento Agregar o Crear
            String llamada = "{ call PKG_CONSULTOR.sp_crearConsultor(?,?)}"; 
            //Crear el callablestatement para poder ejecutar el procedimiento
            CallableStatement cstmt = this.conexion.prepareCall(llamada);
            //Pasar los datos del consultor al procedimiento
            cstmt.setString(1, consul.getNombreusuario());
            cstmt.setString(2, consul.getContrasenausuario());
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
    
     //Listar Consultor
    public List<Consultor> listarConsultor() throws SQLException{
        List<Consultor> lista = new ArrayList<>();
        try {
            //Abrir la conexion
            this.conexion = new Conexion.Conexion().obtenerConexion();
            //Crear la llamada al procedimiento Listar
            String llamada = "{call PKG_CONSULTOR.sp_LISTARAconsultor(?)}"; 
            //Crear callablestatement
            CallableStatement cstmt = this.conexion.prepareCall(llamada);
            //Pasamos el cursor del procedimiento
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute(); //Se ejecuta el procedimiento
            //Se usa el ResultSet para obtener la información del cursor (se castea)
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            //Recorrer el rs y sacar los Consultores
            while (rs.next()){
                Consultor consultor = new Consultor();
                consultor.setIdusuario(rs.getString("idusuario"));
                consultor.setNombreusuario(rs.getString("nombreusuario"));
                consultor.setContrasenausuario(rs.getString("contrasenausuario"));
                //Pasamos el objeto a la lista
                lista.add(consultor);     
            }
        } catch (Exception e) {
            System.out.println("Error al listar Consultores"+e.getMessage());
        } finally{
            this.conexion.close();
        }
        return lista;  
    }
    
    //Actualizar Consultor
    public boolean modificarConsultor(String nombreusuarioabuscar, Consultor consul) throws SQLException {
    boolean centinela = false;
    try {
        // Abrir la conexión
        this.conexion = new Conexion.Conexion().obtenerConexion();
        // Crear la llamada al procedimiento almacenado de modificación
        String llamada = "{ call PKG_CONSULTOR.sp_actualizarconsultor(?,?)}"; /////MODIFICAAAARRRRRRRRRRRRRRR!!!!!!!!
        // Crear el CallableStatement para ejecutar el procedimiento
        CallableStatement cstmt = this.conexion.prepareCall(llamada);
        // Pasar los datos del admin al procedimiento
        cstmt.setString(1, nombreusuarioabuscar);
        cstmt.setString(2, consul.getContrasenausuario()); 

        // Obtener el resultado del procedimiento almacenado
            if (cstmt.executeUpdate()>0){
                centinela = true;
            }
    } catch (Exception e) {
        System.out.println("Error al modificar consultor: " + e.getMessage());
    } finally {
        this.conexion.close();
    }
    return centinela;
   }
    
    //Eliminar Consultor
    public boolean eliminarConsultor(String nombreusuarioaeliminar) throws SQLException {
        boolean centinela = false;
        try {
            this.conexion = new Conexion.Conexion().obtenerConexion();
            String llamada = "DELETE FROM CONSULTOR WHERE nombreusuario = (?)";
            CallableStatement cstmt = this.conexion.prepareCall(llamada);
            cstmt.setString(1, nombreusuarioaeliminar);    //!!!!!SE CASTEÓ ESTE DATO PARA QUE SE LEYERA COMO VIENE DESDE LA BD
            //Ejecutamos y se revisa si funciona el eliminar
            if(cstmt.executeUpdate()>0){
                centinela = true;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar consultor"+e.getMessage());
        } finally{
              this.conexion.close();          
        }
        return centinela;
        }
    
    //Listar Consultor por nombre de usuario
    public Consultor listarconsultorpornombre(String nombreusuarioporbuscar) throws SQLException {
        Consultor consul = new Consultor();
    try {
        //Abrir la conexion
        this.conexion = new Conexion.Conexion().obtenerConexion();
        //Crear la llamada al procedimiento Listar
        String llamada = "{call PKG_CONSULTOR.sp_LISTARConsultorxnombre(?,?)}";
        //Crear callablestatement
        CallableStatement cstmt = this.conexion.prepareCall(llamada);
        //Pasamos el nombre de usuario como parámetro
        cstmt.setString(2, nombreusuarioporbuscar);
        //Pasamos el cursor del procedimiento
        cstmt.registerOutParameter(1, OracleTypes.CURSOR);
        cstmt.execute(); //Se ejecuta el procedimiento
        //Se usa el ResultSet para obtener la información del cursor (se castea)
        ResultSet rs = (ResultSet) cstmt.getObject(1);
        //Recorrer el rs y sacar los Consultores
        while (rs.next()){              
                consul.setIdusuario(rs.getString("idusuario"));
                consul.setNombreusuario(rs.getString("nombreusuario"));
                consul.setContrasenausuario(rs.getString("contrasenausuario"));  
            }
        } catch (Exception e) {
            System.out.println("Error al listar Consultores"+e.getMessage());
        } finally{
            this.conexion.close();
        }
        return consul;   
    }
    
    
    
}
