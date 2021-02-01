package EjerciciosGrupal;

public class StringUtil {

    public static String rpad(String s, char c, int n){
        String nuevoStr = s;
        for (int i = 0; i < n; i++) {
            nuevoStr = nuevoStr + "c";
        }
        return nuevoStr;
    }

    public static String lpad(String s, char c, int n){
        String nuevoStr = "";
        for (int i = 0; i < n; i++) {
            nuevoStr = nuevoStr + "c";
        }
        nuevoStr = nuevoStr + s;

        return nuevoStr;
    }

    public static String rtrim(String s){
        String nuevoStr = "";
        int i=0;

        while ( s.toCharArray()[i] == ' ') {
            i++;
        }
        for (int j = i; j < s.length(); j++) {
            nuevoStr = nuevoStr + s.toCharArray()[j];
        }
        return nuevoStr;
    }

    public static String ltrim(String s){
        StringBuilder b = new StringBuilder(s);
        String s2= b.reverse().toString();

        String nuevoStr = "";
        int i=0;

        while ( s2.toCharArray()[i] == ' ') {
            i++;
        }
        for (int j = i; j < s2.length(); j++) {
            nuevoStr = nuevoStr + s2.toCharArray()[j];
        }

        StringBuilder b2 = new StringBuilder(nuevoStr);
        String resultado = b2.reverse().toString();
        return resultado;
    }

    public static String trim(String s){
      return rtrim(ltrim(s));
    }

    public static int indexOfN(String s, char c, int n){
        int contador = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.toCharArray()[i] == c){
                contador++;
            }
            if (contador == n){
                return i;
            }
        }
        return -1;
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
