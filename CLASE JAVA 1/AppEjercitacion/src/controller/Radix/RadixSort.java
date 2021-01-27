package controller.Radix;

import java.util.*;

public class RadixSort {

    /**
     * Imprime en pantalla un Array de tipo String
     * @param arr recibe el array tipo String a ordenar
     */
    public static void imprimirArray(String[] arr){
        for(String s:arr){
            System.out.println(s);
        }
    }

    /**
     * Recibe un array de String y un HashMap, la funcion pasa los valores del Array al Hashmap de forma ordenada
     * @param strArrCeros Array de String con los valores a distribuir
     * @param hashMap HashMap donde se distribuiran los valores que estan en el Array
     * @param posicion En base a que posicion (de atras para adelante) se ordenaran los elementos
     * @return Retorna un HashMap ordenados segun el digito seleccionado en posicion.
     */
    public static Map<Character,ArrayList> distribuirEnHash(String[] strArrCeros, Map<Character,
            ArrayList> hashMap, int posicion){
        for (String elemento: strArrCeros){
            Character ultimoCaracter = elemento.charAt(elemento.length()-posicion);
            hashMap.get(ultimoCaracter).add(elemento);
        }
        return hashMap;
    }

    /**
     * Recibe un HashMap para recrear un Array con todos los elementos del Hashmap
     * @param cantidadElementos cantidad de elementos que tendra el Array
     * @param hashDistribuido el hashmap con los datos
     * @return Retorna el Array de String con todos los elementos.
     */
    public static String[] rearmarString(int cantidadElementos,Map<Character,
            ArrayList> hashDistribuido){

        String[] nuevoArr = new String[cantidadElementos];
        int canElementos = 0;
        for (Map.Entry<Character, ArrayList> entry : hashDistribuido.entrySet()) {
            String [] valor = (String[]) entry.getValue().toArray(new String[entry.getValue().size()]);
            if (valor.length != 0){
                System.arraycopy(valor,0,nuevoArr,canElementos,valor.length);
                hashDistribuido.put(entry.getKey(),new ArrayList()); // Borro elementos existentes
            }
            canElementos = canElementos + valor.length;
        }
        return nuevoArr;
    }

    /**
     * Funcion RadixSort que ordena los elementos de un array
     * @param arr recibe el array a ordenar
     */
    public static void radixSort(int []arr) {

        int cantidadElementos = arr.length;

        // Paso uno - Ordenar int[] a String[]
        String [] strArr = StringUtil.intToStringArr(arr);
        imprimirArray(strArr);

        // Paso dos - Completar con Ceros
        String [] strArrCeros = StringUtil.agregarCeros(strArr);
        imprimirArray(strArrCeros);

        // Paso tres - Crear 10 instancias vacias
        Map<Character,ArrayList> hashMap = new HashMap<Character,ArrayList>();
        ArrayList al0 = new ArrayList();
        ArrayList al1 = new ArrayList();
        ArrayList al2 = new ArrayList();
        ArrayList al3 = new ArrayList();
        ArrayList al4 = new ArrayList();
        ArrayList al5 = new ArrayList();
        ArrayList al6 = new ArrayList();
        ArrayList al7 = new ArrayList();
        ArrayList al8 = new ArrayList();
        ArrayList al9 = new ArrayList();

        hashMap.put('0',al0);
        hashMap.put('1',al1);
        hashMap.put('2',al2);
        hashMap.put('3',al3);
        hashMap.put('4',al4);
        hashMap.put('5',al5);
        hashMap.put('6',al6);
        hashMap.put('7',al7);
        hashMap.put('8',al8);
        hashMap.put('9',al9);

        // Itero hasta ordenar (paso 4 a 7)
        int maximo = strArr[0].length();
        for (int posicion= 1; posicion<= maximo;posicion++){

            // Paso cuatro - Recorrer String[] y verificar elemento
            Map<Character,ArrayList> hashDistribuido = distribuirEnHash(strArrCeros,hashMap,posicion);

            // Paso cinco - Rearmar String[]
            strArrCeros = rearmarString(cantidadElementos,hashDistribuido);

        }
        System.out.println("Resultado");
        imprimirArray(strArrCeros);
    }


    public static void main(String[] args) {
        int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
        RadixSort.radixSort(arr);

    }
}
