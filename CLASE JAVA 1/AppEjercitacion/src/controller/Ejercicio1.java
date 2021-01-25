package controller;
import java.util.Scanner;

/***
 * Desarrollar un programa para mostrar los primeros n números pares,
 * siendo n un valor que el usuario ingresará por consola.
 */
public class Ejercicio1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un numero");

        int n = scanner.nextInt();
        int i = 0;

        while (i < n){
            System.out.println(i*2);
            i++;
        }
    }
}
