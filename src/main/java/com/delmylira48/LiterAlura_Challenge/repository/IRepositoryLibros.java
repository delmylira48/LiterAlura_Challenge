package com.delmylira48.LiterAlura_Challenge.repository;

import com.delmylira48.LiterAlura_Challenge.models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryLibros extends JpaRepository<Libro, Long> {
}
