/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.leonel.reclamo_municipio.controlador;


import com.leonel.reclamo_municipio.modelo.Modelo;
import com.leonel.reclamo_municipio.modelo.UsuarioDAO;
import com.leonel.reclamo_municipio.modelo.UsuarioDTO;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;
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
//    PersonaDAO persdao = new PersonaDAO();
//    PersonaDTO pers = new PersonaDTO();
    UsuarioDAO usdao= new UsuarioDAO();
    UsuarioDTO us = new UsuarioDTO();
    
    private Modelo modelo; 
    private final String URI_CONT= "Contribuyente.jsp";
    private final String URI_ADMIN = "Administrador.jsp";
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
    
    public void init()throws ServletException{
        this.modelo= new Modelo();
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
       
    //request.setAttribute("listaReclamos", modelo.getReclamos());
//    request.getRequestDispatcher(URI_CONT).forward(request, response);
    
    
    

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
        //processRequest(request, response);
        //      response.setContentType("text/html;charset=UTF-8");
        String accion=request.getParameter("accion");
        
        if(accion.equalsIgnoreCase("Ingresar")){
            String user=request.getParameter("txtuser");
            String pass=request.getParameter("txtpass");
            
            
           // pers=persdao.Validar(user, pass);
           us=usdao.Validar(user, pass);
           
            
            //if(us.getUser()!=null){
            if(us.getUser()!=null){
                
                request.setAttribute("usuario", us);
            
                if( us.getTipoUsuario().equalsIgnoreCase(CONT)){
                request.getRequestDispatcher(URI_CONT).forward(request, response);
                 }else if (us.getTipoUsuario().equalsIgnoreCase(ADMIM)){
                 request.getRequestDispatcher(URI_ADMIN).forward(request, response);  
                 } 
            }else { 
                request.getRequestDispatcher("index.jsp").forward(request, response);
                        }
            
        //en caso de no validar se devuelve a index          
        }else{
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
   
    
    }
        
        
 }
    
    
    

        



    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
    
    
    

//}
