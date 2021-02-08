package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.model.request.PurchaseDTO;

public interface IPurchaseService {
    Double totalPrice(PurchaseDTO productDTO);
    Integer totalQuantity(PurchaseDTO purchaseDTO);
    boolean stockExist(Integer id, Integer quentity);

    Double totalPriceCart();
    Integer totalQuantityCart();
    }
