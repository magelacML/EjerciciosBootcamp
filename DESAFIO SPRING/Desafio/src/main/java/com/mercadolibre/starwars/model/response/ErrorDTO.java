package com.mercadolibre.starwars.model.response;

public class ErrorDTO {
    private String name;
    private String descripcion;

    public ErrorDTO(String name, String descripcion) {
        this.name = name;
        this.descripcion = descripcion;
    }

    public ErrorDTO() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
