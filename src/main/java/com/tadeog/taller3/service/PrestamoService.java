package com.tadeog.taller3.service;

import com.tadeog.taller3.model.Libro;
import com.tadeog.taller3.model.Prestamo;
import com.tadeog.taller3.model.Usuario;
import com.tadeog.taller3.repository.ILibroRepository;
import com.tadeog.taller3.repository.IPrestamoRepository;
import com.tadeog.taller3.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;



@Service
public class PrestamoService {
    @Autowired
    private IPrestamoRepository prestamoRepository;

    @Autowired
    private ILibroRepository libroRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    // Guardar un préstamo con libro y usuario completos
    public Prestamo guardarPrestamo(Prestamo prestamo) {
        // Obtener el libro completo desde la base de datos
        Libro libro = libroRepository.findById(prestamo.getLibro().getId_libro())
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        // Obtener el usuario completo desde la base de datos
        Usuario usuario = usuarioRepository.findById(prestamo.getUsuario().getId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Asignar los objetos completos al préstamo
        prestamo.setLibro(libro);
        prestamo.setUsuario(usuario);

        return prestamoRepository.save(prestamo);
    }

    public List<Prestamo> getAllPrestamos() {
        return prestamoRepository.findAll();
    }

    public Optional<Prestamo> getPrestamoById(Long id) {
        return prestamoRepository.findById(id);
    }

    public void deletePrestamo(Long id) {
        prestamoRepository.deleteById(id);
    }

    // Actualizar un préstamo
    public ResponseEntity<Prestamo> actualizarPrestamo(Long id, Prestamo prestamoActualizado) {
        Optional<Prestamo> prestamo = prestamoRepository.findById(id);

        if (prestamo.isPresent()) {
            Prestamo prestamoExistente = prestamo.get();

            // Obtener el libro completo desde la base de datos
            Libro libro = libroRepository.findById(prestamoActualizado.getLibro().getId())
                    .orElseThrow(() -> new RuntimeException("Libro no encontrado"));

            // Obtener el usuario completo desde la base de datos
            Usuario usuario = usuarioRepository.findById(prestamoActualizado.getUsuario().getId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

            prestamoExistente.setFechaPrestamo(prestamoActualizado.getFechaPrestamo());
            prestamoExistente.setFechaDevolucion(prestamoActualizado.getFechaDevolucion());
            prestamoExistente.setLibro(libro);
            prestamoExistente.setUsuario(usuario);

            prestamoRepository.save(prestamoExistente);
            return ResponseEntity.ok(prestamoExistente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
