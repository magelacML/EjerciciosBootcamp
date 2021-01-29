package Controller;

public class StringUtil {

    public static String rpad(String s, char c, int n){

    }

    public static String lpad(String s, char c, int n){

    }






    public static String[] intToStringArr(int[] arr){
        String strArray[] = new String[arr.length];
        int i = 0;
        for (int elemento: arr){
            strArray[i] = String.valueOf(elemento);
            i++;
        }
        return strArray;
    }

    public static int cantidadMayor(String[] strArr)
    {
        int cantidad = strArr[0].length();
        for(String elemento: strArr){
            if ( cantidad < elemento.length() ){
                cantidad = elemento.length();
            }
        }
        return cantidad;
    }

    public static String[] agregarCeros(String[] strArr){
        int cantidad = cantidadMayor(strArr);
        String [] nuevoArray = new String[strArr.length];
        int posicion = 0;
        for (String elemento: strArr){
            nuevoArray[posicion] = String.format("%0"+cantidad+"d",Integer.valueOf(elemento));
        //    System.out.println(nuevoArray[posicion]);
            posicion++;
        }
        return nuevoArray;
    }
}
