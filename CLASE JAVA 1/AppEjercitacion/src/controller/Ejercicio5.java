package controller;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Desarrollar un programa para mostrar por consola los primeros n números naturales
 * que tienen al menos m digitos d, siendo n,m y d valores que ingresarà por consola.
 */
public class Ejercicio5 {

    public static int cuentaOcc(String digit, String numero){
        Pattern pattern = Pattern.compile(digit);
        Matcher matcher = pattern.matcher(numero);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
       // int val=cuentaOcc("9","303"); // retorna la cantidad de veces de la ocurrencia
      //  System.out.println("la count = " + val);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese cantidad de numeros: ");
        int n = scanner.nextInt();
        System.out.print("Ingrese cantidad de repeticiones: ");
        int m = scanner.nextInt();
        System.out.print("Ingrese el digito repetido: ");
        int d = scanner.nextInt();

        int contador = 0;
        int numeroBase=0;
        int ocurrencia=0;

        while (contador <n) {
            //String str_numeros = Integer.toString(numeros);
            String strNumber=Integer.toString(numeroBase);
            ocurrencia=cuentaOcc(String.valueOf(d),strNumber);

            if(ocurrencia==m)
            {
                System.out.println("strNumber = " + strNumber);
                contador++;
            }
            numeroBase++;
        }
    }
}
