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
    PersonaDAO persdao = new PersonaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion=request.getParameter("accion");
      
        accion = accion == null ? "" : accion;
        
        switch (accion) {
            case "agregarPersona":
                
                PersonaDTO persona = new PersonaDTO();
                cargarPersonaSegunParams(persona, request);
                persdao.agregar(persona);
                request.getRequestDispatcher(URI_PERS).forward(request, response);
                break;
                
            case "agregarUsuario":
                request.getRequestDispatcher(URI_PERS).forward(request, response);
                break;    
        }
      doGet(request, response);
    }

    private void cargarPersonaSegunParams(PersonaDTO per, HttpServletRequest request) {
        per.setDni(request.getParameter("dni"));
        per.setNombre(request.getParameter("nom"));
        per.setApellido(request.getParameter("ape"));
        per.setMail(request.getParameter("mail"));
        per.setTelefonoMovil(request.getParameter("tel"));
    }    
        
   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
}
