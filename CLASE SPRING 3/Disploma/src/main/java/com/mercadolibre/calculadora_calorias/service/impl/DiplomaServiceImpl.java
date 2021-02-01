package com.mercadolibre.calculadora_calorias.service.impl;

import com.mercadolibre.calculadora_calorias.model.request.AlumnoDTO;
import com.mercadolibre.calculadora_calorias.model.request.AsignaturaDTO;
import com.mercadolibre.calculadora_calorias.service.IDiplomaService;
import org.springframework.stereotype.Service;

@Service
public class DiplomaServiceImpl implements IDiplomaService {


    @Override
    public Double calcularPromedio(AlumnoDTO alumnoDTO) {
        double promedio = 0;
        for (AsignaturaDTO a: alumnoDTO.getLista()){
            promedio = promedio + a.getNota();
        }
        promedio = promedio/alumnoDTO.getLista().size();

        return  promedio;
    }
}
