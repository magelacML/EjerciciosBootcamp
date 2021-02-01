package com.mercadolibre.calculadora_calorias.dao;

import com.mercadolibre.calculadora_calorias.model.IngredienteCaloriaDTO;
import com.mercadolibre.calculadora_calorias.model.PlatoDTO;

import java.util.List;

public interface IComidaRepository {
    Double caloriasTotales(PlatoDTO platoDTO);
    List<IngredienteCaloriaDTO> caloriasPorIngrediente(PlatoDTO platoDTO);
}
