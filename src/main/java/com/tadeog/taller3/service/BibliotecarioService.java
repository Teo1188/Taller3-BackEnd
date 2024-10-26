package com.tadeog.taller3.service;

import com.tadeog.taller3.model.Bibliotecario;
import com.tadeog.taller3.repository.IBibliotecarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BibliotecarioService {
    @Autowired
    private IBibliotecarioRepository bibliotecarioRepository;

    public Bibliotecario guardarBibliotecario(Bibliotecario bibliotecario) {
        return bibliotecarioRepository.save(bibliotecario);
    }

    public List<Bibliotecario> getAllBibliotecarios() {
        return bibliotecarioRepository.findAll();
    }

    public Optional<Bibliotecario> getBibliotecarioById(Long id) {
        return bibliotecarioRepository.findById(id);
    }

    public void deleteBibliotecario(Long id) {
        bibliotecarioRepository.deleteById(id);
    }

    public ResponseEntity<Bibliotecario> actualizarBibliotecario(Long id, Bibliotecario bibliotecarioActualizado) {
        Optional<Bibliotecario> bibliotecario = bibliotecarioRepository.findById(id);

        if (bibliotecario.isPresent()) {
            Bibliotecario bibliotecarioExistente = bibliotecario.get();
            bibliotecarioExistente.setNombre(bibliotecarioActualizado.getNombre());
            bibliotecarioExistente.setApellido(bibliotecarioActualizado.getApellido());
            bibliotecarioExistente.setPrestamos(bibliotecarioActualizado.getPrestamos());
            bibliotecarioRepository.save(bibliotecarioExistente);
            return ResponseEntity.ok(bibliotecarioExistente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
