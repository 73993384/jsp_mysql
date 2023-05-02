<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- IMPORTAR LIBRERIA PARA LIST<> -->
<%@page import="java.util.*" %>
<!-- IMPORTAR LIBRERIA PARA MODELO -->
<%@page import="models.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Cliente</title>
    </head>
    <body>
        <h1>Cliente: GESTIONAR</h1>
        <a href="/Home/ClienteAgregar">Agregar un Cliente</a>
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
                <th>NOMBRE</th>
                <th>N° RUC</th>
                <th>DIRECCION</th>
                <th>TELEFONO</th>
            </tr>
            <%
                //Recoger la variable EL lista de productos y castear
                List<ClienteM> listaClientes = (List<ClienteM>) request.getAttribute("listarClientes");
                //Recorrer la Lista Productos
                for (ClienteM cliente : listaClientes) {
            %>

            <tr>
                <td><%=cliente.getId()%></td>
                <td><%=cliente.getNombre()%></td>
                <td><%=cliente.getNumruc()%></td>
                <td><%=cliente.getDireccion()%></td>
                <td><%=cliente.getTelefono()%></td>

                <td><a href="/Home/ClientesEditar?vId=<%=cliente.getId()%>">Editar</a></td>
                <!--
                <td><a href="/Home/ClienteEliminar?vId=<%=cliente.getId()%>">Eliminar</a></td>
                -->
                <td><a href="javascript:confirmaEliminar('<%=cliente.getId()%>')">Eliminar</a></td>
            </tr>            

            <%
                }
            %>

        </table>
        <script>
            function confirmaEliminar(id)
            {
                var rpta = confirm("¿Esta seguro que desea eliminar?");
                if (rpta) {
                    var miHost = window.location.host;
                    parent.location = "http://" + miHost + "/Home/ClientesEliminar?vId=" + id;
                }
            }
        </script>
    </body>
</html>
