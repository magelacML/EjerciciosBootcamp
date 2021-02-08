package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.model.request.CompraDTO;
import com.mercadolibre.starwars.model.response.ProductDTO;

import java.util.List;

public interface ICompraService {
    Double calcularTotal (CompraDTO productDTOList);
}
