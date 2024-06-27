package com.delmylira48.LiterAlura_Challenge.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Registro(
        @JsonAlias("results") List<Libros> librosList
) {
}
