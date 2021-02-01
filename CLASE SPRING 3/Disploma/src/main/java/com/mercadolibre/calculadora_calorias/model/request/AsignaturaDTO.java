package com.mercadolibre.calculadora_calorias.model.request;

public class AsignaturaDTO {
  private String nombre;
  private Double nota;

    public AsignaturaDTO(String nombre, Double nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
}
