package com.tadeog.taller3.service;

import com.tadeog.taller3.model.Usuario;
import com.tadeog.taller3.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository iusuarioRepository;

    //crear user
    public Usuario createUsuario(Usuario usuario) {
        return iusuarioRepository.save(usuario);
    }

    //obtener user by ID
    public Optional<Usuario> getUsuarioById(Long id) {
        return iusuarioRepository.findById(id);
    }

    //obtener todos los user
    public List<Usuario> getAllUsuario() {
        return iusuarioRepository.findAll();
    }

    //actualizar user
    public ResponseEntity<Usuario> updateUsuario(Long id, Usuario usuarioActualizado) {
        Optional<Usuario> usuario = iusuarioRepository.findById(id);

        if (usuario.isPresent()) {
            Usuario usuarioExistente = usuario.get();
            usuarioExistente.setNombre(usuarioActualizado.getNombre());
            usuarioExistente.setApellido(usuarioActualizado.getApellido());
            usuarioExistente.setPrestamos(usuarioActualizado.getPrestamos());
            iusuarioRepository.save(usuarioExistente);
            return ResponseEntity.ok(usuarioExistente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Eliminar user
    public void deleteUsuario(Long id) {
        iusuarioRepository.deleteById(id);
    }
}
