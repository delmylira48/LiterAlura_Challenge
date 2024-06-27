package com.delmylira48.LiterAlura_Challenge.domain;

import com.delmylira48.LiterAlura_Challenge.models.Autor;
import com.delmylira48.LiterAlura_Challenge.models.Libro;
import com.delmylira48.LiterAlura_Challenge.models.Registro;
import com.delmylira48.LiterAlura_Challenge.services.ConvertirDatos;
import com.delmylira48.LiterAlura_Challenge.services.LlamadaApi;
import com.delmylira48.LiterAlura_Challenge.services.ServicioLibros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Principal {
    private ServicioLibros servicioLibros;

    @Autowired
    public Principal(ServicioLibros servicioLibros) {
        this.servicioLibros = servicioLibros;
    }

    public void llamarAPI() {
        LlamadaApi llamadaApi = new LlamadaApi("alicia");
        var json = llamadaApi.realizarLlamada();
        System.out.println("El resultado de la llamada fue:\n" + json);
        ConvertirDatos convertirDatos = new ConvertirDatos();
        var registro = convertirDatos.convertirJson(json, Registro.class);
        System.out.println(String.format(" La clase registro = %s \nLos libros = %s\nlos autores =",
                registro.toString(),
                registro.librosList().toString()
                ));
        registro.librosList().forEach(e -> {
            System.out.println(e.autorList());
        });
        Libro libro1= new Libro(registro.librosList().get(1));
        List<Autor> autor1 = registro.librosList().get(1).autorList().stream().map(e -> new Autor(e)).collect(Collectors.toList());
        servicioLibros.guardarLibroConAutores(autor1, libro1);
    }
}
