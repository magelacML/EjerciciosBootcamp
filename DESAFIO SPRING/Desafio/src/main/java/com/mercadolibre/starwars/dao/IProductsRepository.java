package com.mercadolibre.starwars.dao;

import com.mercadolibre.starwars.model.response.ProductDTO;

import java.util.List;

public interface IProductsRepository {
    List<ProductDTO> findByCategory(String category);
    List<ProductDTO> listAllProducts();
    List<ProductDTO> filterProducts(String category, String freeshipping);
    ProductDTO findById(Integer id);

}
