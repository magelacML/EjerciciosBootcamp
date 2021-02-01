package EjerciciosIndividuales.Password;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {

    private String strPass;
    private String regex;

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public Password(String regex, String pass) {
        this.setRegex(regex);
        this.setValue(pass);
    }

    public Boolean validarPass(String pass){
        Pattern r = Pattern.compile(this.regex);
        Matcher m = r.matcher(pass);
        if (!m.find()){
            return false;
        }else{
            return true;
        }
    }

    public void setValue(String pwd){
        if (validarPass(pwd)){
            this.strPass = pwd;
            System.out.println("Contraseña ingresada correctamente");
        }else{
            throw new RuntimeException("La contraseña no cumple con los criterios");
        }
    }



}
