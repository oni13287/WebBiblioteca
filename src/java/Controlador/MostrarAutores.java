/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.MAutor;
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

@WebServlet(name = "MostrarAutores", urlPatterns = {"/MostrarAutores"})
public class MostrarAutores extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private ArrayList<MAutor> listarAutores() throws SQLException{
        MAutor aut=new MAutor();
        ResultSet datosAutores=aut.SolicitarAutores();
        ArrayList<MAutor> listaAutores=new ArrayList<>();
        while(datosAutores.next()){
            MAutor d=new MAutor();
            d.setIdAutor(datosAutores.getInt("idAutor"));
            d.setNombreAutor(datosAutores.getString("nombreAutor"));
            d.setApellidoAutor(datosAutores.getString("apellidoAutor"));
            listaAutores.add(d);
        }
        return listaAutores;     
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            ArrayList<MAutor> lAut=listarAutores();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Mostrar Autores</title>");            
            out.println("</head>");
            out.println("<body background =\"imagenes/biblioteca.jpg\">");
            out.println("<center><br><br><br><br><br><br><br><br><br><br>");
            out.println("<h1>Mostrar Autores</h1>");
            out.println("<table border='7'> ");
            out.println("<tr>"
                    + "<th>Id</th><th>Nombre</th>"
                    + "</tr>");
            for(MAutor d:lAut)
            {
                out.println("<tr>"
                    + "<td>"+d.getIdAutor()+"</td><td>"+d.getNombreAutor()+" "+d.getApellidoAutor()+"</td>"
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
            Logger.getLogger(MostrarAutores.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MostrarAutores.class.getName()).log(Level.SEVERE, null, ex);
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
