package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.model.response.ProductDTO;

import java.util.List;

public interface IFindProductsService {
    List<ProductDTO> findCategory(String category, String order);
    List<ProductDTO> listProducts(String order);
    List<ProductDTO> filterProducts(String category, String freeshipping,String order );
}
