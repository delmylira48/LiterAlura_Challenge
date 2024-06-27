package com.delmylira48.LiterAlura_Challenge.services;

import com.delmylira48.LiterAlura_Challenge.models.Autor;
import com.delmylira48.LiterAlura_Challenge.models.Autores_libros;
import com.delmylira48.LiterAlura_Challenge.models.Libro;
import com.delmylira48.LiterAlura_Challenge.repository.IRepositoryAutores;
import com.delmylira48.LiterAlura_Challenge.repository.IRepositoryLibros;
import com.delmylira48.LiterAlura_Challenge.repository.IRepositoryRelacion;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void guardarLibroConAutores(List<Autor> autorList, Libro libro){
        libro = repositoryLibros.save(libro);
        for (Autor autor : autorList){
            autor = repositoryAutores.save(autor);
            var relacion=new Autores_libros(autor, libro);
            repositoryRelacion.save(relacion);
        }

    }
}
