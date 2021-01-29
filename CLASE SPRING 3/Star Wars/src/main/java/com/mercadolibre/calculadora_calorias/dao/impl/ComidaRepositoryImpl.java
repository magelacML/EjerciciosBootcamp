package com.mercadolibre.calculadora_calorias.dao.impl;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadora_calorias.dao.IComidaRepository;
import com.mercadolibre.calculadora_calorias.model.IngredienteCaloriaDTO;
import com.mercadolibre.calculadora_calorias.model.IngredienteDTO;
import com.mercadolibre.calculadora_calorias.model.PlatoDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ComidaRepositoryImpl implements IComidaRepository {

    @Override
    public Double caloriasTotales(PlatoDTO platoDTO) {
        List<IngredienteCaloriaDTO> ingredienteCaloriaDTOS = null;
        ingredienteCaloriaDTOS = cargarArchivoJson();
        Double caloriasTotales = 0.0;

        for (IngredienteDTO ingredienteDTO : platoDTO.getIngredientes()) {
            for (IngredienteCaloriaDTO ingredienteCaloriaDTO : ingredienteCaloriaDTOS) {
                if (ingredienteDTO.getNombre().equals(ingredienteCaloriaDTO.getName())) {
                    caloriasTotales += ingredienteCaloriaDTO.getCalories();
                }
            }
        }
        return caloriasTotales;
    }

    @Override
    public List<IngredienteCaloriaDTO> caloriasPorIngrediente(PlatoDTO platoDTO) {

        List<IngredienteCaloriaDTO> ingredienteCaloriaDTOS = null;
        ingredienteCaloriaDTOS = cargarArchivoJson();
        List<IngredienteCaloriaDTO> caloriasPorIngrediente = new ArrayList<>();

        for (IngredienteDTO ingredienteDTO : platoDTO.getIngredientes()) {
            for (IngredienteCaloriaDTO ingredienteCaloriaDTO : ingredienteCaloriaDTOS) {
                if (ingredienteDTO.getNombre().equals(ingredienteCaloriaDTO.getName())) {
                    caloriasPorIngrediente.add(ingredienteCaloriaDTO);
                }
            }
        }
        return caloriasPorIngrediente;
    }

    private List<IngredienteCaloriaDTO> cargarArchivoJson() {
        File file = null;
        try {
            file = ResourceUtils.getFile("src/main/resources/data/food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredienteCaloriaDTO>> typeReference = new TypeReference<>() {};
        List<IngredienteCaloriaDTO> ingredienteCaloriaDTOS = null;

        try {
            ingredienteCaloriaDTOS = objectMapper.readValue(file, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ingredienteCaloriaDTOS;
    }
}
