package controller.Ejercicios;
import java.util.Scanner;

/**
 * Desarrollar un programa para mostrar los primeros n múltiplos m,
 * siendo n y m valores que el usuario ingresarà por consola.
 */
public class Ejercicio2 {
    public static void main(String[] args) {
        int i;
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
