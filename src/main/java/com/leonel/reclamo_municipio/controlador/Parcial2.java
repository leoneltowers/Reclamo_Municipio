/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.leonel.reclamo_municipio.controlador;

import com.leonel.reclamo_municipio.modelo.Modelo;
import com.leonel.reclamo_municipio.modelo.UsuarioDAO;
import com.leonel.reclamo_municipio.modelo.UsuarioDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leonel_Towers
 */
@WebServlet(name = "Parcial2", urlPatterns = {"/parcial2"})
public class Parcial2 extends HttpServlet {
    
    private final String URI_CONT= "WEB-INF/pages/contribuyente/Contribuyente.jsp";
    private final String URI_ADMIN = "WEB-INF/pages/admin/Administrador.jsp";
    private final String URI_401 = "WEB-INF/pages/error401.jsp";
    private final String CONT = "contribuyente";
    private final String ADMIM = "administrador";

    
    private UsuarioDAO usdao;
    //UsuarioDTO us = new UsuarioDTO();
    
    public void init()throws ServletException{
        this.usdao= new UsuarioDAO();
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
        
        
        String accion=request.getParameter("accion");
        UsuarioDTO us;
        
        if(accion.equalsIgnoreCase("VER RECLAMOS")){
            String id=request.getParameter("id_user");
            String user=request.getParameter("txtuser");
            String pass=request.getParameter("txtpass");
          
           us=usdao.Validar(user, pass);
           
           
           
           
           
            if(us.getUser()!=null){
               request.setAttribute("usuario", us);
                if( us.getTipoUsuario().equalsIgnoreCase(CONT)){
                request.getRequestDispatcher(URI_CONT).forward(request, response);
                 }else if (us.getTipoUsuario().equalsIgnoreCase(ADMIM)){
                 request.getRequestDispatcher(URI_ADMIN).forward(request, response);  
                 } 
                 }else { 
                request.getRequestDispatcher(URI_401).forward(request, response);
                      }
                     
        }else{
            request.getRequestDispatcher(URI_401).forward(request, response);
        }
   
        
    }
    
    
    
    
   ///
    
    

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
