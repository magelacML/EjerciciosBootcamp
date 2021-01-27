package Controller;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {
    private int dia;
    private int mes;
    private int anio;
    private GregorianCalendar grego = (GregorianCalendar) GregorianCalendar.getInstance();

    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;

        grego.set(anio,mes,dia);
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + anio ;
    }

    public void printGrego(){
        System.out.println(grego.getTime().toLocaleString());
    }

    public GregorianCalendar agregarDia(){
        this.grego.add(Calendar.DAY_OF_MONTH,1);
        return grego;
    }
}
