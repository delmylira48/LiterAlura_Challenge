package com.delmylira48.LiterAlura_Challenge.repository;

import com.delmylira48.LiterAlura_Challenge.models.Autores_libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRepositoryRelacion extends JpaRepository<Autores_libros, Long> {
    List<Autores_libros> findAllByLibroId(Long id);
    List<Autores_libros> findAllByAutor_Id(Long id);
}
