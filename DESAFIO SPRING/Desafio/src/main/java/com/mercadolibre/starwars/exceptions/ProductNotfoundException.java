package com.mercadolibre.starwars.exceptions;

public class ProductNotfoundException extends RuntimeException{
    private String name = "404: Not Found";
    private String message = "No se encuentra el producto";

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }
}
