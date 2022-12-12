package com.proyecto.clinicav3.service.impl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.clinicav3.dto.OdontologoDTO;
import com.proyecto.clinicav3.dto.PacienteDTO;
import com.proyecto.clinicav3.modelo.Odontologo;
import com.proyecto.clinicav3.modelo.Paciente;
import com.proyecto.clinicav3.repository.OdontologoRepository;
import com.proyecto.clinicav3.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OdontologoServiceImpl implements OdontologoService {

    @Autowired
    ObjectMapper mapper;
    private final OdontologoRepository odontologoRepository;

    public OdontologoServiceImpl(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }


    @Override
    public Odontologo crear(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    @Override
    public Odontologo buscarOdontologo(Long id) {
        return odontologoRepository.findById(id).orElse(null);
    }

    @Override
    public Set<OdontologoDTO> obtenerOdontologos() {
        List<Odontologo> odontologos=odontologoRepository.findAll();
        Set<OdontologoDTO> odontologosDTO=new HashSet<>();
        for (Odontologo odontologo: odontologos) {
            odontologosDTO.add(mapper.convertValue(odontologo,OdontologoDTO.class));
        }

        return odontologosDTO;
    }

    @Override
    public void modificarOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapper.convertValue(odontologoDTO,Odontologo.class);
        odontologoRepository.save(odontologo);
    }

    @Override
    public void eliminarOdontologo(Long id) {
        odontologoRepository.deleteById(id);

    }
}
