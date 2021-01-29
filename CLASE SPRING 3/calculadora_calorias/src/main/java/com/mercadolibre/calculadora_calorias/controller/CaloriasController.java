package com.mercadolibre.calculadora_calorias.controller;

import com.mercadolibre.calculadora_calorias.model.IngredienteCaloriaDTO;
import com.mercadolibre.calculadora_calorias.model.PlatoCaloriaDTO;
import com.mercadolibre.calculadora_calorias.model.PlatoDTO;
import com.mercadolibre.calculadora_calorias.service.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(path = "api/comida")
public class CaloriasController {
    @Autowired
    private IPlatoService iPlatoService;

    @PostMapping(value="/calorias_totales")
    public PlatoCaloriaDTO calcularCaloriasTotales(@RequestBody PlatoDTO platoDTO) {
        Double calorias = iPlatoService.caloriasTotales(platoDTO);
        return new PlatoCaloriaDTO(platoDTO.getNombre(), calorias);
    }

    @PostMapping(value="/calorias_por_ingrediente")
    public List<IngredienteCaloriaDTO> caloriasPorIngrediente(@RequestBody PlatoDTO platoDTO) {
        return iPlatoService.caloriasPorIngrediente(platoDTO);
    }

    @PostMapping(value="/ingrediente_con_mas_calorias")
    public IngredienteCaloriaDTO ingredienteConMasCalorias(@RequestBody PlatoDTO platoDTO) {
        return iPlatoService.ingredienteConMasCalorias(platoDTO);
    }
}
