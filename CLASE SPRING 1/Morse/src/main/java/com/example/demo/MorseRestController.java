package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MorseRestController {
    @GetMapping(path = "/{frase}")
    public String convertirMorse(@PathVariable String frase) {

        String resultado = "";

        Map<Character,String> map = new HashMap<Character,String>();
        map.put('A',".-");
        map.put('B',"-...");
        map.put('C',"-.-.");
        map.put('D',"-..");
        map.put('E',".");
        map.put('F',"..-.");
        map.put('G',"--.");
        map.put('H',"....");
        map.put('I',"..");
        map.put('J',".---");
        map.put('K',"-.-");
        map.put('L',".-..");
        map.put('M',"--");
        map.put('N',"-.");
        map.put('O',"---");
        map.put('P',".--.");
        map.put('Q',"--.-");
        map.put('R',".-.");
        map.put('S',"...");
        map.put('T',"-");
        map.put('U',"..-");
        map.put('V',"...-");
        map.put('W',".--");
        map.put('X',"-..-");
        map.put('Y',"-.--");
        map.put('Z',"--..");
        map.put('1',".----");
        map.put('2',"..---");
        map.put('3',"...--");
        map.put('4',"....-");
        map.put('5',".....");
        map.put('6',"-....");
        map.put('7',"--...");
        map.put('8',"---..");
        map.put('9',"----.");
        map.put('0',"-----");
        map.put(' ',"   ");

        // CONVERTIR A MAYUSCULA TODA LA FRASE
        frase = (frase.toUpperCase());

        for (char c: frase.toCharArray ()){
            resultado = resultado + " " + map.get(c);
        }


        return "Frase: " + frase + " en Morse es:"+ resultado;
    }
}
