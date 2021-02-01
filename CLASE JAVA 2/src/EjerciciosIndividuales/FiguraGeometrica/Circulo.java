package EjerciciosIndividuales.FiguraGeometrica;

import java.util.regex.Matcher;

public class Circulo extends FiguraGeometrica{
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public double area() {
        double area = Math.PI * Math.pow(getRadio(),2);
        return area;
    }
}
