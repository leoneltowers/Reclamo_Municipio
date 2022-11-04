/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.leonel.reclamo_municipio.controlador;

import com.leonel.reclamo_municipio.modelo.Modelo;
import com.leonel.reclamo_municipio.modelo.Modelo_Loggin;
import com.leonel.reclamo_municipio.modelo.UsuarioDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "Parcial2", urlPatterns = {"/parcial2"})
public class Parcial2 extends HttpServlet {
    
    private final String URI_CONT= "WEB-INF/pages/contribuyente/Contribuyente.jsp";
    private final String URI_ADMIN = "WEB-INF/pages/admin/Administrador.jsp";
    private final String URI_401 = "WEB-INF/pages/error401.jsp";
    private final String CONT = "contribuyente";
    private final String ADMIM = "administrador";

    
    private Modelo_Loggin usdao;
    
    
    public void init()throws ServletException{
        this.usdao= new Modelo_Loggin();
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
        //ver si dejarlo aca o pasarlo A PROCES REQUEST
        
        String accion=request.getParameter("accion");
        UsuarioDTO us;
        
        if(accion.equalsIgnoreCase("VER RECLAMOS")){
            //String id=request.getParameter("id_user");
            String user=request.getParameter("txtuser");
            String pass=request.getParameter("txtpass");
            us=usdao.Validar(user, pass);
        
          
            try {
                request.setAttribute("usuario", us); 
                request.getRequestDispatcher(us.getVista()).forward(request, response);
               
            } catch (NullPointerException ex) {
            request.getRequestDispatcher(URI_401).forward(request, response);
            } finally {
            request.getRequestDispatcher("index.jsp").forward(request, response);
            }
          }
       
    }
    
    
    //if(us.getUser()!=null){    //}
            ///   if(us.getUser()!=null){
//           request.setAttribute("usuario", us);    
//          request.getRequestDispatcher(us.getVista()).forward(request, response);
//           }else{request.getRequestDispatcher(URI_401).forward(request, response);}
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
