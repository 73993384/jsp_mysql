<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- IMPORTAR AL MODELO -->
<%@page import="models.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EDITAR</title>
    </head>
    <body>
        <h1>PRODUCTO: Agregar</h1>
        <hr>
        <%
            //RECOGER LA VARIABLE EL
            ProductoM producto = (ProductoM) request.getAttribute("producto");
            
        %>
        <form method="post">
            <table>
                <tr><td>CODIGO</td><td><input type="text" name="txtId" value="<%=producto.getId()%>" readonly="true"/></td></tr>
                <tr><td>DESCRIPCION</td><td><input type="text" name="txtDescripcion" value="<%=producto.getDescripcion()%>"/></td></tr>
                <tr><td>CATEGORIA</td><td><input type="text" name="txtCategoria" value="<%=producto.getCategoria()%>"/></td></tr>
                <tr><td>PRECIO S/.</td><td><input type="text" name="txtPrecio" value="<%=producto.getPrecio()%>"/></td></tr>
                <tr><td><a href="/Home/ProductoListar">Ir al Inicio</a></td><td><input type="submit" value="Guardar"/></td></tr>
            </table>
        </form>
    </body>
</html>
