package com.mercadolibre.starwars.dao.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dao.IProductsRepository;
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

        this.data = loadJson();
    }

    public List<ProductDTO> getData() {
        return data;
    }

    public void setData(List<ProductDTO> data) {
        this.data = data;
    }

    private List<ProductDTO> loadJson() {
        File file = null;
        try {
            file = ResourceUtils.getFile("src/main/resources/data/products_file.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<ProductDTO>> typeReference = new TypeReference<>() {};
        List<ProductDTO> personajes = null;

        try {
            personajes = objectMapper.readValue(file, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return personajes;
    }

    @Override
    public List<ProductDTO> findByCategory(String category){
        List<ProductDTO> resultado = data
                .stream()
                .filter(p -> p.getCategory().contains(category))
                .collect(Collectors.toList());
        return resultado;
    }

    @Override
    public List<ProductDTO> listAllProducts() {
        return data;
    }

    @Override
    public List<ProductDTO> filterProducts(String category, String freeshipping) {
        List<ProductDTO> result = findByCategory(category)
                .stream()
                .filter(p -> p.getFreeshipping().equals(Integer.valueOf(freeshipping)))
                .collect(Collectors.toList());
        return result;
    }

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