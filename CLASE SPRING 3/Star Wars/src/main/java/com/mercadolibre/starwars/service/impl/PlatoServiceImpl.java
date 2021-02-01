package com.mercadolibre.starwars.service.impl;

import com.mercadolibre.starwars.dao.IStarWarsRepository;
import com.mercadolibre.starwars.model.IngredienteCaloriaDTO;
import com.mercadolibre.starwars.model.PlatoDTO;
import com.mercadolibre.starwars.service.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class PlatoServiceImpl implements IPlatoService {
    @Autowired
    private IStarWarsRepository iStarWarsRepository;

    @Override
    public Double caloriasTotales(PlatoDTO platoDTO) {
        return iStarWarsRepository.caloriasTotales(platoDTO);
    }

    @Override
    public List<IngredienteCaloriaDTO> caloriasPorIngrediente(PlatoDTO platoDTO) {
        return iStarWarsRepository.caloriasPorIngrediente(platoDTO);
    }

    @Override
    public IngredienteCaloriaDTO ingredienteConMasCalorias(PlatoDTO platoDTO) {
        List<IngredienteCaloriaDTO> ingredienteCaloriaDTOS = iStarWarsRepository.caloriasPorIngrediente(platoDTO);
        return ingredienteCaloriaDTOS.stream().max(Comparator.comparing(IngredienteCaloriaDTO::getCalories)).get();
    }
}
