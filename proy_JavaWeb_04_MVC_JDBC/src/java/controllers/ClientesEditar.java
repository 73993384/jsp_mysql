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

@WebServlet(name = "ClientesEditar", urlPatterns = {"/ClientesEditar"})
public class ClientesEditar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Recoger el ID a buscar
        int vId = Integer.parseInt(request.getParameter("vId"));
        
        //Buscar el Cliente
        ClienteM clienteM = new ClienteM();        
        clienteM = clienteM.buscarById(vId);
        
        //Enviar el Producto a la VISTA
        request.setAttribute("cliente", clienteM);
        
        //Para cargar la VISTA utilizamos un DESPACHADOR
        //Declarar un DESPACHADOR de VISTAS: clienteEditar.jsp
        RequestDispatcher rd = request.getRequestDispatcher("clienteEditar.jsp");
        //Ejecutar el metodo para ir a la VISTA
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Recoger los valores enviados por el form
        int id = Integer.parseInt(request.getParameter("txtId"));
        String nombre = request.getParameter("txtNombre");
        String numruc = request.getParameter("txtNumruc");
        String direccion = request.getParameter("txtDireccion");
        String telefono = request.getParameter("txtTelefono");
        //Instanciar el modelo
        ClienteM clienteM = new ClienteM(id,nombre,numruc,direccion,telefono);
               
        //Ejecutar el metodo de actualizacion
        clienteM.actualizar(clienteM);
        
        //REDIRECCIONAR A OTRO CONTROLADOR
        response.sendRedirect("/Home/ClientesListar");
    }

}
