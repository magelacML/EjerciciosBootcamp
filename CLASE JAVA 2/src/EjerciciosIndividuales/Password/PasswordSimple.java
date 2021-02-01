package EjerciciosIndividuales.Password;

import EjerciciosIndividuales.Password.Password;

public class PasswordSimple extends Password {
    private static String regex = "^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$";
    // Entre 8 y 16 caracteres
    // al menos un digito
    // al menos una minuscula
    // al menos una mayuscula
    // no puede tener simbolos

    public PasswordSimple(String pass) {
        super(regex,pass);
        setRegex(regex);
    }




}
