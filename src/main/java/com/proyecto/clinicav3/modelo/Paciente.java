package com.proyecto.clinicav3.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "paciente")
public class Paciente {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido;
    private String domicilio;
    private String DNI;
    private String fecha_de_alta;

    @ManyToMany
    @JoinTable(
            name="cita",
            joinColumns = @JoinColumn(name = "id_paciente"),
            inverseJoinColumns = @JoinColumn (name = "id_odontologo")
    )
    @JsonIgnore
    private Set<Cita> citas=new HashSet<Cita>();

    public Paciente() {
    }

    public Paciente(Long id, String nombre, String apellido, String domicilio, String DNI, String fecha_de_alta) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.DNI = DNI;
        this.fecha_de_alta = fecha_de_alta;
    }
    public Paciente(String nombre, String apellido, String domicilio, String DNI, String fecha_de_alta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.DNI = DNI;
        this.fecha_de_alta = fecha_de_alta;
    }

    public long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDomicilio() {
        return this.domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getDNI() {
        return this.DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getFecha_de_alta() {
        return this.fecha_de_alta;
    }

    public void setFecha_de_alta(String fecha_de_alta) {
        this.fecha_de_alta = fecha_de_alta;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", DNI='" + DNI + '\'' +
                ", fecha_de_alta='" + fecha_de_alta + '\'' +
                '}';
    }
}
