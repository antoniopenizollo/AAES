<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Menu de funcionalidade Cadastro Contato</h1>
        <a href="cadastraContato.jsp"><button>Cadastra contato</button></a>
        <a href="buscaContato.jsp"><button>Busca contato</button></a>
        <a href="deleteContato.jsp"><button>Deleta contato</button></a>
        
        <h1>Menu de funcionalidade Cadastro Empresa</h1>
        <a href="cadastraEmpresa.jsp"><button>Cadastra empresa</button></a>
        <a href="buscaEmpresa.jsp"><button>Busca empresa</button></a>
        <a href="deleteEmpresa.jsp"><button>Deleta empresa</button></a>
    </body>
</html>
