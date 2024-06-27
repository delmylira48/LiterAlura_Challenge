package com.delmylira48.LiterAlura_Challenge.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AutorDTO(
        @JsonAlias("name") String nombreAutor,
        @JsonAlias("birth_year") int anioNacimiento,
        @JsonAlias("death_year") int anioFallecimiento
) {
}
