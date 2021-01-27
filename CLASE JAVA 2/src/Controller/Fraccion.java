package Controller;

public class Fraccion {
    private int numerador;
    private int denominador;

    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Fraccion Sumar(Fraccion a){
        int num = (a.getNumerador()*this.getDenominador()) + (a.getDenominador()*this.getNumerador());
        int den = a.getDenominador() * this.getDenominador();
        return new Fraccion(num,den);
    }

    public Fraccion Sumar(int a){
        int num = (a*this.getDenominador()) + (this.getNumerador());
        int den = a * this.getDenominador();
        return new Fraccion(num,den);
    }

    public Fraccion Restar(Fraccion a){
        int num = (a.getNumerador()*this.getDenominador()) - (a.getDenominador()*this.getNumerador());
        int den = a.getDenominador() * this.getDenominador();
        return new Fraccion(num,den);
    }

    public Fraccion Restar(int a) {
        int num = (a * this.getDenominador()) - (this.getNumerador());
        int den = a * this.getDenominador();
        return new Fraccion(num, den);
    }

    public Fraccion Multiplicar(Fraccion a){
        int num = a.getNumerador()*this.getNumerador();
        int den = a.getDenominador() * this.getDenominador();
        return new Fraccion(num,den);
    }

    public Fraccion Multiplicar(int a){
        int num = a*this.getNumerador();
        int den = this.getDenominador();
        return new Fraccion(num,den);
    }

    public Fraccion Dividir(Fraccion a){
        int num = this.getNumerador()*a.getDenominador();
        int den = this.getDenominador()*a.getNumerador();
        return new Fraccion(num,den);
    }
    public Fraccion Dividir(int a){
        int num = this.getNumerador();
        int den = this.getDenominador()*a;
        return new Fraccion(num,den);
    }

}
