package com.mercadolibre.starwars.Utils;

import com.mercadolibre.starwars.model.response.ProductDTO;

import java.util.*;

public class Sorter {

    public static List<ProductDTO> OrdenarNombreAsc(List<ProductDTO> list){

        Map<ProductDTO,String> hashMap = new HashMap<ProductDTO,String>();

        for (ProductDTO p: list) {
            hashMap.put(p,p.getName());
        }

        List<ProductDTO> valoresOrdenados = new ArrayList<>();
        hashMap.entrySet()
                .stream()
                .sorted(Comparator.comparing(x -> x.getValue()))
                .forEach(x -> valoresOrdenados.add(x.getKey()));

        return valoresOrdenados;
    }

    public static List<ProductDTO> OrdenarNombreDesc(List<ProductDTO> list){
        List<ProductDTO> valoresOrdenados = OrdenarNombreAsc(list);
        Collections.reverse(valoresOrdenados);

        return valoresOrdenados;

    }


    public static List<ProductDTO> OrdenarPrecioMayor(List<ProductDTO> list){
        List<ProductDTO> valoresOrdenados = OrdenarPrecioMenor(list);
        Collections.reverse(valoresOrdenados);

        return valoresOrdenados;
    }

    public static List<ProductDTO> OrdenarPrecioMenor(List<ProductDTO> list){
        Map<ProductDTO,Integer> hashMap = new HashMap<ProductDTO,Integer>();

        for (ProductDTO p: list) {
            hashMap.put(p,p.getPrice());
        }

        List<ProductDTO> valoresOrdenados = new ArrayList<>();
        hashMap.entrySet()
                .stream()
                .sorted(Comparator.comparing(x -> x.getValue()))
                .forEach(x -> valoresOrdenados.add(x.getKey()));

        return valoresOrdenados;

    }

}
