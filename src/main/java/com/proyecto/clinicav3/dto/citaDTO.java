package com.proyecto.clinicav3.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class citaDTO {

    private Long id;
    private String detalleCita;
    private String fechaCita;
    private String nombreOdontologo;

    private String nombrePaciente;

    public citaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetalleCita() {
        return detalleCita;
    }

    public void setDetalleCita(String detalleCita) {
        this.detalleCita = detalleCita;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getNombreOdontologo() {
        return nombreOdontologo;
    }

    public void setNombreOdontologo(String nombreOdontologo) {
        this.nombreOdontologo = nombreOdontologo;
    }
}
