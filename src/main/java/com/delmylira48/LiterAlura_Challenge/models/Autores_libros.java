package com.delmylira48.LiterAlura_Challenge.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autores_libros")
public class Autores_libros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "libro_id")
    private Libro libro;

    public Autores_libros(Autor autor, Libro libro) {
        this.autor = autor;
        this.libro = libro;
    }

    public Autores_libros() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
}
