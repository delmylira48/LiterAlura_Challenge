package com.delmylira48.LiterAlura_Challenge.repository;

import com.delmylira48.LiterAlura_Challenge.models.Lenguajes;
import com.delmylira48.LiterAlura_Challenge.models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IRepositoryLibros extends JpaRepository<Libro, Long> {
    Optional<Libro> findByTitulo(String libro);

    @Query("SELECT l FROM Libro l WHERE :lenguaje MEMBER OF l.lenguajes")
    List<Libro> findAllByLenguaje(Lenguajes lenguaje);
}
