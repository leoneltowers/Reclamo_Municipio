package com.leonel.reclamo_municipio.modelo;

public class PersonaDTO {

    private int idPersona;
    private String dni;
    private String nombre;
    private String apellido;
    private String mail;
    private String telefonoMovil;
    private UsuarioDTO ususario;

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

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public UsuarioDTO getUsusario() {
        return ususario;
    }

    public void setUsusario(UsuarioDTO ususario) {
        this.ususario = ususario;
    }
    
    
    
}
