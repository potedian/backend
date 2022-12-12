package com.proyecto.clinicav3.repository;

import com.proyecto.clinicav3.modelo.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo,Long> {
}
