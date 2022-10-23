package com.leonel.reclamo_municipio.modelo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersonaDAO {
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/reclamo_municipio";
    private static final String USER = "root";
    private static final String PASS = "1809";
    
//    public PersonaDTO Validar(String user, String password){
//        PersonaDTO pers=new PersonaDTO();
//        //String sql = "SELECT * FROM usuario";
//        //PreparedStatement ps = con.prepareStatement("SELECT * FROM usuario");
//        try {
//            //Connection con= conectorBBDD.getConexion(DRIVER, URL, USER, PASS);
//            Connection con = Conexion_defaa.getConexion(DRIVER, URL, USER, PASS);
//            
//            PreparedStatement ps = con.prepareStatement("SELECT * FROM usuario where ");
//            ResultSet rs = ps.executeQuery();
//            // where user=? and password=?CONECTAR  BBDd>> TRY CATCH
//            
////
//            //ps.setString(1, id_user);
//            ps.setString(1, user);
//            ps.setString(2, password);
//            //ps.setString(4, tipoUsuario);
//            ResultSet rs = ps.executeQuery();
//            
//            while (rs.next()) {
////                int idUs=rs.getInt();
////                String us = rs.getString(2);
////                String pass = rs.getString(3);
////                String t_User=rs.getString("user");
//                pers.setId_user(rs.getInt("Id_user"));
//                pers.setUser(rs.getString("user"));
//                pers.setPassword(rs.getString("password"));
//                pers.setTipoUsuario(rs.getString("tipoUsuario"));
//           // }    
//            }
//          
//        } catch (SQLException ex) {
//            throw new RuntimeException("Erros al obtener ACCESO USER-PASSWORD", ex);
//        }
//
//      return pers; 
//    }

   
    
    
//    public Collection<CarreraDTO> obtenerCarreras()  {
//        Collection<CarreraDTO> carreras = new ArrayList<CarreraDTO>();
//        try {
//            Connection con = Conexion_defaa.getConexion(DRIVER, URL, USER, PASS);
//            
//            PreparedStatement ps = con.prepareStatement("SELECT * FROM carreras");
//            ResultSet rs = ps.executeQuery();
//            
//            while (rs.next()) {
//                int cod = rs.getInt(1);//CODIGO
//                String nom = rs.getString(2);//NOMBRE
//                CarreraDTO carrera = new CarreraDTO(cod, nom);
//                carreras.add(carrera);
//            }
//        } catch (SQLException ex) {
//            throw new RuntimeException("Error al obtener carreras", ex);
//        }
//        return carreras;
//    }
}
