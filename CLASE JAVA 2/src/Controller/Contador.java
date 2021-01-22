package Controller;

public class Contador {

    private int cont;

    public Contador(){
        cont = 0;
    }

    public void setContador(int cont){
        this.cont = cont;
    }

    public int getContador(){
        return this.cont;
    }


    public int incrementar(int a){
        this.cont = this.cont + a;
        return getContador();

    }

    public int decrementar(int b){
        this.cont = this.cont - b;
        return getContador();
    }

    public static void main(String[] args) {
        Contador c = new Contador();
        c.incrementar(1);
        System.out.println(c.getContador());
    }

}


