
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
   //Se crea la variable que cree la conexion
    private static Connection con;
    //
    private String usuario = "feria_virtual";
    private String pass = "feria_virtual";
    // Modificable el SID en caso de tener otra configuracion en BD.
    private String url = "jdbc:oracle:thin:@localhost:1521/orclpdb";


    public Conexion() {
        try{
            //cargar libreria ojdbc para conectarse a oracle
            Class.forName("oracle.jdbc.OracleDriver").newInstance();
            this.con = DriverManager.getConnection(url,usuario,pass);
        }catch (Exception e){
            System.out.println("Error de conexion"+e.getMessage());
            
        }
        
    }
    public Connection obtenerConexion(){
        return this.con;
    }
    
    
}
