/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.leonel.reclamo_municipio.controlador;

import com.leonel.reclamo_municipio.modelo.Contribuyente;
import com.leonel.reclamo_municipio.modelo.PersonaDAO;
import com.leonel.reclamo_municipio.modelo.PersonaDTO;
import com.leonel.reclamo_municipio.modelo.ReclamoDTO;
import com.leonel.reclamo_municipio.modelo.Modelo_Loggin;
import com.leonel.reclamo_municipio.modelo.UsuarioDTO;
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
public class Registrarse extends HttpServlet {

    private final String URI_REGISTER = "WEB-INF/pages/loggin/Registrarse.jsp";
    
    private Modelo_Loggin modeloLogin;//Cambiar a modelo login tiene a modeloLogin dao personadao
   
    
    public void init() throws ServletException{
    this.modeloLogin = new Modelo_Loggin();
    }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
         String accion=request.getParameter("accion");
      
        accion = accion == null ? "" : accion;
        
        switch (accion) {
            case "register":
                
                request.getRequestDispatcher(URI_REGISTER).forward(request, response);
                break;
           
            default:
                request.getRequestDispatcher("index.jsp").forward(request, response);    
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
            case "registrarse":
                pers = new PersonaDTO();
                cargarPersonaSegunParams(pers, request);
                modeloLogin.agregarPersona(pers);//crear modelo loggin default usuariodao
                UsuarioDTO us=null;
                us = new Contribuyente();
                cargarUsuarioSegunParams(us, request);
                modeloLogin.agregarUsuario(us);
                break;
            
        }
        
        doGet(request, response);
    }
    
    

    private void cargarPersonaSegunParams(PersonaDTO per, HttpServletRequest request) {
        per.setDni(request.getParameter("dni"));
        per.setNombre(request.getParameter("nombre"));
        per.setApellido(request.getParameter("apellido"));
        per.setMail(request.getParameter("email"));
        per.setTelefonoMovil(request.getParameter("telefono"));
    }    
        
   
    private void cargarUsuarioSegunParams(UsuarioDTO us, HttpServletRequest request) {
        us.setUser(request.getParameter("usuario"));
        us.setPassword(request.getParameter("password"));
        us.setTipoUsuario("contribuyente");//al igresar mucha palabra se rompe
    }
    
@Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}
