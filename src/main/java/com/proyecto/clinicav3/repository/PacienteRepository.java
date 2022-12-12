package com.proyecto.clinicav3.repository;

import com.proyecto.clinicav3.modelo.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Long> {
/*
    @Query("SELECT j FROM Paciente j WHERE j.cita.odontologo.nombre = ?1")
    List<Paciente> recuperarPorNombreDeOdontologo(String nombreDeOdontologo);


 */
}
