package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RomanoRestController {
    @GetMapping(path = "/{numero}")
    public String convertirRomano(@PathVariable int numero) {

        String resultado = "";

        Map<Integer,Character> map = new HashMap<Integer,Character>();
        map.put(1,'I');
        map.put(5,'V');
        map.put(10,'X');
        map.put(50,'L');
        map.put(100,'C');
        map.put(500,'D');
        map.put(1000,'M');

        int mil = numero/1000;
        int centenas = (numero / 100) % 10;
        int decenas = numero/10%10;
        int unidades = numero%10;

        // miles
        for (int i=1; i<= mil; i++){
            resultado = resultado + map.get(1000);
        }

        // centenas
        if (centenas == 9){
            resultado = resultado + map.get(100) + map.get(1000);
        } else if (centenas >=5){
            resultado = resultado + map.get(500);
            for (int i = 6; i<=centenas; i++){
                resultado = resultado + map.get(100);
            }
        } else if( centenas == 4 ) {
            resultado = resultado + map.get(100) + map.get(500);
        } else {
            for (int i=1; i<= centenas; i++){
                resultado = resultado + map.get(100);
            }
        }

        // decenas
        if (decenas == 9) {
            resultado = resultado + map.get(10) + map.get(100);
        } else if (decenas >= 5) {
            resultado = resultado + map.get(50);
            for (int i = 6; i <= decenas; i++) {
                resultado = resultado + map.get(10);
            }
        } else if (decenas == 4) {
            resultado = resultado + map.get(10)+map.get(50);
        } else {
            for (int i = 1; i <= decenas; i++) {
                resultado = resultado + map.get(10);
            }
        }

        // unidad
        if (unidades == 9) {
            resultado = resultado + map.get(1) + map.get(10);
        } else if (unidades >= 5) {
            resultado = resultado + map.get(5);
            for (int i = 6; i <= unidades; i++) {
                resultado = resultado + map.get(1);
            }
        } else if (unidades == 4) {
            resultado = resultado + map.get(1)+ map.get(5);
        } else {
            for (int i = 1; i <= unidades; i++) {
                resultado = resultado + map.get(1);
            }
        }


        return "El numero: " + numero + " En romano es: "+resultado;
    }
}
