/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.leonel.reclamo_municipio.controlador;


import com.leonel.reclamo_municipio.modelo.Modelo;
import com.leonel.reclamo_municipio.modelo.ReclamoDAO;
import com.leonel.reclamo_municipio.modelo.ReclamoDTO;

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
@WebServlet(name = "GenerarReclamo", urlPatterns = {"/reclamos"})
public class GenerarReclamo extends HttpServlet {
    private Modelo modelo; 
    private final String URI_INGRESAR = "Contribuyente.jsp";
    private final String URI_RECLAMOS = "GenerarReclamo.jsp";
    
    ReclamoDTO rec = new ReclamoDTO();
    ReclamoDAO recdao = new ReclamoDAO();
    
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
        //request.getRequestDispatcher(URI_INGRESAR).forward(request, response);
        String accion = request.getParameter("accion");
        //String tipoModelo = request.getParameter("modelo");
        accion = accion == null ? "" : accion;
        switch (accion) {
            case "ver":
                request.getRequestDispatcher(URI_RECLAMOS).forward(request, response);
                
                //revisar luego sacar
                break;
            case "listar":
                List lista=recdao.listar();
                request.setAttribute("listarReclamos", lista);
                request.getRequestDispatcher(URI_RECLAMOS).forward(request, response);
                
                break;    
                
            case "agregar":
                String fechaCreacion = request.getParameter("txt")
                
                break;
     
        }
        //doGet(request, response);
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
        processRequest(request, response);
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
