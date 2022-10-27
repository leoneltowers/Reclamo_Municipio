/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.leonel.reclamo_municipio.controlador;

import com.leonel.reclamo_municipio.modelo.PersonaDAO;
import com.leonel.reclamo_municipio.modelo.PersonaDTO;
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
@WebServlet(name = "RegistroServlet", urlPatterns = {"/registrarUsuario"})
public class RegistroServlet extends HttpServlet {

    private final String URI_PERS = "RegistrarPersona.jsp";
    private PersonaDAO persona;
    
    public void init() throws ServletException{
    this.persona = new PersonaDAO();
    }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
         String accion=request.getParameter("accion");
      
        accion = accion == null ? "" : accion;
        
        switch (accion) {
            case "editPersona":
                
//                PersonaDTO persona = new PersonaDTO();
//                cargarPersonaSegunParams(persona, request);
//                persdao.agregar(persona);
                request.getRequestDispatcher(URI_PERS).forward(request, response);
                break;
                
            case "editUsuario":
                request.getRequestDispatcher(URI_PERS).forward(request, response);
                break;    
        }
      doGet(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PersonaDTO pers;
        
         String accion=request.getParameter("accion");
      
        accion = accion == null ? "" : accion;
        
        switch (accion) {
            case "agregarPersona":
                
                pers = new PersonaDTO();
                cargarPersonaSegunParams(pers, request);
                persona.agregarPersona(pers);
                //request.getRequestDispatcher(URI_PERS).forward(request, response);
                
//                String dni= request.getParameter("dni");
//                String nom=request.getParameter("nombre");
//                String ape=request.getParameter("apellido");
//                String email=request.getParameter("email");
//                String tel= request.getParameter("telefono");
//        
//                pers.setDni(dni);
//                pers.setNombre(nom);
//                pers.setApellido(ape);
//                pers.setMail(email);
//                pers.setTelefonoMovil(email);
                
                
                break;
        }
        
       
    }

    private void cargarPersonaSegunParams(PersonaDTO per, HttpServletRequest request) {
        per.setDni(request.getParameter("dni"));
        per.setNombre(request.getParameter("nom"));
        per.setApellido(request.getParameter("ape"));
        per.setMail(request.getParameter("email"));
        per.setTelefonoMovil(request.getParameter("tel"));
    }    
        
   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
}
