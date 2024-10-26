package com.tadeog.taller3.model;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nombre;
        private String apellido;
        private int prestamos;

    public Usuario() {}

    public Usuario(int id, String nombre, String apellido) {
        this.id = (long) id;
        this.nombre = nombre;
        this.apellido = apellido;
    }


    // Constructor, Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public Long getId() {
        return id;
    }

    public int getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(int prestamos) {
        this.prestamos = prestamos;
    }
}


