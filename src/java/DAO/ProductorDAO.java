
package DAO;

import Clases.DetallePedido;
import Clases.Productor;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import oracle.jdbc.OracleTypes;
import java.sql.ResultSet;

public class ProductorDAO {
    private Connection conexion;

    public ProductorDAO() {
    }
     //Agregar Productor
    public boolean agregarProductor(Productor productor) throws SQLException{
        boolean centinela = false;
        try{
            //Abrir la conexion. La variable conexion va a ser igual a la nueva conexion. 
            //El primer conexion despues del new va al package y el segundo a la clase conexion
            this.conexion = new Conexion.Conexion().obtenerConexion();
            //Crear la llamada al procedimiento Agregar o Crear
            String llamada = "{ call PKG_PRODUCTOR.sp_crearproductor(?,?,?,?,?,?,?,?,?,?)}";
            //Crear el callablestatement para poder ejecutar el procedimiento
            CallableStatement cstmt = this.conexion.prepareCall(llamada);
            //Pasar los datos del productor al procedimiento
            cstmt.setInt(1,productor.getRut());
            cstmt.setString(2,productor.getDv());
            cstmt.setString(3,productor.getNombre());
            cstmt.setString(4,productor.getApellidopat());
            cstmt.setString(5,productor.getApellidomat());
            cstmt.setString(6,productor.getFechanacimiento());
            cstmt.setString(7,productor.getDireccion());
            cstmt.setString(8,productor.getCorreoelectronico());
            cstmt.setString(9,productor.getContrasena());
            cstmt.setString(10,productor.getComuna_idcomuna());          
//            //ciclo
//            List<DetallePedido> lista = new ArrayList<>();
//            DetallePedido d = new DetallePedido();
//            d.setCantidad(cantidad);
//            d.setIdproducto(id_producto);
//            d.setProductor_rut(id_productor);
//            lista.add(d);
//            //aqui terminaria el ci
//            cstmt.setObject(11, lista);
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
    
    //Listar Productor
    public List<Productor> listarProductor() throws SQLException{
        List<Productor> lista = new ArrayList<>();
        try {
            //Abrir la conexion
            this.conexion = new Conexion.Conexion().obtenerConexion();
            //Crear la llamada al procedimiento Listar
            String llamada = "{call PKG_PRODUCTOR.sp_LISTARaProductor(?)}";
            //Crear callablestatement
            CallableStatement cstmt = this.conexion.prepareCall(llamada);
            //Pasamos el cursor del procedimiento
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute(); //Se ejecuta el procedimiento
            //Se usa el ResultSet para obtener la información del cursor (se castea)
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            //Recorrer el rs y sacar los Admin
            while (rs.next()){
                Productor productor = new Productor();
                productor.setRut(rs.getInt("rut"));
                productor.setDv(rs.getString("dv"));
                productor.setNombre(rs.getString("nombre"));
                productor.setApellidopat(rs.getString("apellidopat"));
                productor.setApellidomat(rs.getString("apellidomat"));
                productor.setDireccion(rs.getString("fechanacimiento"));
                productor.setFechanacimiento(rs.getString("direccion"));
                productor.setCorreoelectronico(rs.getString("correoelectronico"));
                productor.setContrasena(rs.getString("contrasena"));
                productor.setComuna_idcomuna(rs.getString("nombrecomuna"));
                //Pasamos el objeto a la lista
                lista.add(productor);     
            }
        } catch (Exception e) {
            System.out.println("Error al listar Clientes"+e.getMessage());
        } finally{
            this.conexion.close();
        }
        return lista;
        }   
    
    //Actualizar Productor  
    public boolean modificarProductor(int rutabuscar, Productor productor) throws SQLException {
        boolean centinela = false;
        try {
            // Abrir la conexión
            this.conexion = new Conexion.Conexion().obtenerConexion();
            // Crear la llamada al procedimiento almacenado de modificación
            String llamada = "{ call PKG_PRODUCTOR.sp_actualizarProductor(?,?,?,?,?,?,?,?,?)}";
            // Crear el CallableStatement para ejecutar el procedimiento
            CallableStatement cstmt = this.conexion.prepareCall(llamada);
            // Pasar los datos del admin al procedimiento
            cstmt.setInt(1, rutabuscar);
            cstmt.setString(2, productor.getNombre()); 
            cstmt.setString(3, productor.getApellidopat());
            cstmt.setString(4, productor.getApellidomat());
            cstmt.setString(5, productor.getFechanacimiento());
            cstmt.setString(6, productor.getDireccion());
            cstmt.setString(7, productor.getCorreoelectronico());
            cstmt.setString(8, productor.getContrasena());
            cstmt.setString(9, productor.getComuna_idcomuna());
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
    
    //Eliminar Productor 
    public boolean eliminarDefinitivoProductor(int rutaeliminar) throws SQLException {
        boolean centinela = false;
        try {
            this.conexion = new Conexion.Conexion().obtenerConexion();
            String llamada = "{call PKG_PRODUCTOR.sp_eliminarProductorxAdmin(?)}";
            CallableStatement cstmt = this.conexion.prepareCall(llamada);
            cstmt.setInt(1, rutaeliminar); 
            //Ejecutamos y se revisa si funciona el eliminar
            if(cstmt.executeUpdate()>0){
                centinela = true;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar productor"+e.getMessage());
        } finally{
              this.conexion.close();          
        }
        return centinela;
        }   
    
    //Listar Productor por rut
    public Productor listarproductorporrut(int rutabuscar) throws SQLException {
        Productor productor = new Productor();
    try {
        //Abrir la conexion
        this.conexion = new Conexion.Conexion().obtenerConexion();
        //Crear la llamada al procedimiento Listar
        String llamada = "{call PKG_PRODUCTOR.sp_ListarxrutProductor(?,?)}";
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
                productor.setRut(rs.getInt("rut"));
                productor.setNombre(rs.getString("nombre"));
                productor.setDv(rs.getString("dv"));
                productor.setApellidopat(rs.getString("apellidopat"));
                productor.setApellidomat(rs.getString("apellidomat"));
                productor.setFechanacimiento(rs.getString("fechanacimiento"));
                productor.setDireccion(rs.getString("direccion"));
                productor.setCorreoelectronico(rs.getString("correoelectronico"));
                productor.setContrasena(rs.getString("contrasena"));
                productor.setComuna_idcomuna(rs.getString("nombrecomuna"));
            }
        } catch (Exception e) {
            System.out.println("Error al listar Productores"+e.getMessage());
        } finally{
            this.conexion.close();
        }
        return productor;
    }
    
    //Eliminar(DESACTIVAR) Productor (Cambio de estado productor)   
    public boolean desactivarCuentaProductor(int rut, Productor productor) throws SQLException {
        boolean centinela = false;
        try {
            // Abrir la conexión
            this.conexion = new Conexion.Conexion().obtenerConexion();
            // Crear la llamada al procedimiento almacenado de modificación
            String llamada = "{ call PKG_PRODUCTOR.sp_eliminarProductor(?)}";
            // Crear el CallableStatement para ejecutar el procedimiento
            CallableStatement cstmt = this.conexion.prepareCall(llamada);
            // Pasar los datos del admin al procedimiento
            cstmt.setInt(1, rut);
            // Obtener el resultado del procedimiento almacenado
                if (cstmt.executeUpdate()>0){
                    centinela = true;
                }
        } catch (Exception e) {
            System.out.println("Error al desactivar cuenta productor: " + e.getMessage());
        } finally {
            this.conexion.close();
        }
        return centinela;
        }
    


    }