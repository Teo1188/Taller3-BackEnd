package com.tadeog.taller3.model;

import jakarta.persistence.*;

@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_libro;
    private String autor;
    private String titulo;
    private String isbn;
    private boolean disponible;

    public Libro() {}

    public Libro(Long id_libro, String autor, String titulo, String isbn, boolean disponible) {
        this.id_libro = id_libro;
        this.autor = autor;
        this.titulo = titulo;
        this.isbn = isbn;
        this.disponible = disponible;
    }

    //Getters and Setters
    public Long getId_libro() {
        return this.id_libro;
    }

    public void setId_libro(Long id_libro) {
        this.id_libro = id_libro;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean getDisponible() {
        return this.disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public boolean isDisponible() {
        return disponible; }

    public Long getId() {
        return id_libro;
    }

    public void setId(Long id) {
        this.id_libro = id;
    }

}
