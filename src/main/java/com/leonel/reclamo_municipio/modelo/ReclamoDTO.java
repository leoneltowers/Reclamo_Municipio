package com.leonel.reclamo_municipio.modelo;

import java.io.Serializable;

public class ReclamoDTO  {//implements Serializable

    private int idReclamo;
    private String fechaCreacion;
    private String fechaResolucion;
    private String Domicilio;
    private int idPersona;
    

    public ReclamoDTO() {
    }

    public ReclamoDTO(int idReclamo, String fechaCreacion, String fechaResolucion, String Domicilio, int idPersona) {
        this.idReclamo = idReclamo;
        this.fechaCreacion = fechaCreacion;
        this.fechaResolucion = fechaResolucion;
        this.Domicilio = Domicilio;
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

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
    
    
    
}
