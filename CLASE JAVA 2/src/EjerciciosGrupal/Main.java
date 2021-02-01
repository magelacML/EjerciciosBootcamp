package EjerciciosGrupal;

public class Main {
    public static void main(String[] args) {
        // Ejercicio 1
        CuentaCorriente cuenta = new CuentaCorriente(254,36);
        System.out.println(cuenta.getCuenta());

        // Ejercicio 2
        Contador c = new Contador();
        c.incrementar(1);
        System.out.println(c.getContador());

        // Ejercicio 3
        Libro l = new Libro("titulo","859","autor");
        System.out.println(l.toString());

        // Ejercicio 4
        Fraccion a = new Fraccion(3,3);
        Fraccion b = new Fraccion(8,2);
        int cinco = 5;
        Fraccion r = a.Sumar(b);
        Fraccion q = a.Sumar(cinco);
        Fraccion s = a.Restar(b);
        Fraccion t = a.Restar(cinco);
        Fraccion v = a.Multiplicar(b);
        Fraccion w = a.Multiplicar(cinco);
        Fraccion y = a.Dividir(b);
        Fraccion z = a.Dividir(cinco);
        System.out.println(r.getNumerador()+"/"+r.getDenominador());
        System.out.println(q.getNumerador()+"/"+q.getDenominador());
        System.out.println(s.getNumerador()+"/"+s.getDenominador());
        System.out.println(t.getNumerador()+"/"+t.getDenominador());
        System.out.println(v.getNumerador()+"/"+v.getDenominador());
        System.out.println(w.getNumerador()+"/"+w.getDenominador());

        // Ejercicio 5
        Fecha fech = new Fecha(02,02,2021);
        System.out.println(fech.toString());
        fech.printGrego();

        // Ejercicio 6
        System.out.println(StringUtil.rpad("Magela",'c',4));
        System.out.println(StringUtil.lpad("Magela",'c',4));
        System.out.println(StringUtil.rtrim("   Magela Carballo"));
        System.out.println(StringUtil.ltrim("Magela Carballo   "));
        System.out.println(StringUtil.trim("   Magela Carballo   "));
        System.out.println(StringUtil.indexOfN("John|Paul|George|Ringo",'|',2));

    }
}
