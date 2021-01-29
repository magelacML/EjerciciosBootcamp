package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

@RestController
public class EdadesRestController {
    @GetMapping(path = "/{dia}/{mes}/{anio}")
    @ResponseBody
    public EdadesDTO getAge(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio){
        EdadesDTO edadDTO = new EdadesDTO();
        edadDTO.setDate(dia + "/" + mes + "/" + anio);
        edadDTO.setAge(this.calcularEdad(dia,mes,anio));
        return edadDTO;
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
