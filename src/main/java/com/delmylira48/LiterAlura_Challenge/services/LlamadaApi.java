package com.delmylira48.LiterAlura_Challenge.services;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LlamadaApi {
    private  String URL = "https://gutendex.com/books/?search=";
    private String nombreLibro;
    private String contenidoJsonResult;

    public LlamadaApi(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String realizarLlamada() {
        try {
            var url = URL+nombreLibro.replace(" ", "+");

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse httpResponse= httpClient
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());
            contenidoJsonResult = (String) httpResponse.body();


        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return contenidoJsonResult;

    }
}
