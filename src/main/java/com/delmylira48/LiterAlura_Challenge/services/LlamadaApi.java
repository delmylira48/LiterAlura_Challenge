package com.delmylira48.LiterAlura_Challenge.services;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LlamadaApi {
    private final String URL = "https://gutendex.com/books?search=";
    private String nombreLibro;
    private String contenidoJsonResult;

    public LlamadaApi(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String realizarLlamada() {
        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(URL + nombreLibro.replace(" ", "+")))
                    .build();

            HttpResponse httpResponse= httpClient
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());

            contenidoJsonResult = httpResponse.body().toString();

        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException("OCURRIO UN ERROR EN LA LLAMADA API");
        }

        return contenidoJsonResult;
    }
}
