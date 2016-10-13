/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.MCliente;
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

@WebServlet(name = "MostrarClientes", urlPatterns = {"/MostrarClientes"})
public class MostrarClientes extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private ArrayList<MCliente> listarClientes() throws SQLException{
        MCliente cli=new MCliente();
        ResultSet datosClientes=cli.SolicitarClientes();
        ArrayList<MCliente> listaClientes=new ArrayList<>();
        while(datosClientes.next()){
            MCliente d=new MCliente();
            d.setIdCliente(datosClientes.getInt("idCliente"));
            d.setNombreCliente(datosClientes.getString("nombreCliente"));
            d.setApellidoCliente(datosClientes.getString("apellidoCliente"));
            d.setGeneroCliente(datosClientes.getInt("generoCliente"));
            d.setEmailCliente(datosClientes.getString("emailCliente"));
            d.setDireccionCliente(datosClientes.getString("direccionCliente"));
            
            listaClientes.add(d);
        }
        return listaClientes;     
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            ArrayList<MCliente> lCli=listarClientes();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Mostrar Cliente</title>");            
            out.println("</head>");
            out.println("<body background =\"imagenes/biblioteca.jpg\">");
            out.println("<center><br><br><br><br><br><br><br><br><br><br>");
            out.println("<h1>Mostrar Clientes</h1>");
            out.println("<table border='10' >");
            out.println("<tr>"
                    + "<th>Id</th><th>Nombre</th><th>Genero</th><th>Email</th><th>Direccion</th>"
                    + "</tr>");
            for(MCliente d:lCli)
            {
                if (d.getGeneroCliente() == 0) {
                out.println("<tr>"
                    + "<td>"+d.getIdCliente()+"</td><td>"+d.getNombreCliente()+" "+d.getApellidoCliente()+"</td><td> masculino</td><td>"+d.getEmailCliente()+"</td><td>"+d.getDireccionCliente()+"</td>"
                    + "</tr>");
                 }
                else {
                out.println("<tr>"
                    + "<td>"+d.getIdCliente()+"</td><td>"+d.getNombreCliente()+" "+d.getApellidoCliente()+"</td><td> femenino</td><td>"+d.getEmailCliente()+"</td><td>"+d.getDireccionCliente()+"</td>"
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
            Logger.getLogger(MostrarClientes.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MostrarClientes.class.getName()).log(Level.SEVERE, null, ex);
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
