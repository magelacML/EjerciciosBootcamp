package controller;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        int i=0;
        Scanner scanner=new Scanner(System.in);

        System.out.print("Ingrese un valor n: ");
        int n = scanner.nextInt();
        System.out.print("Ingrese un valor m: ");
        int m = scanner.nextInt();

        for(i=1;i<=n;i++)
        {
            System.out.println("El numero es multiplo= " + i*m);
        }

    }
}
