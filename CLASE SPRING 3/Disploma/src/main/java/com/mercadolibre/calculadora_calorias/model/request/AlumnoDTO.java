package com.mercadolibre.calculadora_calorias.model.request;

import java.util.ArrayList;
import java.util.List;

public class AlumnoDTO {
   private String nombre;
   private List<AsignaturaDTO> lista;

    public AlumnoDTO(String nombre, List<AsignaturaDTO> lista) {
        this.nombre = nombre;
        this.lista = lista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<AsignaturaDTO> getLista() {
        return lista;
    }

    public void setLista(List<AsignaturaDTO> lista) {
        this.lista = lista;
    }
}
