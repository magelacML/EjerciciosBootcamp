package com.mercadolibre.calculadora_calorias.model;

public class IngredienteDTO {
    private String nombre;
    private Double peso;

    public IngredienteDTO(String nombre, Double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
}
