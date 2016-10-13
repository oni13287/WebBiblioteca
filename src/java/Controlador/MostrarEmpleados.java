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
import java.util.ArrayList;
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

@WebServlet(name = "MostrarEmpleados", urlPatterns = {"/MostrarEmpleados"})
public class MostrarEmpleados extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private ArrayList<MEmpleado> listarEmpleado() throws SQLException{
        MEmpleado aut=new MEmpleado();
        ResultSet datosEmpleado=aut.SolicitarEmpleados();
        ArrayList<MEmpleado> listaEmpleado=new ArrayList<>();
        while(datosEmpleado.next()){
            MEmpleado d=new MEmpleado();
            d.setIdEmpleado(datosEmpleado.getInt("idEmpleado"));
            d.setNombreEmpleado(datosEmpleado.getString("nombreEmpleado"));
            d.setApellidoEmpleado(datosEmpleado.getString("apellidoEmpleado"));
            d.setFechaContratacion(datosEmpleado.getString("fechaContratacion"));
            d.setGeneroEmpleado(datosEmpleado.getInt("generoEmpleado"));
            d.setEmailEmpleado(datosEmpleado.getString("emailEmpleado"));
            d.setDireccionEmpleado(datosEmpleado.getString("direccionEmpleado"));
           
            listaEmpleado.add(d);
        }
        return listaEmpleado;    
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            ArrayList<MEmpleado> lEmp=listarEmpleado();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Mostrar Empleado</title>");            
            out.println("</head>");
            out.println("<body background =\"imagenes/biblioteca.jpg\">");
            out.println("<center><br><br><br><br><br><br><br><br><br><br>");
            out.println("<h1>Mostrar Empleado</h1>");
            out.println("<table border='10'> ");
            out.println("<tr>"
                    + "<th>Id</th><th>Nombre</th><th>Fecha de Contratacion</th><th>Genero</th><th>Email</th><th>Direccion</th>"
                    + "</tr>");
            for(MEmpleado d:lEmp)
            {
                 if (d.getGeneroEmpleado()== 0) {
                out.println("<tr>"
                    + "<td>"+d.getIdEmpleado()+"</td><td>"+d.getNombreEmpleado()+" "+d.getApellidoEmpleado()+"</td><td>"+d.getFechaContratacion()+"</td><td>masculino</td><td>"+d.getEmailEmpleado()+"</td><td>"+d.getDireccionEmpleado()+"</td>"
                    + "</tr>");
                } else {
                out.println("<tr>"
                    + "<td>"+d.getIdEmpleado()+"</td><td>"+d.getNombreEmpleado()+" "+d.getApellidoEmpleado()+"</td><td>"+d.getFechaContratacion()+"</td><td>femenino</td><td>"+d.getEmailEmpleado()+"</td><td>"+d.getDireccionEmpleado()+"</td>"
                    + "</tr>"); 
                }     
            }
            out.println("</table>");
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
            Logger.getLogger(MostrarEmpleados.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MostrarEmpleados.class.getName()).log(Level.SEVERE, null, ex);
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
