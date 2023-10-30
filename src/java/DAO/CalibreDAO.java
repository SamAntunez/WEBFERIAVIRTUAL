package DAO;

import Clases.Calibre;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import oracle.jdbc.OracleTypes;
import java.sql.ResultSet;

public class CalibreDAO {
    private Connection conexion;

    public CalibreDAO() {
    }

    public List<Calibre> listarCalibre() throws SQLException{
        List<Calibre> lista = new ArrayList<>();
        try {
            //Abrir la conexion
            this.conexion = new Conexion.Conexion().obtenerConexion();
            //Crear la llamada al procedimiento Listar
            String llamada = "{call sp_LISTACALIBRE(?)}";
            //Crear callablestatement
            CallableStatement cstmt = this.conexion.prepareCall(llamada);
            //Pasamos el cursor del procedimiento
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute(); //Se ejecuta el procedimiento
            //Se usa el ResultSet para obtener la información del cursor (se castea)
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            //Recorrer el rs y sacar los Admin
            while (rs.next()){
                Calibre calibre = new Calibre();
                calibre.setIdcalibre(rs.getString("idcalibre"));
                calibre.setDesccalibre(rs.getString("desccalibre"));
                //Pasamos el objeto a la lista
                lista.add(calibre); 
            }
             } catch (Exception e) {
            System.out.println("Error al listar "+e.getMessage());
        } finally{
            this.conexion.close();
        }
        return lista;
        } 



}