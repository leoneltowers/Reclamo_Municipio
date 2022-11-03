/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leonel.reclamo_municipio.modelo;

import com.leonel.reclamo_municipio.config.Conexion;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Leonel_Towers
 */
public abstract  class UsuarioDTO implements Serializable{
    private int id_user;
    private String user;
    private String password;
    private String tipoUsuario;

    public UsuarioDTO() {
    }

    public UsuarioDTO(int id_user, String user, String password, String tipoUsuario) {
        this.id_user = id_user;
        this.user = user;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    public abstract String getVista();
     
}
