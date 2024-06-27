package com.delmylira48.LiterAlura_Challenge.repository;

import com.delmylira48.LiterAlura_Challenge.models.Autores_libros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryRelacion extends JpaRepository<Autores_libros, Long> {
}
