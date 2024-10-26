package com.tadeog.taller3.repository;

import com.tadeog.taller3.model.Bibliotecario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBibliotecarioRepository extends JpaRepository<Bibliotecario, Long> {
}
