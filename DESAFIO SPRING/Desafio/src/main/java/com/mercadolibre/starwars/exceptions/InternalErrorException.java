package com.mercadolibre.starwars.exceptions;

public class InternalErrorException extends RuntimeException{
    private String name = "500: Internal Error Exception";
    private String message = "Error en el servidor";

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }
}
