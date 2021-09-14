package com.bosonit.jdbctemplatecrud.persona.infrastructure.controller;

import com.bosonit.jdbctemplatecrud.persona.application.IPersonaService;
import com.bosonit.jdbctemplatecrud.persona.infrastructure.controller.dto.input.PersonaDtoInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v0/")
public class PersonaController {
    @Autowired
    IPersonaService service;

    @GetMapping("personas")
    ResponseEntity<?> getPersonas() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllPersonas());
    }

    @GetMapping("personas/{id}")
    ResponseEntity<?> getPersonaById(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body("NO IMPLEMENTADO");
    }

    @PostMapping("personas")
    ResponseEntity<?> createPersona(@RequestBody PersonaDtoInput persona) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.savePersona(persona));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR");
        }
    }

    @PutMapping("personas/{id}")
    ResponseEntity<?> updatePersona(@PathVariable("id") String id, @RequestBody PersonaDtoInput persona) {
        return ResponseEntity.status(HttpStatus.OK).body("NO IMPLEMENTADO");
    }

    @DeleteMapping("personas/{id}")
    ResponseEntity<?> updatePersona(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
    }


}
