package com.mercadolibre.calculadora_calorias.service.impl;

import com.mercadolibre.calculadora_calorias.dao.IComidaRepository;
import com.mercadolibre.calculadora_calorias.model.IngredienteCaloriaDTO;
import com.mercadolibre.calculadora_calorias.model.PlatoDTO;
import com.mercadolibre.calculadora_calorias.service.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class PlatoServiceImpl implements IPlatoService {
    @Autowired
    private IComidaRepository iComidaRepository;

    @Override
    public Double caloriasTotales(PlatoDTO platoDTO) {
        return iComidaRepository.caloriasTotales(platoDTO);
    }

    @Override
    public List<IngredienteCaloriaDTO> caloriasPorIngrediente(PlatoDTO platoDTO) {
        return iComidaRepository.caloriasPorIngrediente(platoDTO);
    }

    @Override
    public IngredienteCaloriaDTO ingredienteConMasCalorias(PlatoDTO platoDTO) {
        List<IngredienteCaloriaDTO> ingredienteCaloriaDTOS = iComidaRepository.caloriasPorIngrediente(platoDTO);
        return ingredienteCaloriaDTOS.stream().max(Comparator.comparing(IngredienteCaloriaDTO::getCalories)).get();
    }
}
