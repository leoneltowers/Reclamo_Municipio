package com.leonel.reclamo_municipio.modelo;

import java.io.Serializable;

public class ReclamoDTO  {//implements Serializable

    private int idReclamo;
    private String fechaCreacion;
    private String fechaResolucion;
    private String Domicilio;
    private String categoria;
    private String descripcion;
    private int id_Persona;
    
    

    public ReclamoDTO() {
    }

    public ReclamoDTO(int idReclamo, String fechaCreacion, String fechaResolucion, String Domicilio, String categoria, String descripcion, int id_Persona) {
        this.idReclamo = idReclamo;
        this.fechaCreacion = fechaCreacion;
        this.fechaResolucion = fechaResolucion;
        this.Domicilio = Domicilio;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.id_Persona = id_Persona;
    }

    public int getIdReclamo() {
        return idReclamo;
    }

    public void setIdReclamo(int idReclamo) {
        this.idReclamo = idReclamo;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(String fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public String getDomicilio() {
        return Domicilio;
    }

    public void setDomicilio(String Domicilio) {
        this.Domicilio = Domicilio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_Persona() {
        return id_Persona;
    }

    public void setId_Persona(int id_Persona) {
        this.id_Persona = id_Persona;
    }

  

   
    
}
