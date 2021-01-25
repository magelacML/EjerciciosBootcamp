package controller;
import java.util.Scanner;

/**
 * Desarrollar un programa para mostrar por consola los primeros n números primos,
 * siendo n un valor que el usuario ingresarà por consola.
 */
public class Ejercicio4 {
    public static boolean esPrimo(int n){

        int contador = 0;

        for(int i=2; i<n; i++){
            if (n%i == 0){
                contador++;
            }
        }

        if (contador == 0 ){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        System.out.print("Ingrese un valor n: ");
        int n = scanner.nextInt();

        for(int i=1;i<=n;i++)
        {
            if(esPrimo(i))
            {
                System.out.println(i);
            }
        }
    }
}
