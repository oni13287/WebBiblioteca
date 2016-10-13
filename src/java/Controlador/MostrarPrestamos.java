/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.MPrestamo;
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

@WebServlet(name = "MostrarPrestamos", urlPatterns = {"/MostrarPrestamos"})
public class MostrarPrestamos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private ArrayList<MPrestamo> listarPrestamos() throws SQLException{
        MPrestamo pre=new MPrestamo();
        ResultSet datosPrestamos=pre.SolicitarPrestamos();
        ArrayList<MPrestamo> listaPrestamos=new ArrayList<>();
        while(datosPrestamos.next()){
            MPrestamo d=new MPrestamo();
            d.setIdPrestamo(datosPrestamos.getInt("idPrestamo"));
            d.setNombreLibro(datosPrestamos.getString("nombreLibro"));
            d.setNombreCliente(datosPrestamos.getString("nombreCliente"));
            d.setApellidoCliente(datosPrestamos.getString("apellidoCliente"));
            d.setNombreEmpleado(datosPrestamos.getString("nombreEmpleado"));
            d.setApellidoEmpleado(datosPrestamos.getString("apellidoEmpleado"));
            d.setFechaPedido(datosPrestamos.getString("fechaPedido"));
            d.setFechaEntrega(datosPrestamos.getString("fechaEntrega"));
            listaPrestamos.add(d);
        }
        return listaPrestamos;     
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            ArrayList<MPrestamo> lPre=listarPrestamos();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Mostrar Prestamos</title>");            
            out.println("</head>");
            out.println("<body background =\"imagenes/biblioteca.jpg\">");
            out.println("<center><br><br><br><br><br><br><br><br><br><br>");
            out.println("<h1>Mostrar Prestamos</h1>");
            out.println("<table border='10'> ");
            out.println("<tr>"
                    + "<th>Numero de Prestamo</th><th> Libro</th><th>Cliente</th><th>Empleado</th><th>Fecha de Alquiler</th><th>Fecha de Entrega</th>"
                    + "</tr>");
            for(MPrestamo d:lPre)
            {
                out.println("<tr>"
                    + "<td>"+d.getIdPrestamo()+"</td><td>"+d.getNombreLibro()+"</td><td>"+d.getNombreCliente()+" "+d.getApellidoCliente()+"</td><td>"+d.getNombreEmpleado()+" "+d.getApellidoEmpleado()+"</td><td>"+d.getFechaPedido()+"</td><td>"+d.getFechaEntrega()+"</td>"
                    + "</tr>");
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
            Logger.getLogger(MostrarPrestamos.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MostrarPrestamos.class.getName()).log(Level.SEVERE, null, ex);
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
