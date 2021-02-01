package com.mercadolibre.calculadora_calorias.model.response;

public class IngredienteCaloriaDTO {
    private String name;
    private Double calories;

    public IngredienteCaloriaDTO() {

    }

    public IngredienteCaloriaDTO(String name, Double calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }
}
