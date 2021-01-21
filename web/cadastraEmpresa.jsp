<%-- 
    Document   : cadastraEmpresa
    Created on : 21/01/2021, 09:49:59
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
        <h1>Cadastro de Empresa</h1>
        <form action="FrontController?action=GravarEmpresa" method="post">
            Entre com seu nome
            <input type="text" name="textNome"/><br/>
            <input type="submit"/>
        </form>
    </body>
</html>
