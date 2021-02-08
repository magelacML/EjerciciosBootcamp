package com.mercadolibre.starwars.exceptions;

public class StockNotFoundException extends RuntimeException{
    private String name = "Stock Not Found";
    private String message = "Hay suficiente stock para hacer la compra";

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }
}
