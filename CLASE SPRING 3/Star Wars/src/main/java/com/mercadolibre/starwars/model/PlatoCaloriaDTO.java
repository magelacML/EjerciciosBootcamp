package com.mercadolibre.calculadora_calorias.model;

public class PlatoCaloriaDTO {
    private String nombrePlato;
    private Double caloriasTotales;

    public PlatoCaloriaDTO(String nombrePlato, Double caloriasTotales) {
        this.nombrePlato = nombrePlato;
        this.caloriasTotales = caloriasTotales;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public Double getCaloriasTotales() {
        return caloriasTotales;
    }

    public void setCaloriasTotales(Double caloriasTotales) {
        this.caloriasTotales = caloriasTotales;
    }
}
