package EjerciciosIndividuales.FiguraGeometrica;

public class Main {
    public static void main(String[] args) {
        Triangulo tr = new Triangulo(3.0,6.3);
        Circulo cr = new Circulo(5.0);
        Rectangulo rc = new Rectangulo(1.5,3.8);

        FiguraGeometrica[] figuras = {tr,cr,rc};
        System.out.println(Utils.areaPromedio(figuras));
    }
}
