<%-- 
    Document   : buscaEmpresa
    Created on : 21/01/2021, 09:50:11
    Author     : anton
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Buscar dados da empresa por id empresa</h1>
        <form action="FrontController?action=LerEmpresa" method="post">
            Entre com id empresa
            <input type="text" name="textId"/><br/>
            <input type="submit"/>
        </form>
    </body>
</html>
