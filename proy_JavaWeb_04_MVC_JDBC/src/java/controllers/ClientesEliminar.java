package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.*;

@WebServlet(name = "ClientesEliminar", urlPatterns = {"/ClientesEliminar"})
public class ClientesEliminar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Recoger el vId
        int vId = Integer.parseInt(request.getParameter("vId"));
        //Instanciar el modelo
        ClienteM clienteM = new ClienteM(vId, "", "", "","");
        //Ejecutar el metodo de eliminacion
        clienteM.eliminar(clienteM);
        //Redireccionar a otro controlador
        response.sendRedirect("/Home/ClientesListar");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
