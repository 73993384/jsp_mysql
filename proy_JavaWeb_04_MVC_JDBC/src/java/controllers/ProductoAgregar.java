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

@WebServlet(name = "ProductoAgregar", urlPatterns = {"/ProductoAgregar"})
public class ProductoAgregar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Instanciar el MODELO con sus valores PREDETERMINADOS
        ProductoM productoM = new ProductoM(0, "", "", 0.0);
        //Enviar a la VISTA el PRODUCTO con una variable EL
        request.setAttribute("producto", productoM);
        
        //Para cargar la VISTA utilizamos un DESPACHADOR
        //Declarar un DESPACHADOR de VISTAS: productoAgregar.jsp
        RequestDispatcher rd = request.getRequestDispatcher("productoAgregar.jsp");
        //Ejecutar el metodo para ir a la VISTA
        rd.forward(request, response);          
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Recibir los valores de los parametros enviado desde el FORM metodo POST
        int id = Integer.parseInt(request.getParameter("txtId"));
        String descripcion = request.getParameter("txtDescripcion");
        String categoria = request.getParameter("txtCategoria");
        double precio = Double.parseDouble(request.getParameter("txtPrecio"));
        
        //Instanciar el MODELO con sus valores
        ProductoM productoM = new ProductoM(id, descripcion, categoria, precio);
        
        //Ejecutar el metodo para insertar (si el ID=0)
        if(productoM.getId()==0){            
            int newId = productoM.insertar(productoM);
            productoM.setId(newId);
        }        
        //Enviar a la VISTA el PRODUCTO con una variable EL
        request.setAttribute("producto", productoM);
        
        //Para cargar la VISTA utilizamos un DESPACHADOR
        //Declarar un DESPACHADOR de VISTAS: productoAgregar.jsp
        RequestDispatcher rd = request.getRequestDispatcher("productoAgregar.jsp");
        //Ejecutar el metodo para ir a la VISTA
        rd.forward(request, response);              
    }

}
