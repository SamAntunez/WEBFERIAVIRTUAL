
package DAO;

import Clases.ProductorProducto;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import oracle.jdbc.OracleTypes;
import java.sql.ResultSet;

public class ProductorProductoDAO {
    private Connection conexion;

    public ProductorProductoDAO() {
    }
    
    //Agregar Nuevo Producto
    public boolean agregarNuevoProducto(ProductorProducto producpro) throws SQLException{
        boolean centinela = false;
        try{
            //Abrir la conexion. La variable conexion va a ser igual a la nueva conexion. 
            //El primer conexion despues del new va al package y el segundo a la clase conexion
            this.conexion = new Conexion.Conexion().obtenerConexion();
            //Crear la llamada al procedimiento Agregar o Crear
            String llamada = "{ call PKG_PRODUCTORPRODUCTO.sp_crearproductordelproductor(?,?,?,?,?,?)}";
            //Crear el callablestatement para poder ejecutar el procedimiento
            CallableStatement cstmt = this.conexion.prepareCall(llamada);
            //Pasar los datos del productor al procedimiento
            cstmt.setInt(1,producpro.getPrecio());
            cstmt.setInt(2,producpro.getStock());
            cstmt.setString(3,producpro.getCalibre_idcalibre());
            cstmt.setString(4,producpro.getProducto_idproducto());
            cstmt.setInt(5,producpro.getProductor_rut());
            cstmt.setString(6,producpro.getImg());
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
    
    //Listar todos los productos 
    public List<ProductorProducto> listarProductos() throws SQLException{
        List<ProductorProducto> lista = new ArrayList<>();
        try {
            //Abrir la conexion
            this.conexion = new Conexion.Conexion().obtenerConexion();
            //Crear la llamada al procedimiento Listar
            String llamada = "{call PKG_PRODUCTORPRODUCTO.sp_listartodosproductoresproducto(?)}";
            //Crear callablestatement
            CallableStatement cstmt = this.conexion.prepareCall(llamada);
            //Pasamos el cursor del procedimiento
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute(); //Se ejecuta el procedimiento
            //Se usa el ResultSet para obtener la información del cursor (se castea)
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            //Recorrer el rs y sacar los Admin
            while (rs.next()){
                ProductorProducto productorprod = new ProductorProducto();
                productorprod.setPrecio(rs.getInt("precio"));
                productorprod.setStock(rs.getInt("stock"));
                productorprod.setCalibre_idcalibre(rs.getString("desccalibre"));
                productorprod.setProducto_idproducto(rs.getString("nombreproducto"));
                productorprod.setImg(rs.getString("img"));
                productorprod.setProductor_rut(rs.getInt("productor_rut"));
                productorprod.setNombre_productor(rs.getString("nombre"));
                //Pasamos el objeto a la lista
                lista.add(productorprod);     
            }
        } catch (Exception e) {
            System.out.println("Error al listar"+e.getMessage());
        } finally{
            this.conexion.close();
        }
        return lista;     
    }
    
    //Listar Productos del productor por rut
    public List<ProductorProducto> listarproductosporrutproductor(int rutabuscar) throws SQLException{
        List<ProductorProducto> lista = new ArrayList<>();
        try {
            //Abrir la conexion
            this.conexion = new Conexion.Conexion().obtenerConexion();
            //Crear la llamada al procedimiento Listar
            String llamada = "{call PKG_PRODUCTORPRODUCTO.sp_listarproductosdelproductor(?,?)}";
            //Crear callablestatement
            CallableStatement cstmt = this.conexion.prepareCall(llamada);
            cstmt.setInt(2, rutabuscar);
            //Pasamos el cursor del procedimiento
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute(); //Se ejecuta el procedimiento
            //Se usa el ResultSet para obtener la información del cursor (se castea)
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            //Recorrer el rs y sacar los Admin
            while (rs.next()){
                ProductorProducto productorprod = new ProductorProducto();
                productorprod.setPrecio(rs.getInt("precio"));
                productorprod.setStock(rs.getInt("stock"));
                productorprod.setCalibre_idcalibre(rs.getString("desccalibre"));
                productorprod.setProducto_idproducto(rs.getString("nombreproducto"));
                productorprod.setImg(rs.getString("img"));
                //Pasamos el objeto a la lista
                lista.add(productorprod);
            }
        } catch (Exception e) {
            System.out.println("Error al listar"+e.getMessage());
        } finally{
            this.conexion.close();
        }
        return lista;
    }
    
    //Actualizar producto   
   public boolean modificarProductosporRutProductor(int rutabuscar, ProductorProducto producpro) throws SQLException {
        boolean centinela = false;
        try {
            // Abrir la conexión
            this.conexion = new Conexion.Conexion().obtenerConexion();
            // Crear la llamada al procedimiento almacenado de modificación
            String llamada = "{ call PKG_PRODUCTORPRODUCTO.sp_actualizarproductosdelproductor(?,?,?,?,?)}";
            // Crear el CallableStatement para ejecutar el procedimiento
            CallableStatement cstmt = this.conexion.prepareCall(llamada);
            // Pasar los datos del admin al procedimiento
            cstmt.setInt(1, rutabuscar);
            cstmt.setInt(2, producpro.getPrecio()); 
            cstmt.setInt(3, producpro.getStock());
            cstmt.setString(4, producpro.getCalibre_idcalibre());
            cstmt.setString(5, producpro.getImg());
            // Obtener el resultado del procedimiento almacenado
                if (cstmt.executeUpdate()>0){
                    centinela = true;
                }
        } catch (Exception e) {
            System.out.println("Error al modificar Producto: " + e.getMessage());
        } finally {
            this.conexion.close();
        }
        return centinela;
        }
   
    //Eliminar productos
   public boolean eliminarProductoDelProductor(int rutproductor, String idcalibre, String idproducto) throws SQLException {
        boolean centinela = false;
        try {
            this.conexion = new Conexion.Conexion().obtenerConexion();
            String llamada = "{call PKG_PRODUCTORPRODUCTO.sp_eliminarproducto(?,?,?)}";
            CallableStatement cstmt = this.conexion.prepareCall(llamada);
            cstmt.setInt(1, rutproductor);
            cstmt.setString(2, idcalibre);
            cstmt.setString(3, idproducto);
            //Ejecutamos y se revisa si funciona el eliminar
            if(cstmt.executeUpdate()>0){
                centinela = true;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar Producto"+e.getMessage());
        } finally{
              this.conexion.close();          
        }
        return centinela;
    }
}
