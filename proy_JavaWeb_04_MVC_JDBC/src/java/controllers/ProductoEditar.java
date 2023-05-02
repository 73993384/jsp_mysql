package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;
import models.ProductoM;

@WebServlet(name = "ProductoEditar", urlPatterns = {"/ProductoEditar"})
public class ProductoEditar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Recoger el ID a buscar
        int vId = Integer.parseInt(request.getParameter("vId"));
        
        //Buscar el Producto
        ProductoM productoM = new ProductoM();        
        productoM = productoM.buscarById(vId);
        
        //Enviar el Producto a la VISTA
        request.setAttribute("producto", productoM);
        
        //Para cargar la VISTA utilizamos un DESPACHADOR
        //Declarar un DESPACHADOR de VISTAS: productoEditar.jsp
        RequestDispatcher rd = request.getRequestDispatcher("productoEditar.jsp");
        //Ejecutar el metodo para ir a la VISTA
        rd.forward(request, response);         
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Recoger los valores enviados por el form
        int id = Integer.parseInt(request.getParameter("txtId"));
        String descripcion = request.getParameter("txtDescripcion");
        String categoria = request.getParameter("txtCategoria");
        double precio = Double.parseDouble(request.getParameter("txtPrecio"));
        //Instanciar el modelo
        ProductoM productoM = new ProductoM(id,descripcion,categoria,precio);
               
        //Ejecutar el metodo de actualizacion
        productoM.actualizar(productoM);
        
        //REDIRECCIONAR A OTRO CONTROLADOR
        response.sendRedirect("/Home/ProductoListar");

        /*
        //Enviar a la vista el producto
        request.setAttribute("producto", productoM);

        //Para cargar la VISTA utilizamos un DESPACHADOR
        //Declarar un DESPACHADOR de VISTAS: productoEditar.jsp
        RequestDispatcher rd = request.getRequestDispatcher("productoEditar.jsp");
        //Ejecutar el metodo para ir a la VISTA
        rd.forward(request, response);
        */
    }


}
