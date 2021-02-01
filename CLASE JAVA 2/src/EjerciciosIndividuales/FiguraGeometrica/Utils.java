package EjerciciosIndividuales.FiguraGeometrica;

public class Utils {
    public static double areaPromedio(FiguraGeometrica arr[]){
        double areaTotal = 0.0;
        for (FiguraGeometrica fig: arr) {
            areaTotal = areaTotal + fig.area();
        }
        return areaTotal/arr.length;
    }
}
