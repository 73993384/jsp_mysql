package models;

//Importar la LIBRERIA para SQL
import java.sql.*;

//Importar la LIBRERIA para List<>
import java.util.*;

public class ProductoM {
    //ESTRUCTURA (PROPIEDADES, ENCAPSULADOS Y CONSTRUCTORES) = CAPA ENTIDAD
    private int id;
    private String descripcion;
    private String categoria;
    private double precio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ProductoM() {
    }
    
    public ProductoM(int id, String descripcion, String categoria, double precio) {
        this.id = id;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
    }
    
    //COMPORTAMIENTO (METODOS DE ACCESO A DATOS) = CAPA DATOS
    public int insertar(ProductoM productoM){
        //Declarar la variable newId
        int newId=0;
        try{
            //Instanciar una conexion
            ConexionM conexionM = new ConexionM();
            //Ejecutar el metodo que devuelve la conexion abierta
            Connection cnx = conexionM.conectarToMySql();
            //Preparar la instruccion SQL
            PreparedStatement ps = cnx.prepareStatement("insert into producto "
                    + "(descripcion, categoria, precio) "
                    + "values (?,?,?)");
            //Pasar los valores a los parametros
            ps.setString(1, productoM.getDescripcion());
            ps.setString(2, productoM.getCategoria());
            ps.setDouble(3, productoM.getPrecio());
            //Ejecutar el SQL
            ps.executeUpdate();
            
            //PARTE II: Recuperar el ID nuevo
            //Preparar la nueva instruccion SQL
            ps = cnx.prepareStatement("select max(id) as newId from producto "
                    + "where descripcion=?");
            //Pasar el parametro
            ps.setString(1, productoM.getDescripcion());
            //Eejecutar la instruccion SQL
            ResultSet rs = ps.executeQuery();
            //Desplazar el puntero de los registros
            rs.next();
            //Leer el valor del campo
            newId = rs.getInt("newId");
            
        }
        catch(SQLException exp){
            //
        }
        
        return newId;
    }
    public void actualizar(ProductoM productoM){
        try
        {
            //Instanciar una conexion
            ConexionM conexionM = new ConexionM();
            //Ejecutar el metodo que devuelve la conexion abierta
            Connection cnx = conexionM.conectarToMySql();
            //Preparar la instruccion SQL
            PreparedStatement ps = cnx.prepareStatement("update producto "
                    + "set descripcion=?, categoria=?, precio=? "
                    + "where id=?");
            //Pasar los valores a los parametros
            ps.setString(1, productoM.getDescripcion());
            ps.setString(2, productoM.getCategoria());
            ps.setDouble(3, productoM.getPrecio());
            ps.setInt(4, productoM.getId());
            //Ejecutar el SQL
            ps.executeUpdate();            
        }
        catch(SQLException exp)
        {
            //
        }
    
    }
    public void eliminar(ProductoM productoM){
        try
        {
            //Instanciar una conexion
            ConexionM conexionM = new ConexionM();
            //Ejecutar el metodo que devuelve la conexion abierta
            Connection cnx = conexionM.conectarToMySql();
            //Preparar la instruccion SQL
            PreparedStatement ps = cnx.prepareStatement("delete from producto "
                    + "where id=?");
            //Pasar los valores a los parametros
            ps.setInt(1, productoM.getId());
            //Ejecutar el SQL
            ps.executeUpdate();            
        }
        catch(SQLException exp)
        {
            //
        }    
    }
    
    public ProductoM buscarById(int id){
        //Instanciar un productoM
        ProductoM productoM = new ProductoM();
        try{
            //Instanciar una conexion
            ConexionM conexionM = new ConexionM();
            //Ejecutar el metodo que devuelve la conexion abierta
            Connection cnx = conexionM.conectarToMySql();
            //Preparar la instruccion SQL
            PreparedStatement ps = cnx.prepareStatement("select * from producto "
                    + "where id=?");
            //Pasar los valores a los parametros
            ps.setInt(1, id);
            //Ejecutar el SQL y Recibir el Resultado
            ResultSet rs = ps.executeQuery();
            //Desplazar el puntero de registros
            if(rs.next()){
                //Leer los valores del registro
                id = rs.getInt("id");
                String descripcion = rs.getString("descripcion");
                String categoria = rs.getString("categoria");
                double precio = rs.getDouble("precio");
                
                //Los valores los transfiero al MODELO ya instanciado
                productoM.setId(id);
                productoM.setDescripcion(descripcion);
                productoM.setCategoria(categoria);
                productoM.setPrecio(precio);                
            }            
        }
        catch(SQLException exp){
            //
        }        
        return productoM;           
    }
    public List<ProductoM> buscarByDescripcion(String descripcion){
        
        //Declarar la coleccion List<>
        List<ProductoM> listaProductos = new ArrayList();
        
        try{
            //Instanciar una conexion
            ConexionM conexionM = new ConexionM();
            //Ejecutar el metodo que devuelve la conexion abierta
            Connection cnx = conexionM.conectarToMySql();
            //Preparar la instruccion SQL
            PreparedStatement ps = cnx.prepareStatement("select * from producto "
                    + "where descripcion like concat('%',?,'%')");
            //Pasar los valores a los parametros
            ps.setString(1, descripcion);
            //Ejecutar el SQL y Recibir el Resultado
            ResultSet rs = ps.executeQuery();
            
            //Desplazar el puntero de registros
            while(rs.next()){
                //Leer los valores del registro
                int id = rs.getInt("id");
                descripcion = rs.getString("descripcion");
                String categoria = rs.getString("categoria");
                double precio = rs.getDouble("precio");
                
                //Instanciar un productoM
                ProductoM productoM = new ProductoM();
                
                //Los valores los transfiero al MODELO ya instanciado
                productoM.setId(id);
                productoM.setDescripcion(descripcion);
                productoM.setCategoria(categoria);
                productoM.setPrecio(precio);
                
                //Agregar el producto a la lista
                
                listaProductos.add(productoM);
                
            }            
        }
        catch(SQLException exp){
            //
        }        
        return listaProductos;      
    }
}
