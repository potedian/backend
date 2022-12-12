package com.proyecto.clinicav3.controller;

import com.proyecto.clinicav3.dto.OdontologoDTO;
import com.proyecto.clinicav3.modelo.Odontologo;
import com.proyecto.clinicav3.repository.OdontologoRepository;
import com.proyecto.clinicav3.service.impl.OdontologoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Set;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    private final OdontologoServiceImpl odontologoService;
    private final OdontologoRepository odontologoRepository;


    public OdontologoController(OdontologoServiceImpl odontologoService, OdontologoRepository odontologoRepository) {
        this.odontologoService = odontologoService;
        this.odontologoRepository = odontologoRepository;
    }



    @PostMapping("/nuevoOdontologo")
    public ResponseEntity<String> crear(@RequestBody Odontologo odontologo) {
        ResponseEntity<String> respuesta;
        if (Objects.nonNull(odontologoService.crear(odontologo))) {
            respuesta = ResponseEntity.ok("El odontologo "+odontologo.getNombre()+" fue adicionado con éxito");
        } else {
            respuesta = ResponseEntity.internalServerError().body("No se pudo adicionar el odontologo");
        }
        return respuesta;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscar(@PathVariable Long id) {
        Odontologo odontologo = odontologoService.buscarOdontologo(id);
        return ResponseEntity.ok(odontologo);
    }

    @GetMapping("/listaOdontologos")
    public Set<OdontologoDTO> obtenerodontologos() {
        return odontologoService.obtenerOdontologos();
    }

        @PutMapping("/modificarOdontologo")
    public ResponseEntity<?> modificarodontologo(@RequestBody OdontologoDTO odontologoDTO) {
        odontologoService.modificarOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        odontologoService.eliminarOdontologo(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
