package com.delmylira48.LiterAlura_Challenge.domain;

import com.delmylira48.LiterAlura_Challenge.models.Registro;
import com.delmylira48.LiterAlura_Challenge.services.ConvertirDatos;
import com.delmylira48.LiterAlura_Challenge.services.LlamadaApi;

public class Principal {
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
    }
}
