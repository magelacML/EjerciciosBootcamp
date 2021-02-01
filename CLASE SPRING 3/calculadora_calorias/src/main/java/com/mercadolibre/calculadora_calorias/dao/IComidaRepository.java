package com.mercadolibre.calculadora_calorias.dao;

import com.mercadolibre.calculadora_calorias.model.response.IngredienteCaloriaDTO;

import java.util.List;

public interface IComidaRepository {
    List<IngredienteCaloriaDTO> obtenerIngredientes();
}
