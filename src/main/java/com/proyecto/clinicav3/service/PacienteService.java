package com.proyecto.clinicav3.service;
import com.proyecto.clinicav3.dto.PacienteDTO;
import com.proyecto.clinicav3.modelo.Paciente;

import java.util.*;

public interface PacienteService {

    Paciente crear(Paciente paciente);

    Paciente buscarPaciente(Long id);

    Set<PacienteDTO> obtenerPacientes();

    void modificarPaciente(PacienteDTO pacienteDTO);

    void eliminarPaciente(Long id);


}
