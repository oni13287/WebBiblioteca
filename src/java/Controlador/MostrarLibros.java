/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.MLibro;
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

@WebServlet(name = "MostrarLibros", urlPatterns = {"/MostrarLibros"})
public class MostrarLibros extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private ArrayList<MLibro> listarLibros() throws SQLException{
        MLibro aut=new MLibro();
        ResultSet datosLibros=aut.SolicitarLibros();
        ArrayList<MLibro> listaLibros=new ArrayList<>();
        while(datosLibros.next()){
            MLibro d=new MLibro();
            d.setIdLibro(datosLibros.getInt("idLibro"));
            d.setNombreLibro(datosLibros.getString("nombreLibro"));
            d.setNombreAutor(datosLibros.getString("nombreAutor"));
            d.setApellidoAutor(datosLibros.getString("apellidoAutor"));
            d.setNombreCategoria(datosLibros.getString("nombreCategoria"));
            
            listaLibros.add(d);
        }
        return listaLibros;     
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            ArrayList<MLibro> lLib=listarLibros();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Mostrar Libros</title>");            
            out.println("</head>");
            out.println("<body background =\"imagenes/biblioteca.jpg\">");
            out.println("<center><br><br><br><br><br><br><br><br><br><br>");
            out.println("<h1>Mostrar Libros</h1>");
            out.println("<table border='10'> ");
            out.println("<tr>"
                    + "<th>Id</th><th> TITULO </th><th>Autor</th><th>Categoria</th>"
                    + "</tr>");
            for(MLibro d:lLib)
            {
                out.println("<tr>"
                    + "<td>"+d.getIdLibro()+"</td><td>"+d.getNombreLibro()+"</td><td>"+d.getNombreAutor()+" "+d.getApellidoAutor()+"</td><td>"+d.getNombreCategoria()+"</td>"
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
            Logger.getLogger(MostrarLibros.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MostrarLibros.class.getName()).log(Level.SEVERE, null, ex);
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
