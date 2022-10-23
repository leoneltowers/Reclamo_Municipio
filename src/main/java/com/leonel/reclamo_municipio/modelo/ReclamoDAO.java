package com.leonel.reclamo_municipio.modelo;

import com.leonel.reclamo_municipio.config.Conexion;
import com.leonel.reclamo_municipio.modelo.ReclamoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReclamoDAO {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/reclamo_municipio?useSSL=false&useTimezone=true&serverTimezone=UTC";//?serverTimezone=UTC
    private static final String USER = "root";
    private static final String PASS = "1809";
    private int resp;
    
    public List listar(){
        List<ReclamoDTO>lista = new ArrayList<>();
        try {
            Connection con = Conexion.getConexion(DRIVER, URL, USER, PASS);
            
            PreparedStatement ps = con.prepareStatement("SELECT * FROM reclamos");// where where user=? and password=?
            ResultSet rs = ps.executeQuery();
                               
            while (rs.next()) {
                ReclamoDTO rec = new ReclamoDTO();
                rec.setIdReclamo(rs.getInt(1));
                rec.setFechaCreacion(rs.getString(2));
                rec.setFechaResolucion(rs.getString(3));
                rec.setDomicilio(rs.getString(4));
                lista.add(rec);
            }
          
        } catch (SQLException e) {
            throw new RuntimeException("Erros al obtener reclamos");
        }
        return lista;
    }
    
    public int agregar (ReclamoDTO rec){
        String sql = "insert into reclamos (fechaCreacion, fechaResolucion, domicilio) values(?,?,?))";
        try{
           Connection con = Conexion.getConexion(DRIVER, URL, USER, PASS);
            
            PreparedStatement ps = con.prepareStatement(sql);// where where user=? and password=?
            ResultSet rs = ps.executeQuery();
            ps.setString(1, rec.getFechaCreacion());
            ps.setString(1, rec.getFechaResolucion());
            ps.setString(1, rec.getDomicilio());
          
        } catch (SQLException e) {
            throw new RuntimeException("Erros al obtener/agregar reclamos");
        }
        
    return resp;
    }
    
    
    
}
