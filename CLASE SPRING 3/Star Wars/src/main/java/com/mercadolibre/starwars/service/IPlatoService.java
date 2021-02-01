package com.mercadolibre.calculadora_calorias.service;

import com.mercadolibre.calculadora_calorias.model.IngredienteCaloriaDTO;
import com.mercadolibre.calculadora_calorias.model.PlatoDTO;

import java.util.List;

public interface IPlatoService {
    Double caloriasTotales(PlatoDTO platoDTO);
    List<IngredienteCaloriaDTO> caloriasPorIngrediente(PlatoDTO platoDTO);
    IngredienteCaloriaDTO ingredienteConMasCalorias(PlatoDTO platoDTO);
}
