package com.delmylira48.LiterAlura_Challenge.domain;

import com.delmylira48.LiterAlura_Challenge.models.Autor;
import com.delmylira48.LiterAlura_Challenge.models.Lenguajes;
import com.delmylira48.LiterAlura_Challenge.models.Libro;
import com.delmylira48.LiterAlura_Challenge.models.Registro;
import com.delmylira48.LiterAlura_Challenge.services.ConvertirDatos;
import com.delmylira48.LiterAlura_Challenge.services.LlamadaApi;
import com.delmylira48.LiterAlura_Challenge.services.ServicioLibros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class Principal {
    private ServicioLibros servicioLibros;
    Scanner scanner = new Scanner(System.in);

    @Autowired
    public Principal(ServicioLibros servicioLibros) {
        this.servicioLibros = servicioLibros;
    }

    public void presentarMenu() {
        while (true) {

            int opcion = -1;
            System.out.println("""
                    Ingresa el valor necesario para realizar una acción
                    1- Buscar libro por titulo
                    2- Listar libros registrados
                    3- Listar autores registrados
                    4- Listar autores vivos en un determinado año
                    5- Listar libros por idioma
                    0- Salir""");
            try {
                opcion = Integer.valueOf(scanner.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Valor invalido");

            }

            if (opcion==0){
                break;
            }

            switch (opcion) {
                case 1: {
                    llamarAPI();
                    break;
                }
                case 2: {
                    listarLibros();
                    break;
                }
                case 3: {
                    listarAutores();
                    break;
                }
                case 4: {
                    listarAutoresVivos();
                    break;
                }
                case 5: {
                    listarLibrosPorIdioma();
                    break;
                }
                default: {
                    System.out.println("Opcion invalida");
                    break;
                }
            }

        }
    }


    public void llamarAPI() {
        System.out.println("Ingresa el libro a buscar");
        var nombreLibro=scanner.nextLine();
        LlamadaApi llamadaApi = new LlamadaApi(nombreLibro);
        var json = llamadaApi.realizarLlamada();
//        System.out.println("El resultado de la llamada fue:\n" + json);
        ConvertirDatos convertirDatos = new ConvertirDatos();
        var registro = convertirDatos.convertirJson(json, Registro.class);
//        System.out.println(String.format(" La clase registro = %s \nLos libros = %s\nlos autores =",
//                registro.toString(),
//                registro.librosList().toString()
//                ));
//        registro.librosList().forEach(e -> {
//            System.out.println(e.autorList());
//        });
        Libro libro = new Libro(registro.librosList().get(0));
        List<Autor> autor = registro.librosList().get(0).autorList().stream().map(e -> new Autor(e)).collect(Collectors.toList());
        servicioLibros.guardarLibroConAutores(autor, libro);
    }

    public void listarLibros() {
        servicioLibros.listarTodosLibros();
    }

    public void listarAutores() {
        servicioLibros.listarAutores();
    }


    private void listarAutoresVivos() {
        System.out.println("Escribe el año");
        try {
            var anio = Integer.valueOf(scanner.nextLine());
            servicioLibros.listarAutoresVivos(anio);
        } catch (NumberFormatException e) {
            System.out.println("Valor invalido");

        }
    }

    private void listarLibrosPorIdioma() {
        System.out.println("""
                Escribe el codigo de lenguaje que desees
                Español("es"),
                Ingles("en"),
                Frances("fr"),
                Portugues("pt");""");
        var lenguaje = Lenguajes.fromString(scanner.nextLine());
        servicioLibros.listarLibrosPorLenguaje(lenguaje);

    }

}
