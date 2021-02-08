package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.exceptions.MissingFileException;
import com.mercadolibre.starwars.exceptions.ProductNotfoundException;
import com.mercadolibre.starwars.exceptions.StockNotFoundException;
import com.mercadolibre.starwars.model.request.PurchaseDTO;
import com.mercadolibre.starwars.model.response.ErrorDTO;
import com.mercadolibre.starwars.model.response.PurchaseResponseDTO;
import com.mercadolibre.starwars.service.impl.PurchaseServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostsController {
    private final PurchaseServiceImpl purchaseService;

    public PostsController(PurchaseServiceImpl purchaseService){
        this.purchaseService = purchaseService;
    }

    /**
     * POST para una solicitud de Compra
     * @param purchaseDTO recibe un purchaseDTO
     * @return retorna Respuesta de esa solicitud
     */
    @PostMapping(value="/api/v1/purchase-request")
    public PurchaseResponseDTO precioTotal(@RequestBody PurchaseDTO purchaseDTO){
        Double price = purchaseService.totalPrice(purchaseDTO);
        Integer quantity = purchaseService.totalQuantity(purchaseDTO);
        return new PurchaseResponseDTO(purchaseDTO.getUserName(),quantity,price);
    }

    /**
     * POST para una solicitud de agregar una solicitud de compra al carrito
     * @param purchaseDTO recibe un purchaseDTO
     * @return retorna Respuesta de esa solicitud
     */
    @PostMapping(value="/api/v1/add-to-cart")
    public PurchaseResponseDTO addToCart(@RequestBody PurchaseDTO purchaseDTO){
        purchaseService.addToCart(purchaseDTO);
        Double price = purchaseService.totalPriceCart();
        Integer quantity = purchaseService.totalQuantityCart();
        return new PurchaseResponseDTO(purchaseDTO.getUserName(),quantity,price);
    }

    /**
     * Excepcion para cuando no se encuentra el producto solicitado.
     * @param productNotFound
     * @return Error correspondiente
     */
    @ExceptionHandler(ProductNotfoundException.class)
    public ResponseEntity<ErrorDTO> handleExceptionNotFound(ProductNotfoundException productNotFound){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setName(productNotFound.getName());
        errorDTO.setDescription(productNotFound.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    /**
     * Excepcion para cuando no se encuentra el archivo que se quiere utilizar
     * @param exception
     * @return Error correspondiente
     */
    @ExceptionHandler(MissingFileException.class)
    public ResponseEntity<ErrorDTO> handleMissingFile(MissingFileException exception){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setName(exception.getName());
        errorDTO.setDescription(exception.getMessage());

        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    /**
     * Excepcion para cuando el Stock no es suficiente
     * @param exception
     * @return Error correspondiente
     */
    @ExceptionHandler(StockNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleExceptionStock(StockNotFoundException exception){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setName(exception.getName());
        errorDTO.setDescription(exception.getMessage());

        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

  /*  @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ProductNotfoundException.class)
    public ResponseEntity<ErrorDTO> handleExceptionBadRequest(BadRequest badRequest){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setName(badRequest.getName());
        errorDTO.setDescripcion(badRequest.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }*/
  /*  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ProductNotfoundException.class)
    public ResponseEntity<ErrorDTO> handleExceptionInternalServer(InternalErrorException internalErrorException){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setName(internalErrorException.getName());
        errorDTO.setDescripcion(internalErrorException.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }*/








}

