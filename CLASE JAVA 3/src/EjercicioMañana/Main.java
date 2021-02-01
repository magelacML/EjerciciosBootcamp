package EjercicioMañana;

public class Main {
    public static void main(String[] args) {

        // PERSONA
        Persona pers[] = {
                new Persona(10, "Carolina"),
                new Persona(20, "Magela")};

        Precedable<Persona> arr_result[] = SortUtil.ordenar(pers);

        for (Precedable<Persona> p: arr_result){
            System.out.println(p.toString());
        }

        // CELULAR
        Celular cels[] = {
                new Celular(678895, "Magela"),
                new Celular(46890, "Carolina")
        };
        Precedable<Celular> celulares[] = SortUtil.ordenar(cels);

        for (Precedable<Celular> celular: celulares){
            System.out.println(celular.toString());
        }
    }
}
