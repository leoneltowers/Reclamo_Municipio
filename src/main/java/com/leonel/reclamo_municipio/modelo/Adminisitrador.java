/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leonel.reclamo_municipio.modelo;

/**
 *
 * @author Leonel_Towers
 */
public class Adminisitrador extends UsuarioDTO{

    public Adminisitrador(int id_user, String user, String password, String tipoUsuario) {
        super(id_user, user, password, tipoUsuario);
    }

    
    public void iniciarSession(String tipoUsuario) {
    }
    

    
    
}
