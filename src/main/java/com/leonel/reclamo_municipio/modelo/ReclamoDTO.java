package com.leonel.reclamo_municipio.modelo;

public class ReclamoDTO {

    private int idReclamo;
    private String fechaCreacion;
    private String fechaResolucion;
    private String Domicilio;

    public ReclamoDTO() {
    }

    public ReclamoDTO(int idReclamo, String fechaCreacion, String fechaResolucion, String Domicilio) {
        this.idReclamo = idReclamo;
        this.fechaCreacion = fechaCreacion;
        this.fechaResolucion = fechaResolucion;
        this.Domicilio = Domicilio;
    }
    
}
