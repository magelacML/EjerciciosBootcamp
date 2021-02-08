package com.mercadolibre.starwars.service;

import java.util.List;

public interface IPlatoService {
    Double caloriasTotales(PlatoDTO platoDTO);
    List<IngredienteCaloriaDTO> caloriasPorIngrediente(PlatoDTO platoDTO);
    IngredienteCaloriaDTO ingredienteConMasCalorias(PlatoDTO platoDTO);
}
