package com.proyecto.clinicav3.service;

import com.proyecto.clinicav3.dto.OdontologoDTO;
import com.proyecto.clinicav3.modelo.Odontologo;

import java.util.Set;

public interface OdontologoService {


    Odontologo crear(Odontologo odontologo);

    Odontologo buscarOdontologo(Long id);

    Set<OdontologoDTO> obtenerOdontologos();

    void modificarOdontologo(OdontologoDTO odontologoDTO);

    void eliminarOdontologo(Long id);
}
