package com.delmylira48.LiterAlura_Challenge.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Libros(
        @JsonAlias("title") String tituloLibro,
        @JsonAlias("languajes") List<String> lenguajes,
        @JsonAlias("download_count") int descargas,
        @JsonAlias("authors") List<Autor> autorList

) {
}
