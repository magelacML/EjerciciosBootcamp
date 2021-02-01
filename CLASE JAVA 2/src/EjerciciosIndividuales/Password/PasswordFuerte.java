package EjerciciosIndividuales.Password;

import EjerciciosIndividuales.Password.Password;

public class PasswordFuerte extends Password {
     private static String regex = "^(?=.*\\d)(?=.*[\\u0021-\\u002b\\u003c-\\u0040])(?=.*[A-Z])(?=.*[a-z])\\S{8,16}$";

    //  Minimo 8 caracteres
    //  Maximo 16 caracteres
    //  Al menos una letra mayuscula
    //  Al menos una letra minuscula
    //  Al menos un digito
    //  Al menos 1 caracter especial

    public PasswordFuerte(String pass) {
        super(regex, pass);
    }
}
