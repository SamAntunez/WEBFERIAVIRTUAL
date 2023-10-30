package ws;

import Clases.Administrador;
import Clases.Consultor;
import Clases.Productor;
import Clases.Cliente;
import Clases.Transportista;
import Clases.ProductorProducto;
import Clases.Transporte;
import Clases.Login;
import Clases.Pedido;
import Clases.DetallePedido;
import Clases.Calibre;
import Clases.Producto;
import DAO.AdministradorDAO;
import DAO.ConsultorDAO;
import DAO.ProductorDAO;
import DAO.ClienteNormalDAO;
import DAO.ClienteEmpDAO;
import DAO.TransportistaDAO;
import DAO.ProductorProductoDAO;
import DAO.TransporteDAO;
import DAO.LoginDAO;
import DAO.PedidoDAO;
import DAO.DetallePedidoDAO;
import DAO.CalibreDAO;
import DAO.ProductoDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.util.logging.Logger; 


@WebService(serviceName = "WSFERIAVIRTUAL")

public class WebServiceFV {
    
    AdministradorDAO daoadm = new AdministradorDAO();
    ConsultorDAO daoconsul = new ConsultorDAO();
    ProductorDAO daoproductor = new ProductorDAO();
    ClienteNormalDAO daoclinormal = new ClienteNormalDAO();
    ClienteEmpDAO daocliemp = new ClienteEmpDAO();
    TransportistaDAO daotran = new TransportistaDAO(); 
    ProductorProductoDAO daoproducpro = new ProductorProductoDAO();
    TransporteDAO daotransp = new TransporteDAO();
    LoginDAO daologin = new LoginDAO();
    PedidoDAO daopedido = new PedidoDAO();
    DetallePedidoDAO daodetpedido = new DetallePedidoDAO();
    CalibreDAO daocalibre = new CalibreDAO();
    ProductoDAO daoproducto = new ProductoDAO();
            
    
    //ADMINISTRADOR
    @WebMethod(operationName = "agregarAdministrador")
    public boolean agregarAdministrador(
        @WebParam(name = "idusuario") String idusuario,
        @WebParam(name = "nombreusuario") String nombreusuario,
        @WebParam(name = "contrasenausuario") String contrasenausuario) {
        try{
            Administrador admin = new Administrador(idusuario, nombreusuario, contrasenausuario);
            return daoadm.agregarAdministrador(admin);         
        } catch (SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return false;
    }
    
    @WebMethod(operationName = "listarAdmin")
    public List<Administrador> listarAdmin(){ 
        try{
            return daoadm.listarAdmin();
        } catch (SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return null;
    }
    
    @WebMethod(operationName = "modificarAdministrador")
    public boolean modificarAdministrador(
        @WebParam(name = "nombreusuarioabuscar") String nombreusuarioabuscar,
        @WebParam(name = "contrasenausuario") String contrasenausuario){
        try{
            
            Administrador admin = new Administrador(contrasenausuario, contrasenausuario, contrasenausuario);
            return daoadm.modificarAdministrador(nombreusuarioabuscar,admin);
        } catch(SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return false;
        }
      
    @WebMethod(operationName = "eliminarAdmin")
    public boolean eliminarAdmin(
        @WebParam(name = "nombreusuarioaeliminar") String nombreusuarioaeliminar){
        try{
            return daoadm.eliminarAdmin(nombreusuarioaeliminar);        
        } catch(SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return false;
        }
    
    @WebMethod(operationName = "listarAdminpornombre")
    public Administrador listarAdminpornombre(
        @WebParam(name = "nombreusuarioporbuscar") String nombreusuarioporbuscar){
        try{ 
            return daoadm.listarAdminpornombre(nombreusuarioporbuscar);
        } catch(SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return null;
        }
    
    //CONSULTOR
    @WebMethod(operationName = "agregarConsultor")
     public Boolean agregarConsultor(
        @WebParam(name = "idusuario") String idusuario,
        @WebParam(name = "nombreusuario") String nombreusuario,
        @WebParam(name = "contrasenausuario") String contrasenausuario) {
        try{
            Consultor consul = new Consultor(idusuario, nombreusuario, contrasenausuario);
            return daoconsul.agregarConsultor(consul);         
        } catch (SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return false;
        }   

    @WebMethod(operationName = "listarConsultor")
     public List<Consultor> listarConsultor(){        
        try{
            return daoconsul.listarConsultor();
        } catch (SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return null;
        }     
     
    @WebMethod(operationName = "modificarConsultor")
    public boolean modificarConsultor(
        @WebParam(name = "nombreusuarioabuscar") String nombreusuarioabuscar,
        @WebParam(name = "contrasenausuario") String contrasenausuario){
        try{        
            Consultor consul = new Consultor(contrasenausuario, contrasenausuario, contrasenausuario);
            return daoconsul.modificarConsultor(nombreusuarioabuscar,consul);
        } catch(SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return false;
        }
    
    @WebMethod(operationName = "eliminarConsultor")
    public boolean eliminarConsultor(
        @WebParam(name = "nombreusuarioaeliminar") String nombreusuarioaeliminar){
        try{
            return daoconsul.eliminarConsultor(nombreusuarioaeliminar);        
        } catch(SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return false;
        }
    
    @WebMethod(operationName = "listarconsultorporpornombre")
    public Consultor listarconsultorporpornombre(
        @WebParam(name = "nombreusuarioporbuscar") String nombreusuarioporbuscar){
        try{ 
            return daoconsul.listarconsultorpornombre(nombreusuarioporbuscar);
        } catch(SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return null;
        }
    
    //PRODUCTOR
    @WebMethod(operationName = "agregarProductor")
    public boolean agregarProductor(
        @WebParam(name = "rut") int rut,
        @WebParam(name = "dv") String dv,
        @WebParam(name = "nombre") String nombre,
        @WebParam(name = "apellidopat") String apellidopat,
        @WebParam(name = "apellidomat") String apellidomat,
        @WebParam(name = "fechanacimiento") String fechanacimiento,
        @WebParam(name = "direccion") String direccion,
        @WebParam(name = "correoelectronico") String correoelectronico,
        @WebParam(name = "contrasena") String contrasena,
        @WebParam(name = "comuna_idcomuna") String comuna_idcomuna){
        try{
            Productor productor = new Productor(rut, dv, nombre, apellidopat, apellidomat,"1", fechanacimiento,direccion, correoelectronico, contrasena, comuna_idcomuna);
            return daoproductor.agregarProductor(productor);         
        } catch (SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return false;
        }   
        
    @WebMethod(operationName = "listarProductor")
    public List<Productor> listarProductor(){ 
        try{
            return daoproductor.listarProductor();
        } catch (SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return null;
    }
    
    @WebMethod(operationName = "modificarProductor")
    public boolean modificarProductor(
        @WebParam(name = "rutabuscar") int rutabuscar,
        @WebParam(name = "nombre")String nombre,
        @WebParam(name = "apellidopat")String apellidopat,
        @WebParam(name = "apellidomat")String apellidomat,
        @WebParam(name = "fechanacimiento")String fechanacimiento,
        @WebParam(name = "direccion")String direccion,
        @WebParam(name = "correoelectronico")String correoelectronico,
        @WebParam(name = "contrasena")String contrasena,
        @WebParam(name = "comuna_idcomuna")String comuna_idcomuna)
        {
        try{        
            Productor productor = new Productor(rutabuscar, nombre, nombre, apellidopat, apellidomat, direccion, fechanacimiento, direccion, correoelectronico, contrasena, comuna_idcomuna);
            return daoproductor.modificarProductor(rutabuscar,productor);
        } catch(SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return false;
        }
    
    @WebMethod(operationName = "eliminarDefinitivoProductor")
    public boolean eliminarDefinitivoProductor(
        @WebParam(name = "rutaeliminar") int rutaeliminar){
        try{
            return daoproductor.eliminarDefinitivoProductor(rutaeliminar);        
        } catch(SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return false;
        }
    
    @WebMethod(operationName = "listarproductorporrut")
    public Productor listarproductorporrut(
        @WebParam(name = "rutabuscar") int rutabuscar){
        try{ 
            return daoproductor.listarproductorporrut(rutabuscar);
        } catch(SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return null;
        }
    
    @WebMethod(operationName = "desactivarCuentaProductor")
    public boolean desactivarCuentaProductor(
        @WebParam(name = "rut") int rut)
        {
        try{        
            Productor productor = new Productor();
            return daoproductor.desactivarCuentaProductor(rut,productor);
        } catch(SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return false;
        }
        
    //CLIENTE Y CLIENTE EMPRESA
    //CLIENTE NORMAL
    @WebMethod(operationName = "agregarClienteNormal")
    public boolean agregarClienteNormal(
        @WebParam(name = "rut") int rut,
        @WebParam(name = "dv") String dv,
        @WebParam(name = "nombre") String nombre,
        @WebParam(name = "apellidopat") String apellidopat,
        @WebParam(name = "apellidomat") String apellidomat,
        @WebParam(name = "direccion") String direccion,
        @WebParam(name = "fechanacimiento") String fechanacimiento,
        @WebParam(name = "correoelectronico") String correoelectronico,
        @WebParam(name = "contrasena") String contrasena,
        @WebParam(name = "comuna_idcomuna") String comuna_idcomuna){
        try{
            Cliente cli = new Cliente(direccion, rut, dv, nombre, apellidopat, apellidomat, fechanacimiento, direccion, fechanacimiento, correoelectronico, contrasena, contrasena, direccion, comuna_idcomuna, comuna_idcomuna);
            return daoclinormal.agregarClienteNormal(cli);         
        } catch (SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return false;
        } 
    
    //Este metodo lista clientes normales y clientes de empresa, ambos juntos
    @WebMethod(operationName = "listarClientes")
    public List<Cliente> listarCliente(){
        try{
            return daoclinormal.listarClientes();
        } catch (SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return null;
    }
    
    @WebMethod(operationName = "modificarClientenormal")
    public boolean modificarClientenormal(
        @WebParam(name = "rutabuscar") int rutabuscar,
        @WebParam(name = "nombre")String nombre,
        @WebParam(name = "apellidopat")String apellidopat,
        @WebParam(name = "apellidomat")String apellidomat,
        @WebParam(name = "direccion")String direccion,
        @WebParam(name = "fechanacimiento")String fechanacimiento,
        @WebParam(name = "correoelectronico")String correoelectronico,
        @WebParam(name = "contrasena")String contrasena,
        @WebParam(name = "comuna_idcomuna")String comuna_idcomuna)
        {
        try{        
            Cliente cli = new Cliente(direccion, rutabuscar, nombre, nombre, apellidopat, apellidomat, fechanacimiento, direccion, fechanacimiento, correoelectronico, contrasena, contrasena, direccion, comuna_idcomuna, comuna_idcomuna);
            return daoclinormal.modificarClientenormal(rutabuscar,cli);
        } catch(SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return false;
        }
    
    @WebMethod(operationName = "eliminarDefinitivoClienteNormal")
    public boolean eliminarDefinitivoClienteNormal(
        @WebParam(name = "rutaeliminar") int rutaeliminar){
        try{
            return daoclinormal.eliminarDefinitivoClienteNormal(rutaeliminar);        
        } catch(SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return false;
        }
    
    @WebMethod(operationName = "listarClienteNormalxRut")
    public Cliente listarClienteNormalxRut(
        @WebParam(name = "rutabuscar") int rutabuscar){
        try{ 
            return daoclinormal.listarClienteNormalxRut(rutabuscar);
        } catch(SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return null;
        }
    
    @WebMethod(operationName = "desactivarCuentaClienteNormal")
    public boolean desactivarCuentaClienteNormal(
        @WebParam(name = "rut") int rut)
        {
        try{        
            Cliente cli = new Cliente();
            return daoclinormal.desactivarCuentaClienteNormal(rut,cli);
        } catch(SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return false;
        }
        
    //CLIENTE EMPRESA
    @WebMethod(operationName = "agregarClienteEmp")
    public boolean agregarClienteEmp(
        @WebParam(name = "direccion") String direccion,
        @WebParam(name = "correoelectronico") String correoelectronico,
        @WebParam(name = "contrasena") String contrasena,
        @WebParam(name = "identificadorempresa") String identificadorempresa,
        @WebParam(name = "razonsocial")String razonsocial,
        @WebParam(name = "comuna_idcomuna") String comuna_idcomuna){
         try{
             Cliente cli = new Cliente(direccion, 0, direccion, contrasena, direccion, direccion, razonsocial, direccion, contrasena, correoelectronico, contrasena, identificadorempresa, razonsocial, comuna_idcomuna, comuna_idcomuna);
             return daocliemp.agregarClienteEmp(cli);
         } catch (SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return false;
        } 
    
    @WebMethod(operationName = "modificarClienteEmpresa")
    public boolean modificarClienteEmpresa(
        @WebParam(name = "identificadorabuscar") String identificadorabuscar,
        @WebParam(name = "direccion") String direccion,
        @WebParam(name = "correoelectronico") String correoelectronico,
        @WebParam(name = "contrasena") String contrasena,
        @WebParam(name = "razonsocial")String razonsocial,
        @WebParam(name = "comuna_idcomuna") String comuna_idcomuna)
        {
        try{        
            Cliente cli = new Cliente(direccion, 0, direccion, contrasena, direccion, direccion, razonsocial, direccion, contrasena, correoelectronico, contrasena, identificadorabuscar, razonsocial, comuna_idcomuna, comuna_idcomuna);
            return daocliemp.modificarClienteEmpresa(identificadorabuscar,cli);
        } catch(SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return false;
        }
    
    @WebMethod(operationName = "eliminarDefinitivoClienteEmpresa")
    public boolean eliminarDefinitivoClienteEmpresa(
        @WebParam(name = "rutaeliminar") String identificadoraeliminar){
        try{
            return daocliemp.eliminarDefinitivoClienteEmpresa(identificadoraeliminar);        
        } catch(SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return false;
        }

    @WebMethod(operationName = "listarClienteEmpresaxidentificador")
    public Cliente listarClienteEmpresaxidentificador(
        @WebParam(name = "identificadorabuscar") String identificadorabuscar){
        try{ 
            return daocliemp.listarClienteEmpresaxidentificador(identificadorabuscar);
        } catch(SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return null;
        }
    
    @WebMethod(operationName = "desactivarCuentaClienteEmpresa")
    public boolean desactivarCuentaClienteEmpresa(
        @WebParam(name = "identificadorabuscar") String identificadorabuscar)
        {
        try{        
            Cliente cli = new Cliente();
            return daocliemp.desactivarCuentaClienteEmpresa(identificadorabuscar,cli);
        } catch(SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return false;
        }
           
     //TRANSPORTISTA
     @WebMethod(operationName = "agregarTransportista")
     public boolean agregarTransportista(
        @WebParam(name = "rut") int rut,
        @WebParam(name = "dv") String dv,
        @WebParam(name = "nombre") String nombre,
        @WebParam(name = "apellidopat") String apellidopat,
        @WebParam(name = "apellidomat") String apellidomat,
        @WebParam(name = "fechanacimiento") String fechanacimiento,
        @WebParam(name = "direccion") String direccion,
        @WebParam(name = "correoelectronico") String correoelectronico,
        @WebParam(name = "contrasena") String contrasena){
         try{
            Transportista tran = new Transportista(rut, dv, nombre, apellidopat, apellidomat, direccion, fechanacimiento, direccion, correoelectronico, contrasena);
            return daotran.agregarTransportista(tran);         
        } catch (SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return false;
        }
     
    @WebMethod(operationName = "listarTransportista")
    public List<Transportista> listarTransportista(){ 
        try{
            return daotran.listarTransportista();
        } catch (SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return null;
        }
    
    @WebMethod(operationName = "modificarTransportista")
    public boolean modificarTransportista(
        @WebParam(name = "rutabuscar") int rutabuscar,
        @WebParam(name = "nombre")String nombre,
        @WebParam(name = "apellidopat")String apellidopat,
        @WebParam(name = "apellidomat")String apellidomat,
        @WebParam(name = "fechanacimiento")String fechanacimiento,
        @WebParam(name = "direccion")String direccion,
        @WebParam(name = "correoelectronico")String correoelectronico,
        @WebParam(name = "contrasena")String contrasena)
        {
        try{        
            Transportista tran = new Transportista(rutabuscar, nombre, nombre, apellidopat, apellidomat, direccion, fechanacimiento, direccion, correoelectronico, contrasena);
            return daotran.modificarTransportista(rutabuscar,tran);
        } catch(SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return false;
        }
    
    @WebMethod(operationName = "eliminarDefinitivoTransportista")
    public boolean eliminarDefinitivoTransportista(
        @WebParam(name = "rutaeliminar") int rutaeliminar){
        try{
            return daotran.eliminarDefinitivoTransportista(rutaeliminar);        
        } catch(SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return false;
        }
    
    @WebMethod(operationName = "listartransportistaporrut")
    public Transportista listartransportistaporrut(
        @WebParam(name = "rutabuscar") int rutabuscar){
        try{ 
            return daotran.listartransportistaporrut(rutabuscar);
        } catch(SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return null;
        }
    
    @WebMethod(operationName = "desactivarCuentaTransportista")
    public boolean desactivarCuentaTransportista(
        @WebParam(name = "rut") int rut)
        {
        try{        
            Transportista tran = new Transportista();
            return daotran.desactivarCuentaTransportista(rut,tran);
        } catch(SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return false;
        }
    
        //PRODUCTOR PRODUCTO
        @WebMethod(operationName = "agregarNuevoProducto")
         public boolean agregarNuevoProducto(
            @WebParam(name = "precio") int precio,
            @WebParam(name = "stock") int stock,
            @WebParam(name = "calibre_idcalibre") String calibre_idcalibre,
            @WebParam(name = "producto_idproducto") String producto_idproducto,
            @WebParam(name = "productor_rut") int productor_rut,
            @WebParam(name = "img") String img){
             try{
               ProductorProducto producpro = new ProductorProducto(precio, stock, calibre_idcalibre, producto_idproducto, productor_rut, img, producto_idproducto);
                return daoproducpro.agregarNuevoProducto(producpro);         
            } catch (SQLException ex){
                Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
            }
            return false;
            }
     
    @WebMethod(operationName = "listarproductosporrutproductor")
    public List<ProductorProducto> listarproductosporrutproductor(int rutabuscar){ 
        try{
            return daoproducpro.listarproductosporrutproductor(rutabuscar);
        } catch (SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return null;
        }
    @WebMethod(operationName = "listarProductos")
    public List<ProductorProducto> listarProductos(){ 
        try{
            return daoproducpro.listarProductos();
        } catch (SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return null;
        }
    
    
    @WebMethod(operationName = "eliminarProductoDelProductor")
    public boolean eliminarProductoDelProductor(
        @WebParam(name = "rutproductor") int rutproductor,
        @WebParam(name = "idcalibre") String idcalibre,
        @WebParam(name = "idproducto") String idproducto){
        try{
            return daoproducpro.eliminarProductoDelProductor(rutproductor, idcalibre, idproducto);
        } catch(SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return false;
        }
    
    @WebMethod(operationName = "modificarProductosporRutProductor")
    public boolean modificarProductosporRutProductor(
        @WebParam(name = "rutabuscar") int rutabuscar,
        @WebParam(name = "precio")int Precio,
        @WebParam(name = "stock")int stock,
        @WebParam(name = "calibre_idcalibre")String calibre_idcalibre,
        @WebParam(name = "img")String img)
        {
        try{        
            ProductorProducto productorProducto = new ProductorProducto(Precio, stock, calibre_idcalibre, calibre_idcalibre, Precio, img, calibre_idcalibre);
            return daoproducpro.modificarProductosporRutProductor(rutabuscar,productorProducto);
        } catch(SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return false;
        }
    
    //TRANSPORTE
    @WebMethod(operationName = "agregarTransporte")
     public boolean agregarTransporte(
        @WebParam(name = "patente") String patente,
        @WebParam(name = "capacidadcarga") int capacidadcarga,
        @WebParam(name = "frigorificotrans") String frigorificotrans,
        @WebParam(name = "permisocirculacion") String permisocirculacion,
        @WebParam(name = "transportista_rut") int transportista_rut,
        @WebParam(name = "modelo_idmodelo") String modelo_idmodelo){
         try{
           Transporte transp = new Transporte(patente, capacidadcarga, frigorificotrans, permisocirculacion, transportista_rut, modelo_idmodelo);
           return daotransp.agregarTransporte(transp);         
        } catch (SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return false;
        }
     
     @WebMethod(operationName = "listarTransportexRut")
    public Transporte listarTransportexRut(
        @WebParam(name = "rutabuscar") int rutabuscar){
        try{ 
            return daotransp.listarTransportexRut(rutabuscar);
        } catch(SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return null;
        }
    
    @WebMethod(operationName = "modificarTransporte")
    public boolean modificarTransporte(
        @WebParam(name = "rutabuscar") int rutabuscar,
        @WebParam(name = "capacidadcarga")int capacidadcarga,
        @WebParam(name = "frigorificotrans")String frigorificotrans,
        @WebParam(name = "permisocirculacion")String permisocirculacion){
        try{        
            Transporte transp = new Transporte(frigorificotrans, capacidadcarga, frigorificotrans, permisocirculacion, rutabuscar, frigorificotrans);
            return daotransp.modificarTransporte(rutabuscar, transp);
        } catch(SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return false;
        }
    
    @WebMethod(operationName = "eliminarTransportexPatente")
    public boolean eliminarTransportexPatente(
        @WebParam(name = "patenteaeliminar") String patenteaeliminar){
        try{
            return daotransp.eliminarTransportexPatente(patenteaeliminar);        
        } catch(SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return false;
        }
    //LOGIN 
    //Login de cliente, transportista y productor
    @WebMethod(operationName = "listarlogin1")
    public Login listarlogin1(
        @WebParam(name = "correoelectronicoingreso") String correoelectronicoingreso,
        @WebParam(name = "contrasena") String contrasena)          
    {
        try{ 
            return daologin.listarlogin1(correoelectronicoingreso,contrasena);
        } catch(SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return null;
        }  
    
    @WebMethod(operationName = "listarlogin2")
    public Login listarlogin2(
        @WebParam(name = "nombreusuario") String nombre,
        @WebParam(name = "contrasena") String contrasena)
    {
        try{ 
            return daologin.listarlogin2(nombre,contrasena);
        } catch(SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return null;
        }
    
    //PEDIDO
    @WebMethod(operationName = "crearNuevoPedido")
     public Boolean crearNuevoPedido(
        @WebParam(name = "cliente_id_cliente") String Cliente_id_cliente){
        try{
            Pedido pedido = new Pedido(Cliente_id_cliente, Cliente_id_cliente, 0, 0, 0, 0, 0, 0, Cliente_id_cliente, Cliente_id_cliente, Cliente_id_cliente, Cliente_id_cliente);
            return daopedido.crearNuevoPedido(pedido);         
        } catch (SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return false;
        } 
     
    //DETALLE DEL PEDIDO
    @WebMethod(operationName = "crearNuevoDetallePedidoo")
     public Boolean crearNuevoDetallePedido(
        @WebParam(name = "cantidad") int Cantidad,
        @WebParam(name = "idproducto") String Idproducto,
        @WebParam(name = "productor_rut") int Productor_rut,
        @WebParam(name = "pedido_idpedido") String Pedido_idpedido){
        try{
            DetallePedido detpedido = new DetallePedido(Cantidad, Idproducto, Productor_rut, Pedido_idpedido);
            return daodetpedido.crearNuevoDetallePedido(detpedido);         
        } catch (SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return false;
        } 
     
     //LISTAS VARIAS
     //LISTAR CALIBRE
        @WebMethod(operationName = "listarCalibre")
    public List<Calibre> listarCalibre(){ 
        try{
            return daocalibre.listarCalibre();
        } catch (SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return null;
    }
    
     @WebMethod(operationName = "listarProductosxIdyNombre")
    public List<Producto> listarProductosxIdyNombre(){ 
        try{
            return daoproducto.listarProductosxIdyNombre();
        } catch (SQLException ex){
            Logger.getLogger(WebServiceFV.class.getName()).log(Level.SEVERE, null,ex);
        }
        return null;
    }
    //Login Admin
    
}
          
            
           