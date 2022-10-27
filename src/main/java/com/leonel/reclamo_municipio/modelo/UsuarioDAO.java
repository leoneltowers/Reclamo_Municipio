/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leonel.reclamo_municipio.modelo;

import com.leonel.reclamo_municipio.config.Conexion;

//import com.mysql.cj.PreparedQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Leonel_Towers
 */
//DRIVER CONEXXION SIN cj --com.mysql.cj.jdbc.Driver
public class UsuarioDAO {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/reclamo_municipio?useSSL=false&useTimezone=true&serverTimezone=UTC";//?serverTimezone=UTC
    private static final String USER = "root";
    private static final String PASS = "1809";
    
    public UsuarioDTO Validar(String user, String password){
        UsuarioDTO us = new UsuarioDTO();
        try {
            Connection con = Conexion.getConexion(DRIVER, URL, USER, PASS);
            
            PreparedStatement ps = con.prepareStatement("SELECT * FROM usuario where user=? and password=?");// where where user=? and password=?
            ps.setString(1, user);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
                               
            while (rs.next()) {
//                           
//                us.setId_user(rs.getInt(1));
//                us.setUser(rs.getString(2));
//                us.setPassword(rs.getString(3));                
//                us.setTipoUsuario(rs.getString(4));
                  us.setId_user(rs.getInt("id_user"));
                  us.setUser(rs.getString("user"));
                  us.setPassword(rs.getString("password"));
                  us.setTipoUsuario(rs.getString("tipoUsuario"));
//         
                           
            }
          
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener ACCESO USER-PASSWORD");
        }
    
      
        return us;
    }
    
  
    
    
}
