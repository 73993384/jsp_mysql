package models;

//Importar la LIBRERIA para SQL
import java.sql.*;

public class ConexionM {
    //ESTRUCTURA (PROPIEDADES, ENCAPSULADOS Y CONSTRUCTORES) = CAPA ENTIDAD
    // NO EXISTE
    
    //COMPORTAMIENTO (METODOS DE ACCESO A DATOS) = CAPA DATOS
    public Connection conectarToMySql(){
        //Declarar una variable conexion NULL
        Connection cnx = null;
        try
        {
            //CODIGO QUE SE EJECUTA SIN ERRORES DE EXCEPCION
            //Cargar el DRIVER: MySQL / MariaDB
            Class.forName("com.mysql.jdbc.Driver");
            //Definir la variables para la conexion
            String cadena = "jdbc:mysql://localhost:3306/bdFB305";
            String usuario = "root";
            String clave = "";
            //Abrir la conexion
            cnx = DriverManager.getConnection(cadena, usuario, clave);

        }
        catch(SQLException | ClassNotFoundException exp)
        {
            //CODIGO QUE SE EJECUTA CUANDO HAY ERRORES DE EXCEPCION
            
        }
        //Devolver la CONEXION
        return cnx;
    }
}
