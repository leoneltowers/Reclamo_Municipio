package com.leonel.reclamo_municipio.modelo;

public class PersonaDTO {

    private int idPersona;
    private String dni;
    private String nombre;
    private String apellido;
    private String mail;
    private String telefonoMovil;

    public PersonaDTO() {
    }

    public PersonaDTO(int idPersona, String dni, String nombre, String apellido, String mail, String telefonoMovil) {
        this.idPersona = idPersona;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.telefonoMovil = telefonoMovil;
    }
    
    
}
