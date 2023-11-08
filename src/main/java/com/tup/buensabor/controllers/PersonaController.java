package com.tup.buensabor.controllers;

import com.tup.buensabor.dtos.DTOCambiarDatos;
import com.tup.buensabor.entities.Persona;
import com.tup.buensabor.services.PersonaServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/personas")
public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl> {
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filtro) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam String filtro, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @PutMapping("/cambiarDatos")
    public ResponseEntity<?> search(@RequestBody DTOCambiarDatos dtoCambiarDatos) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.cambiarDatos(dtoCambiarDatos));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor, intente más tarde.\"}");
        }
    }

    @PutMapping("/rankingPersonas")
    public ResponseEntity<?> rankingPersonas(@RequestParam Date desde, @RequestParam Date hasta) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.rankingPersonas(desde, hasta));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor, intente más tarde.\"}");
        }
    }

}
