package com.mercadolibre.starwars.exceptions;

public class ProductNotfoundException extends RuntimeException{
    private String nombre = "404: Not Found";
    private String message = "No se encuentra el producto";

    public String getNombre() {
        return nombre;
    }

    public String getMessage() {
        return message;
    }
}
