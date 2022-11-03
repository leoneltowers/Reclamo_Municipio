/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.leonel.reclamo_municipio.controlador;


import com.leonel.reclamo_municipio.modelo.Modelo;
import com.leonel.reclamo_municipio.modelo.Modelo_Loggin;
import com.leonel.reclamo_municipio.modelo.UsuarioDTO;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leonel_Towers
 */
@WebServlet(name = "Login", urlPatterns = {"/validar"})
public class ValidarLoggin extends HttpServlet {

    private Modelo_Loggin usdao;
    //UsuarioDTO us = new UsuarioDTO();
    
    public void init()throws ServletException{
        this.usdao= new Modelo_Loggin();
    }
    
    private Modelo modelo; 
    private final String URI_CONT= "WEB-INF/pages/contribuyente/Contribuyente.jsp";
    private final String URI_ADMIN = "WEB-INF/pages/admin/Administrador.jsp";
    private final String CONT = "contribuyente";
    private final String ADMIM = "administrador";
    

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
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
        UsuarioDTO us;
        
        String accion=request.getParameter("accion");
        
        if(accion.equalsIgnoreCase("Ingresar")){
            String id=request.getParameter("id_user");
            String user=request.getParameter("txtuser");
            String pass=request.getParameter("txtpass");
          
           us=usdao.Validar(user, pass);
           RequestDispatcher vista = null;
           
           
            if(us.getUser()!=null){
                
                request.setAttribute("usuario", us);
                
               // vista = request.getRequestDispatcher(us.getVista());
              
            
                if( us.getTipoUsuario().equalsIgnoreCase(CONT)){
                request.getRequestDispatcher(URI_CONT).forward(request, response);
                 }else if (us.getTipoUsuario().equalsIgnoreCase(ADMIM)){
                 request.getRequestDispatcher(URI_ADMIN).forward(request, response);  
                 } 
            }else { 
                request.getRequestDispatcher("index.jsp").forward(request, response);
                        }
                     
        }else{
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
   
    
    }//cerraba el if
      
        
 }


