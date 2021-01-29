package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@RestController
public class CasaRestController {
    @PostMapping(path = "/casa")
    @ResponseBody
    public CasaDTO getDatos(@RequestBody CasaDTO casaDTO){
//        CasaDTO edadDTO = new CasaDTO();
//        edadDTO.setDate(dia + "/" + mes + "/" + anio);
//        edadDTO.setAge(this.calcularEdad(dia,mes,anio));
        return casaDTO;
    }

    public Integer calcularEdad( Integer dia,Integer mes, Integer anio ) {

        String f = dia+"/"+mes+"/"+anio;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate fecha = LocalDate.parse(f,formato);
        LocalDate fecha_actual = LocalDate.now();

        int edad = (int)ChronoUnit.YEARS.between(fecha,fecha_actual);

        return edad;
    }
}
