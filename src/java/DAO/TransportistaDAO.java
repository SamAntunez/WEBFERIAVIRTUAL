
package DAO;

import Clases.Transportista;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import oracle.jdbc.OracleTypes;
import java.sql.ResultSet;

public class TransportistaDAO {
    private Connection conexion;

    public TransportistaDAO() {
    }
    //Agregar Transportista
    public boolean agregarTransportista(Transportista tran) throws SQLException{
        boolean centinela = false;
        try{
            //Abrir la conexion. La variable conexion va a ser igual a la nueva conexion. 
            //El primer conexion despues del new va al package y el segundo a la clase conexion
            this.conexion = new Conexion.Conexion().obtenerConexion();
            //Crear la llamada al procedimiento Agregar o Crear
            String llamada = "{ call PKG_TRANSPORTISTA.sp_crearTransportista(?,?,?,?,?,?,?,?,?)}";
            //Crear el callablestatement para poder ejecutar el procedimiento
            CallableStatement cstmt = this.conexion.prepareCall(llamada);
            //Pasar los datos del productor al procedimiento
            cstmt.setInt(1,tran.getRut());
            cstmt.setString(2,tran.getDv());
            cstmt.setString(3,tran.getNombre());
            cstmt.setString(4,tran.getApellidopat());
            cstmt.setString(5,tran.getApellidomat());
            cstmt.setString(6,tran.getFechanacimiento());
            cstmt.setString(7,tran.getDireccion());
            cstmt.setString(8,tran.getCorreoelectronico());
            cstmt.setString(9,tran.getContrasena());
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
    
    //Listar Transportista
    public List<Transportista> listarTransportista() throws SQLException{
        List<Transportista> lista = new ArrayList<>();
        try {
            //Abrir la conexion
            this.conexion = new Conexion.Conexion().obtenerConexion();
            //Crear la llamada al procedimiento Listar
            String llamada = "{call PKG_TRANSPORTISTA.sp_LISTARaTRansportista(?)}";
            //Crear callablestatement
            CallableStatement cstmt = this.conexion.prepareCall(llamada);
            //Pasamos el cursor del procedimiento
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute(); //Se ejecuta el procedimiento
            //Se usa el ResultSet para obtener la información del cursor (se castea)
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            //Recorrer el rs y sacar los Admin
            while (rs.next()){
                Transportista tran = new Transportista();
                tran.setRut(rs.getInt("rut"));
                tran.setDv(rs.getString("dv"));
                tran.setNombre(rs.getString("nombre"));
                tran.setApellidopat(rs.getString("apellidopat"));
                tran.setApellidomat(rs.getString("apellidomat"));
                tran.setDireccion(rs.getString("fechanacimiento"));
                tran.setFechanacimiento(rs.getString("direccion"));
                tran.setCorreoelectronico(rs.getString("correoelectronico"));
                tran.setContrasena(rs.getString("contrasena"));

                //Pasamos el objeto a la lista
                lista.add(tran);     
            }
        } catch (Exception e) {
            System.out.println("Error al listar Transportista"+e.getMessage());
        } finally{
            this.conexion.close();
        }
        return lista;
        } 
    
    //Actualizar Transportista   
   public boolean modificarTransportista(int rutabuscar, Transportista tran) throws SQLException {
        boolean centinela = false;
        try {
            // Abrir la conexión
            this.conexion = new Conexion.Conexion().obtenerConexion();
            // Crear la llamada al procedimiento almacenado de modificación
            String llamada = "{ call PKG_TRANSPORTISTA.sp_actualizarTransportista(?,?,?,?,?,?,?,?)}";
            // Crear el CallableStatement para ejecutar el procedimiento
            CallableStatement cstmt = this.conexion.prepareCall(llamada);
            // Pasar los datos del admin al procedimiento
            cstmt.setInt(1, rutabuscar);
            cstmt.setString(2, tran.getNombre()); 
            cstmt.setString(3, tran.getApellidopat());
            cstmt.setString(4, tran.getApellidomat());
            cstmt.setString(5, tran.getFechanacimiento());
            cstmt.setString(6, tran.getDireccion());
            cstmt.setString(7, tran.getCorreoelectronico());
            cstmt.setString(8, tran.getContrasena());
            // Obtener el resultado del procedimiento almacenado
                if (cstmt.executeUpdate()>0){
                    centinela = true;
                }
        } catch (Exception e) {
            System.out.println("Error al modificar Transportista: " + e.getMessage());
        } finally {
            this.conexion.close();
        }
        return centinela;
        }   
   
    //Eliminar Transportista 
    public boolean eliminarDefinitivoTransportista(int rutaeliminar) throws SQLException {
        boolean centinela = false;
        try {
            this.conexion = new Conexion.Conexion().obtenerConexion();
            String llamada = "{call PKG_TRANSPORTISTA.sp_eliminarTRansportistaxAdmin(?)}";
            CallableStatement cstmt = this.conexion.prepareCall(llamada);
            cstmt.setInt(1, rutaeliminar); 
            //Ejecutamos y se revisa si funciona el eliminar
            if(cstmt.executeUpdate()>0){
                centinela = true;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar Transportista"+e.getMessage());
        } finally{
              this.conexion.close();          
        }
        return centinela;
    }
    
    //Listar Transportista por rut
    public Transportista listartransportistaporrut(int rutabuscar) throws SQLException {
        Transportista tran = new Transportista();
    try {
        //Abrir la conexion
        this.conexion = new Conexion.Conexion().obtenerConexion();
        //Crear la llamada al procedimiento Listar
        String llamada = "{ca   ll PKG_TRANSPORTISTA.sp_LISTARxrutTRansportista(?,?)}";
        //Crear callablestatement
        CallableStatement cstmt = this.conexion.prepareCall(llamada);
        //Pasamos el nombre de usuario como parámetro
        cstmt.setInt(2, rutabuscar);
        //Pasamos el cursor del procedimiento
        cstmt.registerOutParameter(1, OracleTypes.CURSOR);
        cstmt.execute(); //Se ejecuta el procedimiento
        //Se usa el ResultSet para obtener la información del cursor (se castea)
        ResultSet rs = (ResultSet) cstmt.getObject(1);
        //Recorrer el rs y sacar los Consultores
        while (rs.next()){
                tran.setRut(rs.getInt("rut"));
                tran.setNombre(rs.getString("nombre"));
                tran.setDv(rs.getString("dv"));
                tran.setApellidopat(rs.getString("apellidopat"));
                tran.setApellidomat(rs.getString("apellidomat"));
                tran.setFechanacimiento(rs.getString("fechanacimiento"));
                tran.setDireccion(rs.getString("direccion"));
                tran.setCorreoelectronico(rs.getString("correoelectronico"));
                tran.setContrasena(rs.getString("contrasena"));
            }
        } catch (Exception e) {
            System.out.println("Error al listar Productores"+e.getMessage());
        } finally{
            this.conexion.close();
        }
        return tran;
    }
    
    //Eliminar(DESACTIVAR) Transportista (Cambio de estado Transportista)
    public boolean desactivarCuentaTransportista(int rut, Transportista tran) throws SQLException {
        boolean centinela = false;
        try {
            // Abrir la conexión
            this.conexion = new Conexion.Conexion().obtenerConexion();
            // Crear la llamada al procedimiento almacenado de modificación
            String llamada = "{ call PKG_TRANSPORTISTA.sp_eliminaTRansportista(?)}";
            // Crear el CallableStatement para ejecutar el procedimiento
            CallableStatement cstmt = this.conexion.prepareCall(llamada);
            // Pasar los datos del admin al procedimiento
            cstmt.setInt(1, rut);
            // Obtener el resultado del procedimiento almacenado
                if (cstmt.executeUpdate()>0){
                    centinela = true;
                }
        } catch (Exception e) {
            System.out.println("Error al modificar productor: " + e.getMessage());
        } finally {
            this.conexion.close();
        }
        return centinela;
        }
    
    
}
