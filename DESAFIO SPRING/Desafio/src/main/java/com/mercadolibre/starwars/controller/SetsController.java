package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.exceptions.ProductNotfoundException;
import com.mercadolibre.starwars.model.request.CompraDTO;
import com.mercadolibre.starwars.model.response.ErrorDTO;
import com.mercadolibre.starwars.service.impl.CompraServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SetsController {
    private final CompraServiceImpl compraService;

    public SetsController(CompraServiceImpl compraService){
        this.compraService = compraService;
    }

    @PostMapping(value="/api/v1/purchase-request")
    public Double precioTotal(@RequestBody CompraDTO compra){
        Double precio = compraService.calcularTotal(compra);
        return precio;
    }

    @ExceptionHandler(ProductNotfoundException.class)
    public ResponseEntity<ErrorDTO> handleException(ProductNotfoundException productNotFound){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setName(productNotFound.getNombre());
        errorDTO.setDescripcion(productNotFound.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }





}

