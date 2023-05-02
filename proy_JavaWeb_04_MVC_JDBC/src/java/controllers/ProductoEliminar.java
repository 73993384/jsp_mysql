package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.ProductoM;

@WebServlet(name = "ProductoEliminar", urlPatterns = {"/ProductoEliminar"})
public class ProductoEliminar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Recoger el vId
        int vId = Integer.parseInt(request.getParameter("vId"));
        //Instanciar el modelo
        ProductoM productoM = new ProductoM(vId, "", "", 0.0);
        //Ejecutar el metodo de eliminacion
        productoM.eliminar(productoM);
        //Redireccionar a otro controlador
        response.sendRedirect("/Home/ProductoListar");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


}
