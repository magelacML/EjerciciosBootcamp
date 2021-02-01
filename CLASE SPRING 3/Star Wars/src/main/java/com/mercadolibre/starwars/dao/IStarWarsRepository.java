package com.mercadolibre.starwars.dao;

import com.mercadolibre.starwars.model.IngredienteCaloriaDTO;
import com.mercadolibre.starwars.model.PlatoDTO;

import java.util.List;

public interface IStarWarsRepository {
    Double caloriasTotales(PlatoDTO platoDTO);
    List<IngredienteCaloriaDTO> caloriasPorIngrediente(PlatoDTO platoDTO);
}
