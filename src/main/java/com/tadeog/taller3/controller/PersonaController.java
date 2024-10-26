package com.tadeog.taller3.controller;

import com.tadeog.taller3.model.Persona;
import com.tadeog.taller3.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personas")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @PostMapping
    public Persona crearPersona(@RequestBody Persona persona) {
        return personaService.createPersona(persona);
    }

    @GetMapping
    public List<Persona> obtenerPersonas() {
        return personaService.getAllPersonas();
    }

    // GET por ID
    @GetMapping("/{id}")
    public ResponseEntity<Persona> obtenerPersonaPorId(@PathVariable Long id) {
        Optional<Persona> persona = personaService.getPersonById(id);
        return persona.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void eliminarPersona(@PathVariable Long id) {
        personaService.deletePersona(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> actualizarPersona(@PathVariable Long id, @RequestBody Persona personaActualizada) {
        return personaService.actualizarPersona(id, personaActualizada);
    }
}

