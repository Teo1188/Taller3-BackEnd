package com.tadeog.taller3.controller;

import com.tadeog.taller3.model.Bibliotecario;
import com.tadeog.taller3.service.BibliotecarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bibliotecarios")
public class BibliotecarioController {
    @Autowired
    private BibliotecarioService bibliotecarioService;

    @PostMapping
    public Bibliotecario crearBibliotecario(@RequestBody Bibliotecario bibliotecario) {
        return bibliotecarioService.guardarBibliotecario(bibliotecario);
    }

    @GetMapping
    public List<Bibliotecario> obtenerBibliotecarios() {
        return bibliotecarioService.getAllBibliotecarios();
    }

    // GET por ID
    @GetMapping("/{id}")
    public ResponseEntity<Bibliotecario> obtenerBibliotecarioPorId(@PathVariable Long id) {
        Optional<Bibliotecario> bibliotecario = bibliotecarioService.getBibliotecarioById(id);
        return bibliotecario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void eliminarBibliotecario(@PathVariable Long id) {
        bibliotecarioService.deleteBibliotecario(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bibliotecario> actualizarBibliotecario(@PathVariable Long id, @RequestBody Bibliotecario bibliotecarioActualizado) {
        return bibliotecarioService.actualizarBibliotecario(id, bibliotecarioActualizado);
    }
}
