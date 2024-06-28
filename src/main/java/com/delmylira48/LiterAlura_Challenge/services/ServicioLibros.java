package com.delmylira48.LiterAlura_Challenge.services;

import com.delmylira48.LiterAlura_Challenge.models.Autor;
import com.delmylira48.LiterAlura_Challenge.models.Autores_libros;
import com.delmylira48.LiterAlura_Challenge.models.Lenguajes;
import com.delmylira48.LiterAlura_Challenge.models.Libro;
import com.delmylira48.LiterAlura_Challenge.repository.IRepositoryAutores;
import com.delmylira48.LiterAlura_Challenge.repository.IRepositoryLibros;
import com.delmylira48.LiterAlura_Challenge.repository.IRepositoryRelacion;
import jakarta.transaction.Transactional;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioLibros {


    IRepositoryRelacion repositoryRelacion;
    IRepositoryLibros repositoryLibros;
    IRepositoryAutores repositoryAutores;


    @Autowired
    public ServicioLibros(IRepositoryAutores repositoryAutores, IRepositoryLibros repositoryLibros, IRepositoryRelacion repositoryRelacion) {
        this.repositoryAutores = repositoryAutores;
        this.repositoryLibros = repositoryLibros;
        this.repositoryRelacion = repositoryRelacion;
    }

    @Transactional
    public void guardarLibroConAutores(List<Autor> autorList, Libro libro) {
        Optional<Libro> existe = repositoryLibros.findByTitulo(libro.getTitulo());
        if (existe.isPresent()) {
            System.out.println("El libro con título '" + libro.getTitulo() + "' ya existe.");
        } else {
            libro = repositoryLibros.save(libro);
            for (Autor autor : autorList) {
                Optional<Autor> opcionalAutor = repositoryAutores.findByNombreAutor(autor.getNombreAutor());
                if (opcionalAutor.isPresent()){
                    autor = opcionalAutor.get();
                }else{
                    autor = repositoryAutores.save(autor);
                }
                var relacion = new Autores_libros(autor, libro);
                repositoryRelacion.save(relacion);
                System.out.println("El libro ha sido agregado");
                imprimirLibro(libro);
                imprimirAutores(autor);
            }
        }

    }

    public void listarTodosLibros() {
        List<Libro> libroList = repositoryLibros.findAll();
        List<Autores_libros> autoresLibros;
        System.out.println("Los libros registrados son:");
        for (Libro libro : libroList) {
            imprimirLibro(libro);
            System.out.println("\tAutores");
            autoresLibros = repositoryRelacion.findAllByLibroId(libro.getId());
            autoresLibros.forEach(e -> {
                System.out.println("\t"+e.getAutor().getNombreAutor());
            });
        }

    }

    public void listarAutores(){
        List<Autor> autorList = repositoryAutores.findAll();
        autorList.forEach(e ->{
            imprimirAutores(e);
            List<Autores_libros> autores_libros = repositoryRelacion.findAllByAutor_Id(e.getId());
            System.out.println("Libros publicados");
            autores_libros.forEach(s-> {
                System.out.println("\t"+s.getLibro().getTitulo());
            });
        });
    }

    public void listarAutoresVivos(Integer anio) {
        List<Autor> autoresVivos = repositoryAutores.findByAnioNacimientoLessThanAndAnioFallecimientoGreaterThanEqual(anio,anio);
        if(autoresVivos.isEmpty()){
            System.out.println("No hay autores registrados en ese año");
        }else{
            autoresVivos.forEach(e ->{
                imprimirAutores(e);
            });
        }
    }

    public void listarLibrosPorLenguaje(Lenguajes lenguaje) {
        List<Libro> libros = repositoryLibros.findAllByLenguaje(lenguaje);
        if (libros.isEmpty()){
            System.out.println("No hay libros registrados en ese idioma");
        }else{
            System.out.println("Libros:");
            libros.forEach(e -> {
                imprimirLibro(e);
            });
        }
    }

    public void imprimirLibro(Libro libro){
        System.out.println("Titulo libro: " + libro.getTitulo());
        System.out.println("\tDescargas: " + libro.getDescargas());
        System.out.println("\tLenguajes libro: " + libro.getLenguajes());
    }

    public void imprimirAutores(Autor e){
        System.out.println("Autor: "+e.getNombreAutor() );
        System.out.println("\tAño nacimiento: "+e.getAnioNacimiento());
        System.out.println("\tAño fallecimiento: "+ e.getAnioFallecimiento());
    }
}
