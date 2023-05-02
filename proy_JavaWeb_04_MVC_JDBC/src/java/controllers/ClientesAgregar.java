package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.*;

@WebServlet(name = "ClienteAgregar", urlPatterns = {"/ClienteAgregar"})
public class ClientesAgregar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Instanciar el MODELO con sus valores PREDETERMINADOS
        ClienteM clienteM = new ClienteM(0, "", "", "", "");
        //Enviar a la VISTA el PRODUCTO con una variable EL
        request.setAttribute("cliente", clienteM);

        //Para cargar la VISTA utilizamos un DESPACHADOR
        //Declarar un DESPACHADOR de VISTAS: clienteAgregar.jsp
        RequestDispatcher rd = request.getRequestDispatcher("clienteAgregar.jsp");
        //Ejecutar el metodo para ir a la VISTA
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Recibir los valores de los parametros enviado desde el FORM metodo POST
        int id = Integer.parseInt(request.getParameter("txtId"));
        String nombre = request.getParameter("txtNombre");
        String numruc = request.getParameter("txtNumruc");
        String direccion = request.getParameter("txtDireccion");
        String telefono = request.getParameter("txtTelefono");

        //Instanciar el MODELO con sus valores
        ClienteM clienteM = new ClienteM(id, nombre, numruc, direccion,telefono);

        //Ejecutar el metodo para insertar (si el ID=0)
        if (clienteM.getId() == 0) {
            int newId = clienteM.insertar(clienteM);
            clienteM.setId(newId);
        }
        //Enviar a la VISTA el PRODUCTO con una variable EL
        request.setAttribute("cliente", clienteM);

        //Para cargar la VISTA utilizamos un DESPACHADOR
        //Declarar un DESPACHADOR de VISTAS: productoAgregar.jsp
        RequestDispatcher rd = request.getRequestDispatcher("clienteAgregar.jsp");
        //Ejecutar el metodo para ir a la VISTA
        rd.forward(request, response);
    }

}
