package com.mercadolibre.calculadora_calorias.service.impl;

import com.mercadolibre.calculadora_calorias.dao.IComidaRepository;
import com.mercadolibre.calculadora_calorias.model.response.IngredienteCaloriaDTO;
import com.mercadolibre.calculadora_calorias.model.request.PlatoDTO;
import com.mercadolibre.calculadora_calorias.service.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlatoServiceImpl implements IPlatoService {
    @Autowired
    private IComidaRepository iComidaRepository;

    @Override
    public Double caloriasTotales(PlatoDTO platoDTO) {
        List<IngredienteCaloriaDTO> ingredienteCaloriaDTOS = iComidaRepository.obtenerIngredientes();
        Double caloriasTotales = 0.0;

        caloriasTotales =
                ingredienteCaloriaDTOS.stream()
                        .filter (ingredienteCaloriaDTO ->
                                platoDTO.getIngredientes()
                                        .stream()
                                        .anyMatch(ingredienteDTO -> ingredienteDTO.getNombre().equals(ingredienteCaloriaDTO.getName()))
                        ).mapToDouble(IngredienteCaloriaDTO::getCalories).sum();
        return caloriasTotales;
    }

    @Override
    public List<IngredienteCaloriaDTO> caloriasPorIngrediente(PlatoDTO platoDTO) {
        List<IngredienteCaloriaDTO> ingredienteCaloriaDTOS = iComidaRepository.obtenerIngredientes();
        List<IngredienteCaloriaDTO> caloriasPorIngrediente = new ArrayList<>();
        caloriasPorIngrediente =
            ingredienteCaloriaDTOS
                    .stream()
                    .filter (ingredienteCaloriaDTO ->
                        platoDTO.getIngredientes()
                                .stream()
                                .anyMatch(ingredienteDTO -> ingredienteDTO.getNombre().equals(ingredienteCaloriaDTO.getName()))
                    ).collect(Collectors.toList());
        return caloriasPorIngrediente;
    }

    @Override
    public IngredienteCaloriaDTO ingredienteConMasCalorias(PlatoDTO platoDTO) {
        List<IngredienteCaloriaDTO> ingredienteCaloriaDTOS = this.caloriasPorIngrediente(platoDTO);
        return ingredienteCaloriaDTOS
                .stream()
                .max(Comparator.comparing(IngredienteCaloriaDTO::getCalories))
                .orElse(null);
    }
}
