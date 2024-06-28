package com.delmylira48.LiterAlura_Challenge.repository;

import com.delmylira48.LiterAlura_Challenge.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IRepositoryAutores extends JpaRepository<Autor, Long> {
    Optional<Autor> findByNombreAutor(String nombre);
    List<Autor> findByAnioNacimientoLessThanAndAnioFallecimientoGreaterThanEqual(int anio, int anio2);
}
