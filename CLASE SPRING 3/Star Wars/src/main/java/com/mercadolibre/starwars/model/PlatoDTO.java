package com.mercadolibre.starwars.model;

import java.util.ArrayList;
import java.util.List;

public class PlatoDTO {
    private String nombre;
    private List<IngredienteDTO> ingredientes;

    public PlatoDTO() {

    }

    public PlatoDTO(String nombre) {
        this.nombre = nombre;
        this.ingredientes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<IngredienteDTO> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredienteDTO> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
