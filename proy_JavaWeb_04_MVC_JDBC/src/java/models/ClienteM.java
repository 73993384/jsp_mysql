package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteM {

    //ESTRUCTURA (PROPIEDADES, ENCAPSULADOS Y CONSTRUCTORES) = CAPA ENTIDAD
    private int id;
    private String nombre;
    private String numruc;
    private String direccion;
    private String telefono;

    public ClienteM() {
    }

    public ClienteM(int id, String nombre, String numruc, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.numruc = numruc;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumruc() {
        return numruc;
    }

    public void setNumruc(String numruc) {
        this.numruc = numruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //COMPORTAMIENTO (METODOS DE ACCESO A DATOS) = CAPA DATOS
    public int insertar(ClienteM clienteM) {
        //Declarar la variable newId
        int newId = 0;
        try {
            //Instanciar una conexion
            ConexionM conexionM = new ConexionM();
            //Ejecutar el metodo que devuelve la conexion abierta
            Connection cnx = conexionM.conectarToMySql();
            //Preparar la instruccion SQL
            PreparedStatement ps = cnx.prepareStatement("insert into cliente (nombre, numruc, direccion,telefono)values (?,?,?,?)");
            //Pasar los valores a los parametros
            ps.setString(1, clienteM.getNombre());
            ps.setString(2, clienteM.getNumruc());
            ps.setString(3, clienteM.getDireccion());
            ps.setString(4, clienteM.getTelefono());

            //Ejecutar el SQL
            ps.executeUpdate();

            //PARTE II: Recuperar el ID nuevo
            //Preparar la nueva instruccion SQL
            ps = cnx.prepareStatement("select max(id) as newId from cliente where nombre=?");
            //Pasar el parametro
            ps.setString(1, clienteM.getNombre());
            //Eejecutar la instruccion SQL
            ResultSet rs = ps.executeQuery();
            //Desplazar el puntero de los registros
            rs.next();
            //Leer el valor del campo
            newId = rs.getInt("newId");

        } catch (SQLException exp) {
            //
        }

        return newId;
    }

    public void actualizar(ClienteM clienteM) {
        try {
            //Instanciar una conexion
            ConexionM conexionM = new ConexionM();
            //Ejecutar el metodo que devuelve la conexion abierta
            Connection cnx = conexionM.conectarToMySql();
            //Preparar la instruccion SQL
            PreparedStatement ps = cnx.prepareStatement("update cliente set nombre=?, numruc=?, direccion=?, telefono=? where id=?");
            //Pasar los valores a los parametros
            ps.setString(1, clienteM.getNombre());
            ps.setString(2, clienteM.getNumruc());
            ps.setString(3, clienteM.getDireccion());
            ps.setString(4, clienteM.getTelefono());
            ps.setInt(5, clienteM.getId());
            //Ejecutar el SQL
            ps.executeUpdate();
        } catch (SQLException exp) {
            //
        }

    }

    public void eliminar(ClienteM clienteM) {
        try {
            //Instanciar una conexion
            ConexionM conexionM = new ConexionM();
            //Ejecutar el metodo que devuelve la conexion abierta
            Connection cnx = conexionM.conectarToMySql();
            //Preparar la instruccion SQL
            PreparedStatement ps = cnx.prepareStatement("delete from cliente where id=?");
            //Pasar los valores a los parametros
            ps.setInt(1, clienteM.getId());
            //Ejecutar el SQL
            ps.executeUpdate();
        } catch (SQLException exp) {
            //
        }
    }

    public ClienteM buscarById(int id) {
        //Instanciar un ClienteM
        ClienteM clienteM = new ClienteM();
        try {
            //Instanciar una conexion
            ConexionM conexionM = new ConexionM();
            //Ejecutar el metodo que devuelve la conexion abierta
            Connection cnx = conexionM.conectarToMySql();
            //Preparar la instruccion SQL
            PreparedStatement ps = cnx.prepareStatement("select * from cliente where id=?");
            //Pasar los valores a los parametros
            ps.setInt(1, id);
            //Ejecutar el SQL y Recibir el Resultado
            ResultSet rs = ps.executeQuery();
            //Desplazar el puntero de registros
            if (rs.next()) {
                //Leer los valores del registro
                id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String numruc = rs.getString("numruc");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");

                //Los valores los transfiero al MODELO ya instanciado
                clienteM.setId(id);
                clienteM.setNombre(nombre);
                clienteM.setNumruc(numruc);
                clienteM.setDireccion(direccion);
                clienteM.setTelefono(telefono);
            }
        } catch (SQLException exp) {
            //
        }
        return clienteM;
    }

    public List<ClienteM> buscarByNombre(String nombre) {

        //Declarar la coleccion List<>
        List<ClienteM> listaClientes = new ArrayList();

        try {
            //Instanciar una conexion
            ConexionM conexionM = new ConexionM();
            //Ejecutar el metodo que devuelve la conexion abierta
            Connection cnx = conexionM.conectarToMySql();
            //Preparar la instruccion SQL
            PreparedStatement ps = cnx.prepareStatement("select * from cliente where nombre like concat('%',?,'%')");
            //Pasar los valores a los parametros
            ps.setString(1, nombre);
            //Ejecutar el SQL y Recibir el Resultado
            ResultSet rs = ps.executeQuery();

            //Desplazar el puntero de registros
            while (rs.next()) {
                //Leer los valores del registro
                int id = rs.getInt("id");
                nombre = rs.getString("nombre");
                String numruc = rs.getString("numruc");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");

                //Instanciar un productoM
                ClienteM clienteM = new ClienteM();

                //Los valores los transfiero al MODELO ya instanciado
                clienteM.setId(id);
                clienteM.setNombre(nombre);
                clienteM.setNumruc(numruc);
                clienteM.setDireccion(direccion);
                clienteM.setTelefono(telefono);

                //Agregar el producto a la lista
                listaClientes.add(clienteM);

            }
        } catch (SQLException exp) {
            //
        }
        return listaClientes;
    }
}
