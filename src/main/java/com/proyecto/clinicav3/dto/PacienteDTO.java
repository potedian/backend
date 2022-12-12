package com.proyecto.clinicav3.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteDTO {

private String nombre;
private String apellido;

private String domicilio;


    public PacienteDTO() {
    }

    public PacienteDTO(String nombre, String apellido,String domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
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

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
}
