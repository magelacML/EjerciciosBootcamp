package com.mercadolibre.starwars.dao;

import com.mercadolibre.starwars.model.request.PurchaseDTO;
import com.mercadolibre.starwars.model.response.ProductDTO;

import java.util.List;

public interface ICartRepository {
    void addData(PurchaseDTO purchaseDTO);
    }
