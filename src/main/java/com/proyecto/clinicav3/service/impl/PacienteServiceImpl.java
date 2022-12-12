package com.proyecto.clinicav3.service.impl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.clinicav3.dto.PacienteDTO;
import com.proyecto.clinicav3.modelo.Paciente;
import com.proyecto.clinicav3.repository.PacienteRepository;
import com.proyecto.clinicav3.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    ObjectMapper mapper;

    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente crear(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }
    @Override
    public Paciente buscarPaciente(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }
    @Override
    public Set<PacienteDTO> obtenerPacientes() {
       List<Paciente> pacientes=pacienteRepository.findAll();
       Set<PacienteDTO> pacientesDTO=new HashSet<>();
        for (Paciente paciente: pacientes) {
            pacientesDTO.add(mapper.convertValue(paciente,PacienteDTO.class));
        }

        return pacientesDTO;
    }

    @Override
    public void modificarPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO,Paciente.class);
        pacienteRepository.save(paciente);
    }

    @Override
    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }


}
