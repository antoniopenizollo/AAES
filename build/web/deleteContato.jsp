<%-- 
    Document   : deleteContato
    Created on : 20/01/2021, 22:29:46
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
        <h1>Deletar usuário pela chave primária</h1>
        <form action="FrontController?action=ApagarContato" method="post">
            Entre com seu email
            <input type="text" name="textEmail"/><br/>
            <input type="submit"/>
        </form>
    </body>
</html>
