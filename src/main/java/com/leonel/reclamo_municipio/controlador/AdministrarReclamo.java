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
    private final String URI_ADMIN_REC = "WEB-INF/pages/admin/EditarReclamo.jsp";
    private ReclamoDAO recdao;
    //ReclamoDTO rec = new ReclamoDTO();
   
    int ide;
    
    
    public void init()throws ServletException{
        this.recdao= new ReclamoDAO();
    }
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
                break;
                
            case "delete":
                ide=Integer.parseInt(request.getParameter("idReclamo"));
                recdao.eliminar(ide);
                request.getRequestDispatcher("administrar?accion=listar").forward(request, response);         
                break;    
        }
        
        
    }

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
            case "update":
                ide=Integer.parseInt(request.getParameter("idReclamo"));
                recl = recdao.getReclamo(ide);
                cargarReclamosegunParams(recl, request);
                recdao.actualizar(recl);      
                request.getRequestDispatcher("administrar?accion=listar").forward(request, response);
                break;
                
            case "add":
                recl=new ReclamoDTO();
                cargarReclamosegunParams(recl, request);
                recdao.agregar(recl);
                
                break;
        }        
        //doGet(request, response);
    }

    
    
    private void cargarReclamosegunParams(ReclamoDTO rec, HttpServletRequest request) {
        
        rec.setFechaCreacion(request.getParameter("txtFechaCreacion"));
        rec.setFechaResolucion(request.getParameter("txtFechaResolucion"));
        rec.setDomicilio(request.getParameter("txtDomicilio"));
        
         
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
