package com.delmylira48.LiterAlura_Challenge.repository;

import com.delmylira48.LiterAlura_Challenge.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryAutores extends JpaRepository<Autor, Long> {
}
