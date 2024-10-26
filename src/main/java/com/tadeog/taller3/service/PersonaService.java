package com.tadeog.taller3.service;

import com.tadeog.taller3.model.Persona;
import com.tadeog.taller3.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private IPersonaRepository ipersonaRepository;

    //crear persona
    public Persona createPersona(Persona persona) {
        return ipersonaRepository.save(persona);
    }

    //obtener persona by ID
    public Optional<Persona> getPersonById(Long id) {
        return ipersonaRepository.findById(id);
    }

    //obtener todas las personas
    public List<Persona> getAllPersonas() {
        return ipersonaRepository.findAll();
    }

    //actualizar persona
    public ResponseEntity<Persona> actualizarPersona(Long id, Persona personaActualizada) {
        Optional<Persona> persona = ipersonaRepository.findById(id);

        if (persona.isPresent()) {
            Persona personaExistente = persona.get();
            personaExistente.setNombre(personaActualizada.getNombre());
            personaExistente.setApellido(personaActualizada.getApellido());
            personaExistente.setTipo(personaActualizada.getTipo());
            ipersonaRepository.save(personaExistente);
            return ResponseEntity.ok(personaExistente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Eliminar persona
    public void deletePersona(Long id) {
        ipersonaRepository.deleteById(id);
    }


}
