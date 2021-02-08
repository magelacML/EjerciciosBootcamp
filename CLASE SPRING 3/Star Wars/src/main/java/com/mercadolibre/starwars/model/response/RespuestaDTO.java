package com.mercadolibre.starwars.model.response;

import java.util.ArrayList;
import java.util.List;

public class RespuestaDTO {
    List<PersonajeDTO> personaje;

    public RespuestaDTO(List<PersonajeDTO> personaje) {
        this.personaje = personaje;
    }

    public List<PersonajeDTO> getPersonaje() {
        return personaje;
    }

    public void setPersonaje(List<PersonajeDTO> personaje) {
        this.personaje = personaje;
    }
}
