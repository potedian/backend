package com.proyecto.clinicav3.modelo;

import javax.persistence.*;

import com.proyecto.clinicav3.modelo.Paciente;

@Entity
@Table(name = "cita")
public class Cita {

//Registrar turno: se tiene que poder permitir asignar a un paciente un turno con
//un odontólogo a una determinada fecha y hora.
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String detalleCita;
private String fechaCita;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="id_odontologo",referencedColumnName = "id")
private Odontologo odontologo;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="id_paciente",referencedColumnName = "id")
private Paciente paciente;

 public Cita(Long id, String detalleCita, String fechaCita, Odontologo odontologo, Paciente paciente) {
  this.id = id;
  this.detalleCita = detalleCita;
  this.fechaCita = fechaCita;
  this.odontologo = odontologo;
  this.paciente = paciente;
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

 public Odontologo getOdontologo() {
  return odontologo;
 }

 public void setOdontologo(Odontologo odontologo) {
  this.odontologo = odontologo;
 }

 public Paciente getPaciente() {
  return paciente;
 }

 public void setPaciente(Paciente paciente) {
  this.paciente = paciente;
 }
}
