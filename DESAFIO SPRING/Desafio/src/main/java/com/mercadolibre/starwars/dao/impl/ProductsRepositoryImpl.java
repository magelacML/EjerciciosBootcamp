package com.mercadolibre.starwars.dao.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dao.IProductsRepository;
import com.mercadolibre.starwars.exceptions.MissingFileException;
import com.mercadolibre.starwars.exceptions.ProductNotfoundException;
import com.mercadolibre.starwars.model.response.ProductDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductsRepositoryImpl implements IProductsRepository {

    private List<ProductDTO> data;

    public ProductsRepositoryImpl() {

        this.data = loadJson(); // se guarda el contenido del archivo en data para poder se utilizado
    }

    public List<ProductDTO> getData() {
        return data;
    }

    public void setData(List<ProductDTO> data) {
        this.data = data;
    }

    /**
     * Cargar los datos del archivo products_file.json
     * @return devuelve los datos del archivo en una lista de Productos
     */
    private List<ProductDTO> loadJson() {
        File file = null;
        try {
            file = ResourceUtils.getFile("src/main/resources/data/products_file.json");
        } catch (FileNotFoundException e) {
            throw new MissingFileException();
            // e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<ProductDTO>> typeReference = new TypeReference<>() {};
        List<ProductDTO> personajes = null;

        try {
            personajes = objectMapper.readValue(file, typeReference);
        } catch (IOException e) {
            throw new MissingFileException();
        }

        return personajes;
    }

    /**
     * Metodo que recibe un string y busca en los productos almacenados en data
     * cuales corresponden a la categoria pasada por parametro.
     * @param category nombre de la categoria
     * @return lista de productos que se encuentran en esa categoria
     */
    @Override
    public List<ProductDTO> findByCategory(String category){
        List<ProductDTO> resultado = data
                .stream()
                .filter(p -> p.getCategory().contains(category))
                .collect(Collectors.toList());
        return resultado;
    }

    /**
     * Metodo que retorna todos los productos que hay en data.
     * @return lista de todos los productos existentes.
     */
    @Override
    public List<ProductDTO> listAllProducts() {
        return data;
    }

    /**
     * metodo que realiza un filtrado de los productos. Segun su categoria y su Freeshipping
     * @param category string que contiene la categoria a filtrar
     * @param freeshipping String que corresponde a si filtrar con freeshipping o sin freeshiping
     * @return Lista de productos filtrados segun los datos pasados.
     */
    @Override
    public List<ProductDTO> filterProducts(String category, String freeshipping) {
        List<ProductDTO> result = findByCategory(category)
                .stream()
                .filter(p -> p.getFreeshipping().equals(Integer.valueOf(freeshipping)))
                .collect(Collectors.toList());
        return result;
    }

    /**
     * Metodo que busca un producto por su id.
     * @param id Entero que corresponde al id a buscar
     * @return Devuelve el producto que tiene ese id
     */
    @Override
    public ProductDTO findById(Integer id){
        for (ProductDTO p: data ) {
            if (p.getId().equals(id)){
                return p;
            }
        }
        throw new ProductNotfoundException();
    }
}