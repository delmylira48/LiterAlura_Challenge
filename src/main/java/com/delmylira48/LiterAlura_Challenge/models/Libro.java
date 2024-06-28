package com.delmylira48.LiterAlura_Challenge.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;


@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<Lenguajes> lenguajes;
    private int descargas;

    public Libro(Libros libros){
        this.titulo= libros.tituloLibro();
        this.descargas= libros.descargas();
        if(libros.lenguajes().isEmpty()){
            this.lenguajes=null;
        }else{
            System.out.println(libros.lenguajes().toString());
            this.lenguajes= libros.lenguajes().stream().map(e -> Lenguajes.fromString(e)).collect(Collectors.toList());
            System.out.println(this.lenguajes.toString());
        }
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", lenguajes=" + lenguajes +
                ", descargas=" + descargas +
                '}';
    }

    public Libro() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Lenguajes> getLenguajes() {
        return lenguajes;
    }

    public void setLenguajes(List<Lenguajes> lenguajes) {
        this.lenguajes = lenguajes;
    }

    public int getDescargas() {
        return descargas;
    }

    public void setDescargas(int descargas) {
        this.descargas = descargas;
    }
}
