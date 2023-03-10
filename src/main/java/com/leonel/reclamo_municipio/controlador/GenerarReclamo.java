/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.leonel.reclamo_municipio.controlador;


import com.leonel.reclamo_municipio.modelo.CategoriaDTO;
import com.leonel.reclamo_municipio.modelo.Modelo;
import com.leonel.reclamo_municipio.modelo.ReclamoDAO;
import com.leonel.reclamo_municipio.modelo.ReclamoDTO;
import com.leonel.reclamo_municipio.modelo.Modelo_Loggin;
import com.leonel.reclamo_municipio.modelo.UsuarioDTO;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "GenerarReclamo", urlPatterns = {"/generar"})
public class GenerarReclamo extends HttpServlet {
    private ReclamoDAO recdao; 
    private final String URI_INGRESAR = "WEB-INF/pages/contribuyente/Contribuyente.jsp";
    private final String URI_GENERAR = "WEB-INF/pages/contribuyente/GenerarReclamo.jsp";
   // ReclamoDTO rec = new ReclamoDTO();
    //UsuarioDTO us = new UsuarioDTO();//probando validar2
    
   
  
    
    
    public void init()throws ServletException{
        this.recdao= new ReclamoDAO();
    }
    
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
        String accion = request.getParameter("accion");
        accion = accion == null ? "" : accion;
        ReclamoDTO recl = null;
        switch (accion) {
            case "ver":
                request.getRequestDispatcher(URI_GENERAR).forward(request, response);
              
                break;
            case "listar":
                //ide=rec.getIdReclamo();
                int ide = 0;
                ide=Integer.parseInt(request.getParameter("id_user"));
                List lista=recdao.listarReclamoXId(ide);
                request.setAttribute("listarReclamos", lista);
                request.getRequestDispatcher(URI_GENERAR).forward(request, response);
          
                break;
            default:
                request.getRequestDispatcher(URI_GENERAR).forward(request, response); 

     
        }
        doGet(request, response);
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
        ReclamoDTO rec;
        CategoriaDTO cat;
        accion = accion == null ? "" : accion;
        switch (accion) {

            case "agregarReclamo":
                String fechaCreacion = request.getParameter("txtFecha");
                String domicilio = request.getParameter("txtDomicilio");
                String categ = request.getParameter("txtCategoria");
                String des = request.getParameter("txtDescripcion");
//                int ide=0;
//                ide= Integer.parseInt(request.getParameter("id_user"));//ES null no llega para agregar en idper
//                
                
                rec = new ReclamoDTO();
                rec.setFechaCreacion(fechaCreacion);
                rec.setDomicilio(domicilio);
                rec.setCategoria(categ);
                rec.setDescripcion(des);
                rec.setId_Persona(1);//pendiente
                
                recdao.agregar(rec);
                
                
                request.getRequestDispatcher("generar?accion=listar");
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
