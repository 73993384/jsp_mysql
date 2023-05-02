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


@WebServlet(name = "ClientesListar", urlPatterns = {"/ClientesListar"})
public class ClientesListar extends HttpServlet {
    
    //METODO RESPONDE A SOLICITUD GET
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

    //METODO RESPONDE A SOLICITUD POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Recibir el valor a BUSCAR enviado por FORM con POST
        String valorBuscado = request.getParameter("txtValorBuscado");
        
        //Instanciar un ClienteM
        ClienteM clienteM = new ClienteM();
        
        //Ejecutar el METODO de BUSQUEDA
        List<ClienteM> listarClientes = clienteM.buscarByNombre(valorBuscado);
        
        //Enviar a la VISTA la Lista de Productos con una variable EL
        request.setAttribute("listarClientes",listarClientes);
        
        //Para cargar la VISTA utilizamos un DESPACHADOR
        //Declarar un DESPACHADOR de VISTAS: clienteListar.jsp
        RequestDispatcher rd = request.getRequestDispatcher("clienteListar.jsp");
        //Ejecutar el metodo para ir a la VISTA
        rd.forward(request, response);         
    }

}
