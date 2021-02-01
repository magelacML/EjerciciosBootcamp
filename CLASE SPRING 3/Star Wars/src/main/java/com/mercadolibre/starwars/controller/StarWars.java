package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.model.IngredienteCaloriaDTO;
import com.mercadolibre.starwars.model.PlatoCaloriaDTO;
import com.mercadolibre.starwars.model.PlatoDTO;
import com.mercadolibre.starwars.service.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@RestController
@RequestMapping(path = "api/comida")
public class StarWars {
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
