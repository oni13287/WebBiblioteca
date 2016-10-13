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
        <title>Consulta Libro</title>
    </head>
     <body background ="imagenes/biblioteca.jpg">
      <center>
       </br></br></br></br></br></br></br></br>INGRESE EL ID DEL LIBRO</br>
        <form action="ConsultarLibro" method="POST">
            <input type="text" name="txtId" value="" required placeholder="Ingrese ID de Libro"/>
            <input type="submit" value="Enviar Datos" />
        </form>
       </center>
   </body>
</html>
