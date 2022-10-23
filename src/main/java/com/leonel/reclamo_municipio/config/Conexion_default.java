///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.leonel.reclamo_municipio.config;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
///**
// *
// * @author Leonel_Towers
// */
//public class Conexion_defaa {
//    Connection con;
//    String URL = "jdbc:mysql://localhost:3306/reclamo_municipio";
//    String USER = "root";
//    String PASS = "1809";
//
//  
//    public  Connection Conexion() {
//        //Connection con = null;
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            con = DriverManager.getConnection(URL, USER, PASS);
//        } catch (ClassNotFoundException | SQLException e) {
//            System.out.println("Error de Conexion a Base de Datos : " + e);
//        }
//    return con;
//    }
//}
