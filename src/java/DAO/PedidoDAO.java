
package DAO;

import Clases.Pedido;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import oracle.jdbc.OracleTypes;
import java.sql.ResultSet;

public class PedidoDAO {
    private Connection conexion;  

    public PedidoDAO() {
    }
    
     //Crear nuevo pedido
    public boolean crearNuevoPedido(Pedido pedido) throws SQLException{
        boolean centinela = false;
        try{
            //Abrir la conexion. La variable conexion va a ser igual a la nueva conexion. 
            //El primer conexion despues del new va al package y el segundo a la clase conexion
            this.conexion = new Conexion.Conexion().obtenerConexion();
            //Crear la llamada al procedimiento Agregar o Crear
            String llamada = "{ call sp_crearpedido(?)}";
            //Crear el callablestatement para poder ejecutar el procedimiento
            CallableStatement cstmt = this.conexion.prepareCall(llamada);
            //Pasar los datos del productor al procedimiento
            cstmt.setString(1,pedido.getCliente_id_cliente());         
            if (cstmt.executeUpdate()>0){
                centinela = true;
            }         
        } catch (Exception e){
            System.out.println("Error al crear pedido"+e.getMessage());
        } finally{
            this.conexion.close();            
        }    
        return centinela;
        }
}
