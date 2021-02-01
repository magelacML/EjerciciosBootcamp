public class Celular implements Precedable<Celular>{
    private int numero;
    private String nombre;

    public Celular(int numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int precedeA(Celular celular) {
        return getNumero() - celular.getNumero();
    }

    @Override
    public String toString() {
        return "Celular{" +
                "numero=" + numero +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
