import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private int contador;
    private HashMap<Integer, List<Prenda>> diccionario;

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public HashMap<Integer, List<Prenda>> getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(HashMap<Integer, List<Prenda>> diccionario) {
        this.diccionario = diccionario;
    }

    public GuardaRopa() {
        this.setContador(0);
        this.diccionario = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        Integer aux=getContador();
        this.diccionario.put(aux,listaDePrenda);
        this.setContador(aux+1);
        return aux;
    }

    public void imprimirLista(List<Prenda> prendaList) {

        for (Prenda p: prendaList) {
            System.out.println(p.toString());
        }

    }

    public void mostrarPrendas(){

        for (Map.Entry<Integer,List<Prenda>> entry : diccionario.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = "  );
            imprimirLista(entry.getValue());
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        List prenda=this.diccionario.get(numero);
        this.diccionario.remove(numero);
        return prenda;
    }
}
