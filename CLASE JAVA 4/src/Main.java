import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Prenda> prendaList=new ArrayList<>();
        List<Prenda> prendaList1=new ArrayList<>();
        Prenda prenda=new Prenda("nike","mujer");
        Prenda prenda1=new Prenda("addidas","mujer");
        prendaList.add(prenda);
        prendaList.add(prenda1);
        prendaList1.add(prenda);
        GuardaRopa guardaRopa=new GuardaRopa();
        Integer i=guardaRopa.guardarPrendas(prendaList);
        Integer j=guardaRopa.guardarPrendas(prendaList1);
        System.out.println("i es: "+i);
        guardaRopa.mostrarPrendas();
        prendaList=guardaRopa.devolverPrendas(0);
        System.out.println("segunda:");
        guardaRopa.mostrarPrendas();
    }
}
