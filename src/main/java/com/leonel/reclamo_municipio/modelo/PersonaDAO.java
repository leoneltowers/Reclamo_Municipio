package com.leonel.reclamo_municipio.modelo;


import com.leonel.reclamo_municipio.config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonaDAO {
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/reclamo_municipio";
    private static final String USER = "root";
    private static final String PASS = "1809";
    
    
    public int agregar (PersonaDTO pers){
        int regtsAgr = 0;
        String sql = "INSERTAR INTO personas VALUES(null,?,?,?,?,?";//(fechaCreacion, fechaResolucion, domicilio) 
        try{
           Connection con = Conexion.getConexion(DRIVER, URL, USER, PASS);
            
            PreparedStatement ps = con.prepareStatement(sql);// where where user=? and password=?
            ResultSet rs = ps.executeQuery();
            ps.setString(1, pers.getDni());
            ps.setString(2, pers.getNombre());
            ps.setString(3, pers.getApellido());
            ps.setString(4, pers.getMail());
            ps.setString(5, pers.getTelefonoMovil());
            regtsAgr=ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al agregar persona");
        }
        return regtsAgr;
    }
    

    
}
