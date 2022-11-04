/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leonel.reclamo_municipio.modelo;

/**
 *
 * @author Leonel_Towers
 */
public class CategoriaDTO {
    private int idCat;
    private String nombre;

    public CategoriaDTO() {
    }

    public CategoriaDTO(int idCat, String nombre) {
        this.idCat = idCat;
        this.nombre = nombre;
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
