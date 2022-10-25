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
        String sql = "INSERTAR INTO reclamos VALUES(null,?,null,?))";//(fechaCreacion, fechaResolucion, domicilio) 
        try{
           Connection con = Conexion.getConexion(DRIVER, URL, USER, PASS);
            
            PreparedStatement ps = con.prepareStatement(sql);// where where user=? and password=?
            ResultSet rs = ps.executeQuery();
            ps.setString(1, rec.getFechaCreacion());
            //ps.setString(1, rec.getFechaResolucion());
            ps.setString(1, rec.getDomicilio());
            
          
        } catch (SQLException e) {
            throw new RuntimeException("Erros al obtener/agregar reclamos");
        }
        return resp;
    }
    
    public int actualizar (ReclamoDTO rec){
        int reclModificados=0;
        String sql = "UPTADE reclamos SET fechaCreacion=?, fechaResolucion=?,domicilio=? WHERE idReclamo=?";//(fechaCreacion, fechaResolucion, domicilio) 
        try( Connection con = Conexion.getConexion(DRIVER, URL, USER, PASS); PreparedStatement ps = con.prepareStatement(sql)){//where where user=? and password=?
           
            
            ps.setString(1, rec.getFechaCreacion());
            ps.setString(2, rec.getFechaResolucion());
            ps.setString(3, rec.getDomicilio());
            ps.setInt(4, rec.getIdReclamo());
            
            ps.executeUpdate();
        }catch(SQLException ex){
           throw new RuntimeException("Error SQL",ex);
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar reclamos", e);
        }
        return reclModificados;
    }
    
    public void eliminar (int id){
        String sql = "DELETE FROM reclamos where idReclamo="+id;//(fechaCreacion, fechaResolucion, domicilio) 
        try{
           Connection con = Conexion.getConexion(DRIVER, URL, USER, PASS);
            
            PreparedStatement ps = con.prepareStatement(sql);// where where user=? and password=?
            ps.executeUpdate();
          
        } catch (SQLException e) {
            throw new RuntimeException("Erros al obtener/agregar reclamos");
        }
        
    }
    
    
    public ReclamoDTO getReclamo(int id){
        ReclamoDTO rec= new ReclamoDTO();
        try {
            Connection con = Conexion.getConexion(DRIVER, URL, USER, PASS);
            
            PreparedStatement ps = con.prepareStatement("SELECT * FROM reclamos WHERE idReclamo=?");// where where user=? and password=?
            ps.setInt(1, id);
            
            try( ResultSet rs = ps.executeQuery()){
                rs.next();
                
                rec.setIdReclamo(rs.getInt(1));
                rec.setFechaCreacion(rs.getString(2));
                rec.setFechaResolucion(rs.getString(3));
                rec.setDomicilio(rs.getString(4));
                
                
            } catch (Exception e) {
                throw new RuntimeException("Error SQL", e);
            }
            
//                               
//            while (rs.next()) {
//                //rec.setIdReclamo(rs.getInt(1));
//                rec.setIdReclamo(rs.getInt(1));
//                rec.setFechaCreacion(rs.getString(2));
//                rec.setFechaResolucion(rs.getString(3));
//                rec.setDomicilio(rs.getString(4));
//                
//            }
          
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener reclamos");
        }
        return rec;
    }
    
    
    
    
}
