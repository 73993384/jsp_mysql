package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.*;

@WebServlet(name = "VentaListar", urlPatterns = {"/VentaListar"})
public class VentaListar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Instanciar un ProductoM
        ClienteM clienteM = new ClienteM();
        
        //Ejecutar el METODO de BUSQUEDA
        List<ClienteM> listarClientes = clienteM.buscarByNombre(null);
        
        //Enviar a la VISTA la Lista de Clientes con una variable EL
        request.setAttribute("listarClientes",listarClientes);
        
        //Para cargar la VISTA utilizamos un DESPACHADOR
        //Declarar un DESPACHADOR de VISTAS: clienteListar.jsp
        RequestDispatcher rd = request.getRequestDispatcher("clienteListar.jsp");
        //Ejecutar el metodo para ir a la VISTA
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
