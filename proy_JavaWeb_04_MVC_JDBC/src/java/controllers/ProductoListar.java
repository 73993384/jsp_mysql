package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//IMPORTAR LIBRERIA PARA EL DESPACHADOR
import javax.servlet.RequestDispatcher;

//IMPORTAR LIBRERIA PARA LOS MODELOS
import models.*;

//IMPORTAR LIBRERIA PARA LIST<>
import java.util.*;


@WebServlet(name = "ProductoListar", urlPatterns = {"/ProductoListar"})
public class ProductoListar extends HttpServlet {

    //METODO RESPONDE A SOLICITUD GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Instanciar un ProductoM
        ProductoM productoM = new ProductoM();
        
        //Ejecutar el METODO de BUSQUEDA
        List<ProductoM> listaProductos = productoM.buscarByDescripcion(null);
        
        //Enviar a la VISTA la Lista de Productos con una variable EL
        request.setAttribute("listaProductos",listaProductos);
        
        //Para cargar la VISTA utilizamos un DESPACHADOR
        //Declarar un DESPACHADOR de VISTAS: ProductoListar.jsp
        RequestDispatcher rd = request.getRequestDispatcher("productoListar.jsp");
        //Ejecutar el metodo para ir a la VISTA
        rd.forward(request, response);        
    }

    //METODO RESPONDE A SOLICITUD POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Recibir el valor a BUSCAR enviado por FORM con POST
        String valorBuscado = request.getParameter("txtValorBuscado");
        
        //Instanciar un ProductoM
        ProductoM productoM = new ProductoM();
        
        //Ejecutar el METODO de BUSQUEDA
        List<ProductoM> listaProductos = productoM.buscarByDescripcion(valorBuscado);
        
        //Enviar a la VISTA la Lista de Productos con una variable EL
        request.setAttribute("listaProductos",listaProductos);
        
        //Para cargar la VISTA utilizamos un DESPACHADOR
        //Declarar un DESPACHADOR de VISTAS: ProductoListar.jsp
        RequestDispatcher rd = request.getRequestDispatcher("productoListar.jsp");
        //Ejecutar el metodo para ir a la VISTA
        rd.forward(request, response);         
    }

}
