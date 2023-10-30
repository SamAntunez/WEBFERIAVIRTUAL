
package Test;

import Clases.Administrador;
import Clases.Login;
import DAO.AdministradorDAO;
import DAO.LoginDAO;
import java.util.List;

public class TestAdmin {


    public static void main(String[] args) {
        try {
            //-----Para probar el Crear Admin------
            
//            Administrador a = new Administrador("","admin6","1234");
//            
//            if(new AdministradorDAO().agregarAdministrador(a)){
//                System.out.println("Administrador creado exitosamente");
//            } else {
//                System.out.println("No se pudo agregar el Administrador");               
//            }
//                //-------Cierre prueba crear admin-----
//----------------------------------------------------------------------------------------------------------------------
//                //------Para probar el listar Admin------
//                
//               List<Administrador> listado = new AdministradorDAO().listarAdmin();
//               
//               for(Administrador administrador : listado){    //Se recorre el listado
//                   System.out.println(administrador.toString());
//               }
               //------Cierre prueba listar admin-------
//-------------------------------------------------------------------------------------------------------------------------
               //------------Para probar el modificar admin---------
               
//               String nombreadmin = "admin1"; //este es el nombre existente en la bd
//               //Acá abajito tenemos los nuevos parámetros a cambiar, si es que encuentra el nombre que le dimos arriba
//               Administrador admin = new Administrador("", "admin1nuevo","owowow");
//
//                // Llamar al método modificarAdministrador y verificar el resultado
//                if (new AdministradorDAO().modificarAdministrador(nombreadmin, admin)) {
//                    System.out.println("Administrador modificado con éxito");
//                } else {
//                    System.out.println("No se pudo modificar el Administrador");
//                }
                //------Cierre prueba modificar admin-------             
//------------------------------------------------------------------------------------------------------ 
               //-----Para probar el eliminar Admin------
//               if (new AdministradorDAO().eliminarAdmin("juancarlosbodoque")){
//                   System.out.println("Administrador eliminado con exito");
//               } else {
//                   System.out.println("No se pudo eliminar el Administrador");
//               }
//               List<Administrador> listado = new AdministradorDAO().listarAdmin();
//               
//               for(Administrador administrador : listado){    //Se recorre el listado
//                   System.out.println(administrador.toString());
//               }
               //-------Cierre prueba eliminar--------
//-----------------------------------------------------------------------------------------------------
                //---------Para probar el listar admin por nombre
               LoginDAO dao = new LoginDAO();
               Login l = dao.listarlogin2("admin", "admin123");
               System.out.println(l.getNombre());
               System.out.println(l.getTipousuario());
               
        } catch (Exception e) {
            System.out.println("ERROR"+e.getMessage());
        }
    }    
} 

