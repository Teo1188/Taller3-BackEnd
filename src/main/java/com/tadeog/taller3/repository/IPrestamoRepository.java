package com.tadeog.taller3.repository;

import com.tadeog.taller3.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPrestamoRepository extends JpaRepository<Prestamo, Long> {
}
