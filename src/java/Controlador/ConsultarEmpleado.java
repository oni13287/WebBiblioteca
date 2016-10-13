/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.MEmpleado;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author oorti_000
 */
@WebServlet(name = "ConsultarEmpleado", urlPatterns = {"/ConsultarEmpleado"})
public class ConsultarEmpleado extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            MEmpleado aut=new MEmpleado ();
            ResultSet rEmp=aut.consultarEmpleados(Integer.parseInt(request.getParameter("txtId")));
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Datos Empleado</title>");            
            out.println("</head>");
            out.println("<body background =\"imagenes/biblioteca.jpg\">");
            out.println("<center><br><br><br><br><br><br><br><br><br><br>");     
            out.println("<h1>Datos Empleado</h1><br>");
             if (rEmp.next())
            {
                if (rEmp.getInt("generoEmpleado") == 0) {
                    out.println("<p>NOMBRE: "+rEmp.getString("nombreEmpleado")+" "+rEmp.getString("apellidoEmpleado")+"<br>FECHA DE CONTRATACION: "+rEmp.getString("fechaContratacion")+"<br>GENERO: masculino <br> EMAIL: "+rEmp.getString("emailEmpleado")+"<br>DIRECCION: "+rEmp.getString("direccionEmpleado")+"</p>");
                }else{ 
                   out.println("<p>NOMBRE: "+rEmp.getString("nombreEmpleado")+" "+rEmp.getString("apellidoEmpleado")+"<br>FECHA DE CONTRATACION: "+rEmp.getString("fechaContratacion")+"<br>GENERO: femenino <br> EMAIL: "+rEmp.getString("emailEmpleado")+"<br>DIRECCION: "+rEmp.getString("direccionEmpleado")+"</p>");
                }
            }
            else
            {
                out.println("<p>El Id ingresado no esta registrado</p>");
            }
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
