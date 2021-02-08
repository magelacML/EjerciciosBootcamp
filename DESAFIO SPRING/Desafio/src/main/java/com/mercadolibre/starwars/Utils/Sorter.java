package com.mercadolibre.starwars.Utils;

import com.mercadolibre.starwars.model.response.ProductDTO;

import java.util.*;

/**
 * Clase auxiliar para realizar ordenamientos
 */
public class Sorter {

    /**
     * MEtodo para ordenar una lista de productos por su nombre de forma ascendente.
     * @param list lista de productos
     * @return lista de produtos ordenada
     */
    public static List<ProductDTO> sortNameAsc(List<ProductDTO> list){

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

    /**
     * Metodo para ordenar la lista de productos por su nombre de forma descendente
     * @param list lista de productos
     * @return lista de productos ordenada de forma descendente
     */
    public static List<ProductDTO> sortNameDesc(List<ProductDTO> list){
        List<ProductDTO> valoresOrdenados = sortNameAsc(list);
        Collections.reverse(valoresOrdenados);

        return valoresOrdenados;

    }

    /**
     * Metodo para ordenar una lista de productos de mayor precio a menor precio
     * @param list lista de productos a ordenar
     * @return lista de productos ordenada de mayor a menor precio
     */
    public static List<ProductDTO> sortPriceDesc(List<ProductDTO> list){
        List<ProductDTO> valoresOrdenados = sortPriceAsc(list);
        Collections.reverse(valoresOrdenados);

        return valoresOrdenados;
    }

    /**
     * Metodo para ordenar una lista de productos de menor a mayor precio
     * @param list lista de productos a ordenar
     * @return lista de productos ordenados de menor a meyor precio.
     */
    public static List<ProductDTO> sortPriceAsc(List<ProductDTO> list){
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
