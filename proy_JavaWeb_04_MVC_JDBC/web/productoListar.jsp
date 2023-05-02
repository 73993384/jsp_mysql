<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- IMPORTAR LIBRERIA PARA LIST<> -->
<%@page import="java.util.*" %>
<!-- IMPORTAR LIBRERIA PARA MODELO -->
<%@page import="models.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Producto</title>
        <script>
            function confirmaEliminar(id)
            {
                var rpta = confirm("¿Esta seguro que desea eliminar?");
                if(rpta){
                    var miHost = window.location.host;
                    parent.location = "http://" + miHost + "/Home/ProductoEliminar?vId="+id;
                }
            }
        </script>
       
    </head>
    <body>
        <h1>Producto: GESTIONAR</h1>
        <a href="/Home/ProductoAgregar">Agregar un Producto</a>
        <hr>
        <form method="post">
            Buscar:
            <input type="text" name="txtValorBuscado" value="" />
            <input type="submit" value="Buscar" />
        </form>
        <hr>
        <table border="1">
            <tr>
                <th>CODIGO</th>
                <th>DESCRIPCION</th>
                <th>CATEGORIA</th>
                <th>PRECIO</th>
                
            </tr>
            <%
                //Recoger la variable EL lista de productos y castear
                List<ProductoM> listaProductos = (List<ProductoM>) request.getAttribute("listaProductos");
                //Recorrer la Lista Productos
                for (ProductoM producto : listaProductos) 
                {
            %>
            
            <tr>
                <td><%=producto.getId()%></td>
                <td><%=producto.getDescripcion()%></td>
                <td><%=producto.getCategoria()%></td>
                <td><%=producto.getPrecio()%></td>
                <td><a href="/Home/ProductoEditar?vId=<%=producto.getId()%>">Editar</a></td>
                <!--
                <td><a href="/Home/ProductoEliminar?vId=<%=producto.getId()%>">Eliminar</a></td>
                -->
                <td><a href="javascript:confirmaEliminar('<%=producto.getId()%>')">Eliminar</a></td>
            </tr>            
            
            <%
                }
            %>

        </table>
    </body>
</html>
