package EjerciciosIndividuales.Password;

import EjerciciosIndividuales.Password.Password;

public class PasswordIntermedia extends Password {
    private static String regex = "^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$";
    // Entre 8 y 16 caracteres
    // al menos un digito
    // al menos una minuscula
    // al menos una mayuscula
    // puede tener simbolos

    public PasswordIntermedia(String pass) {
        super(regex, pass);
        setRegex(regex);
    }
}
