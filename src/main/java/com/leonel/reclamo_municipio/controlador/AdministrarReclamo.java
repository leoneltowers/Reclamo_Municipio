/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.leonel.reclamo_municipio.controlador;

import com.leonel.reclamo_municipio.modelo.ReclamoDAO;
import com.leonel.reclamo_municipio.modelo.ReclamoDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leonel_Towers
 */
@WebServlet(name = "AdministrarReclamo", urlPatterns = {"/administrar"})
public class AdministrarReclamo extends HttpServlet {
    private final String URI_ADMIN_REC = "AdministrarReclamo.jsp";
    ReclamoDTO rec = new ReclamoDTO();
    ReclamoDAO recdao = new ReclamoDAO();
    int ide;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

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
        
        String accion = request.getParameter("accion");
        //String tipoModelo = request.getParameter("modelo");
        accion = accion == null ? "" : accion;
        ReclamoDTO recl;
        switch (accion) {
            
            case "listar":
                List lista=recdao.listar();
                request.setAttribute("listarReclamos", lista);
                request.getRequestDispatcher(URI_ADMIN_REC).forward(request, response);
                
                break; 
            case "edit":
                ide=Integer.parseInt(request.getParameter("idReclamo"));
                recl= recdao.getReclamo(ide);
                request.setAttribute("editarReclamo", recl);
                request.getRequestDispatcher("administrar?accion=listar").forward(request, response);    
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
        String accion = request.getParameter("accion");
        //String tipoModelo = request.getParameter("modelo");
        accion = accion == null ? "" : accion;
        ReclamoDTO recl;
        switch (accion) {
//            case "edit":
//                ide=Integer.parseInt(request.getParameter("id"));
//                ReclamoDTO recl= recdao.listar(ide);
//                request.setAttribute("reclamo", recl);
                //request.getRequestDispatcher("administrar?accion=listar").forward(request, response);
                
//                break;
            case "uptade":
                ide=Integer.parseInt(request.getParameter("idReclamo"));
                recl = recdao.getReclamo(ide);
                String fechaCreacion = request.getParameter("txtFechaCreacion");
                String fecharesolucion = request.getParameter("txtFechaResolucion");
                //String categoria = request.getParameter("txtCategoria");
                String domicilio = request.getParameter("txtDomicilio");
                recl.setFechaCreacion(fechaCreacion);
                recl.setFechaResolucion(fecharesolucion);
                //rec.setFechaCreacion(categoria);//cambiar
                recl.setDomicilio(domicilio);
                //recl.setIdReclamo(ide);
               
                recdao.actualizar(recl);
                request.getRequestDispatcher("administrar?accion=listar").forward(request, response); 
                
                               
                break;
                
            case "delete":
                ide=Integer.parseInt(request.getParameter("idReclamo"));
                recdao.eliminar(ide);
                               
                break;
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
