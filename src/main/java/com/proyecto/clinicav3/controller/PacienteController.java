package com.proyecto.clinicav3.controller;

import com.proyecto.clinicav3.dto.PacienteDTO;
import com.proyecto.clinicav3.modelo.Paciente;
import com.proyecto.clinicav3.repository.PacienteRepository;
import com.proyecto.clinicav3.service.impl.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteServiceImpl pacienteService;
    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteController(PacienteServiceImpl pacienteService,
                              PacienteRepository pacienteRepository) {
        this.pacienteService = pacienteService;
        this.pacienteRepository = pacienteRepository;
    }


    @PostMapping("/nuevoPaciente")
    public ResponseEntity<String> crear(@RequestBody Paciente paciente) {
        ResponseEntity<String> respuesta;
        if (Objects.nonNull(pacienteService.crear(paciente))) {
            respuesta = ResponseEntity.ok("El Paciente "+paciente.getNombre()+" fue adicionado con éxito");
        } else {
            respuesta = ResponseEntity.internalServerError().body("No se pudo adicionar el paciente");
        }
        return respuesta;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscar(@PathVariable Long id) {
        Paciente paciente = pacienteService.buscarPaciente(id);
        return ResponseEntity.ok(paciente);
    }

    @GetMapping("/listaPacientes")
    public Set<PacienteDTO> obtenerPacientes() {
        return pacienteService.obtenerPacientes();
    }

    @PutMapping("/modificarPaciente")
    public ResponseEntity<?> modificarPaciente(@RequestBody PacienteDTO pacienteDTO) {
        pacienteService.modificarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
