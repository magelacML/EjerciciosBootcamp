package com.mercadolibre.calculadora_calorias.dao.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadora_calorias.dao.IComidaRepository;
import com.mercadolibre.calculadora_calorias.model.response.IngredienteCaloriaDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class ComidaRepositoryImpl implements IComidaRepository {
    @Override
    public List<IngredienteCaloriaDTO> obtenerIngredientes() {
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
