/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leonel.reclamo_municipio.modelo;

import com.leonel.reclamo_municipio.config.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import com.mysql.cj.PreparedQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Leonel_Towers
 */
//DRIVER CONEXXION SIN cj --com.mysql.cj.jdbc.Driver
public class Modelo_Loggin {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/reclamo_municipio?useSSL=false&useTimezone=true&serverTimezone=UTC";//?serverTimezone=UTC
    private static final String USER = "root";
    private static final String PASS = "1809";
    private ActionListener listener;
    
    
    
    public UsuarioDTO Validar(String user, String password){   
        UsuarioDTO usdto = null;
       
        try {
            Connection con = Conexion.getConexion(DRIVER, URL, USER, PASS);
            
            PreparedStatement ps = con.prepareStatement("SELECT * FROM usuario where user=? and password=?");// where where user=? and password=?
            ps.setString(1, user);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery(); 
      
            if (rs.next()) {
                /** @TODO: Agregar Factory **/
                switch (rs.getString("tipoUsuario")) {
                    case "administrador":
                        usdto = new Administrador(rs.getInt(1), user, password, rs.getString("tipoUsuario"));
                        
                        break;
                    case "contribuyente":
                        usdto = new Contribuyente(rs.getInt(1),user,password, rs.getString("tipoUsuario"));   
                      
                       break;
                }
             
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener ACCESO USER-PASSWORD");
        }
    
        return usdto;
    }
    

 
    
    
    /*
    public UsuarioDTO Validar1(String user, String password){
        UsuarioDTO usdto = new UsuarioDTO() {
            @Override
            public String getVista() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        try {
            Connection con = Conexion.getConexion(DRIVER, URL, USER, PASS);
            
            PreparedStatement ps = con.prepareStatement("SELECT * FROM usuario where user=? and password=?");// where where user=? and password=?
            ps.setString(1, user);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery(); 
                               
            while (rs.next()) {
                usdto.setId_user(rs.getInt("id_user"));
                usdto.setUser(rs.getString("user"));
                usdto.setPassword(rs.getString("password"));
                usdto.setTipoUsuario(rs.getString("tipoUsuario"));
                           
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener ACCESO USER-PASSWORD");
        }
    
        return usdto;
    }*/
    

    //--------------------CREAR USUARIO UNION MYSQL-------------//
    
    public int createUsuario(PersonaDTO pers, UsuarioDTO us){
        int regtsAgr = 0;
        String sql = "INSERT INTO personas (dni,nombre,apellido,mail,telefonoMovil) VALUES (?,?,?,?,?);";
        String sql1 ="INSERT INTO usuario (user,password,tipoUsuario) VALUES (?,?,?);";
        try{
           Connection con = Conexion.getConexion(DRIVER, URL, USER, PASS);
           
            PreparedStatement ps = con.prepareStatement(sql);
            fillPreparedStatemente(ps, pers);
            ps.executeUpdate();
            PreparedStatement psS = con.prepareStatement(sql1);
            fillPreparedStatement(ps, us);
   
            psS.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al crear persona-usuario");
        }
        return regtsAgr;
    }
    ///aux--abajo version ant
       private void fillPreparedStatemente(PreparedStatement ps, PersonaDTO pers)throws SQLException {
         ps.setString(1, pers.getDni());
         ps.setString(2, pers.getNombre());
         ps.setString(3, pers.getApellido());
         ps.setString(4, pers.getMail());
         ps.setString(5, pers.getTelefonoMovil()); 
         ///ps.setString(6,pers.getUsusario());// creo dos fill
    } 
    
    //--------------------Crear Usuario-------------//
    
    public int agregarUsuario(UsuarioDTO us){
        int regtsAgr = 0;
        String sql = "INSERT INTO usuario (user,password,tipoUsuario) VALUES (?,?,?)";
        try{
           Connection con = Conexion.getConexion(DRIVER, URL, USER, PASS);
           
            PreparedStatement ps = con.prepareStatement(sql);
            fillPreparedStatement(ps, us); 
   
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al crear usuario");
        }
        return regtsAgr;
    }
    
    
    
    
    private void fillPreparedStatement(PreparedStatement ps, UsuarioDTO use)throws SQLException {
         ps.setString(1, use.getUser());//esto con el q recibe por parametro se pisan///
         ps.setString(2, use.getPassword());
         ps.setString(3, use.getTipoUsuario());
         
    }
    
    
    
    //---------------------persona--------------------
    public int agregarPersona (PersonaDTO pers){
        int regtsAgr = 0;
        String sql = "INSERT INTO personas (dni,nombre,apellido,mail,telefonoMovil) VALUES (?,?,?,?,?);";//consulta union
        try{
           Connection con = Conexion.getConexion(DRIVER, URL, USER, PASS);
           
            PreparedStatement ps = con.prepareStatement(sql);
            fillPreparedStatemente(ps, pers); 
            
//            ps.setString(1, pers.getDni());
//            ps.setString(2, pers.getNombre());
//            ps.setString(3, pers.getApellido());
//            ps.setString(4, pers.getMail());
//            ps.setString(5, pers.getTelefonoMovil());
            
            
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al agregar persona??");
        }
        return regtsAgr;
    }
    
    
    
//    private void fillPreparedStatement(PreparedStatement ps, PersonaDTO pers)throws SQLException {
//         ps.setString(1, pers.getDni());
//         ps.setString(2, pers.getNombre());
//         ps.setString(3, pers.getApellido());
//         ps.setString(4, pers.getMail());
//         ps.setString(5, pers.getTelefonoMovil()); 
//    }
    
}
