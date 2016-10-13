<%-- 
    Document   : buscaDocente
    Created on : 30/06/2014, 06:47:31 PM
    Author     : oorti_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta Categoria</title>
    </head>
   <body background ="imagenes/biblioteca.jpg">
      <center>
       </br></br></br></br></br></br></br></br>INGRESE EL ID DEL CATEGORIA</br>
        <form action="ConsultarCategoria" method="POST">
            <input type="text" name="txtId" value="" required placeholder="Ingrese ID de Categoria"/>
            <input type="submit" value="Enviar Datos" />
        </form>
      </center>
    </body>
</html>
