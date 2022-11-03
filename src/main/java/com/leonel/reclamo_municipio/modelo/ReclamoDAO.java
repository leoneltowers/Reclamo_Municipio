package com.leonel.reclamo_municipio.modelo;

import com.leonel.reclamo_municipio.config.Conexion;
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
            throw new RuntimeException("Error al obtener reclamos");
        }
        return lista;
    }
    
    public int agregar (ReclamoDTO rec){
        int regtsAgr = 0;
        String sql = "INSERT INTO reclamos (fechaCreacion,domicilio) VALUES(?,?);";//(fechaCreacion, fechaResolucion, domicilio) 
        try{
           Connection con = Conexion.getConexion(DRIVER, URL, USER, PASS);
            
            PreparedStatement ps = con.prepareStatement(sql);// where where user=? and password=?
            
            ps.setString(1, rec.getFechaCreacion());
            //ps.setString(1, rec.getFechaResolucion());
            ps.setString(2, rec.getDomicilio());
            
          ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al agregar reclamos");
        }
        return regtsAgr;
    }
    
    public int actualizar (ReclamoDTO reclamo){
        int reclModificados=0;
        //String sql = "UPDATE reclamos SET fechaCreacion=?, fechaResolucion=?,domicilio=? WHERE idReclamo=?";//(fechaCreacion, fechaResolucion, domicilio) 
        try( Connection con = Conexion.getConexion(DRIVER, URL, USER, PASS); PreparedStatement ps = con.prepareStatement("UPDATE reclamos SET fechaCreacion=?, fechaResolucion=?,domicilio=? WHERE idReclamo=?")){//here where user=? and password=?
            fillPreparedStatement(ps, reclamo);
            ps.setInt(4, reclamo.getIdReclamo());
            reclModificados=ps.executeUpdate();
        }catch(SQLException ex){
           throw new RuntimeException("Error SQL",ex);
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar reclamos", e);
        }
        return reclModificados;
    }
    
    public void eliminar (int id){
        String sql = "DELETE FROM reclamos where idReclamo=?";//aCreacion, fechaResolucion, domicilio) 
        try{
           Connection con = Conexion.getConexion(DRIVER, URL, USER, PASS);
                       
            PreparedStatement ps = con.prepareStatement(sql);// where where user=? and password=?
           ps.setInt(1, id);
            ps.executeUpdate();
          
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar");
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
          
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener reclamos");
        }
        return rec;
    }
    
    
    private void fillPreparedStatement(PreparedStatement ps, ReclamoDTO reclamo)throws SQLException {
         ps.setString(1, reclamo.getFechaCreacion());
         ps.setString(2, reclamo.getFechaResolucion());
         ps.setString(3, reclamo.getDomicilio());  
    }
    //--------------CONTRIBUYENTE-------------------/
    
    public List listarReclamoXId(int id){
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
                rec.setId_persona_user(rs.getInt(5));
                if(id==rs.getInt(5)){//VER SI LO COMPARO IDPERSONA
                lista.add(rec);
                }
                
            }
          
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener reclamos");
        }
        return lista;
    }
       
}
