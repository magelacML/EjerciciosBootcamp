package com.mercadolibre.starwars.service.impl;

import com.mercadolibre.starwars.dao.impl.ProductsRepositoryImpl;
import com.mercadolibre.starwars.exceptions.ProductNotfoundException;
import com.mercadolibre.starwars.model.request.CompraDTO;
import com.mercadolibre.starwars.model.request.ProductoCompraDTO;
import com.mercadolibre.starwars.model.response.ProductDTO;
import com.mercadolibre.starwars.service.ICompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraServiceImpl implements ICompraService {

    @Autowired
    private ProductsRepositoryImpl productsRepository;

    public CompraServiceImpl(ProductsRepositoryImpl productsRepository) {

        this.productsRepository = productsRepository;
    }


    @Override
    public Double calcularTotal(CompraDTO compraDTO) {
        double total = 0;
        for (ProductoCompraDTO p: compraDTO.getArticles()) {
            Integer id = p.getProductId();
            Integer quantity = p.getQuantity();
            Integer price = productsRepository.findById(id).getPrice();
            total = total + (quantity * price);
        }
        return total;
    }

}
