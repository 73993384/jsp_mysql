<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- IMPORTAR AL MODELO -->
<%@page import="models.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Cliente</title>
    </head>
    <body>
        <h1>CLIENTE: Agregar</h1>
        <hr>
        <%
            //RECOGER LA VARIABLE EL
            ClienteM cliente = (ClienteM) request.getAttribute("cliente");

        %>
        <form method="post">
            <table>
                <tr><td>CODIGO</td><td><input type="text" name="txtId" value="<%=cliente.getId()%>" readonly="true"/></td></tr>
                <tr><td>NOMBRE</td><td><input type="text" name="txtNombre" value="<%=cliente.getNombre()%>"/></td></tr>
                <tr><td>N° RUC</td><td><input type="text" name="txtNumruc" value="<%=cliente.getNumruc()%>"/></td></tr>
                <tr><td>DIRECCION</td><td><input type="text" name="txtDireccion" value="<%=cliente.getDireccion()%>"/></td></tr>
                <tr><td>TELEFONO</td><td><input type="text" name="txtTelefono" value="<%=cliente.getTelefono()%>"/></td></tr>
                <tr><td><a href="/Home/ClientesListar">Ir al Inicio</a></td><td><input type="submit" value="Guardar"/></td></tr>
            </table>
        </form>
    </body>
</html>
