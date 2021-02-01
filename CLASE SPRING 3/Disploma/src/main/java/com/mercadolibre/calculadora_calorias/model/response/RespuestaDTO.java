package com.mercadolibre.calculadora_calorias.model.response;

public class RespuestaDTO {
   private String mensaje;
   private Double promedio;
   private String alumno;

    public RespuestaDTO(String mensaje, Double promedio, String alumno) {
        this.mensaje = mensaje;
        this.promedio = promedio;
        this.alumno = alumno;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }
}
