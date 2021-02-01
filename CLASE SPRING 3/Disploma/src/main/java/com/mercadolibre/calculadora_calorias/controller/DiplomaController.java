package com.mercadolibre.calculadora_calorias.controller;

import com.mercadolibre.calculadora_calorias.model.response.RespuestaDTO;
import com.mercadolibre.calculadora_calorias.model.request.AlumnoDTO;
import com.mercadolibre.calculadora_calorias.service.impl.DiplomaServiceImpl;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
//@RequestMapping(path = "api/diploma")
public class DiplomaController {

//    @Autowired
//    private IDiplomaService iDiplomaService;

    private final DiplomaServiceImpl diploma;

    public DiplomaController(DiplomaServiceImpl diploma) {
        this.diploma = diploma;
    }

    @PostMapping(value="/diploma/promedio")
    public RespuestaDTO generarDiploma(@RequestBody AlumnoDTO alumnoDTO) {
        Double promedio = diploma.calcularPromedio(alumnoDTO);
        String mensaje = "";
        if (promedio > 9){
            mensaje = "Felicitaciones";
        }else{
            mensaje = "Aprobado";
        }
        return new RespuestaDTO(mensaje,promedio,alumnoDTO.getNombre());
    }

}
