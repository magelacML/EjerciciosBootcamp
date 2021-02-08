package com.mercadolibre.starwars.exceptions;

public class MissingFileException extends RuntimeException {
    private String name = "400: Bad Request";
    private String message = "Request mal formada";

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }
}
