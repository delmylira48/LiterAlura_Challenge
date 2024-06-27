package com.delmylira48.LiterAlura_Challenge.models;

public enum Lenguajes {
    Español("es"),
    Ingles("en"),
    Frances("fr"),
    Portugues("pt");

    private String codigoLenguaje;

    Lenguajes(String codigoLenguaje) {
        this.codigoLenguaje=codigoLenguaje;
    }

    //de un string, lo transforma a un enum
    public static Lenguajes fromString(String text){
        for(Lenguajes lenguaje: Lenguajes.values()){
            if (lenguaje.codigoLenguaje.equalsIgnoreCase(text)){
                return lenguaje;
            }
        }
        throw new IllegalArgumentException("Ninguna lenguaje encontrada"+ text);
    }
}
