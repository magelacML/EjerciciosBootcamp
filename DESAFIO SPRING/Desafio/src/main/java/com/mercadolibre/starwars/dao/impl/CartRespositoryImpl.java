package com.mercadolibre.starwars.dao.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dao.ICartRepository;
import com.mercadolibre.starwars.exceptions.MissingFileException;
import com.mercadolibre.starwars.model.request.ProductPurchaseDTO;
import com.mercadolibre.starwars.model.request.PurchaseDTO;
import com.mercadolibre.starwars.model.response.ProductDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class CartRespositoryImpl implements ICartRepository {

    private PurchaseDTO dataCart;

    public CartRespositoryImpl() {
    }

    /**
     * Método para agregar articulos al carrito de compra. Recibe una solicitud de compra, reescribe el
     * username y agrega los articulos a los que ya existentes.
     * @param purchaseDTO recibe una solicitud de compra.
     */
    public void addData(PurchaseDTO purchaseDTO){

        dataCart.setUserName(purchaseDTO.getUserName()); // no valido si es diferente usuario, en principio debe ser siempre el mismo, despues modificar para que acepte varios
        List<ProductPurchaseDTO> ppOriginal = dataCart.getArticles();
        List<ProductPurchaseDTO> ppAgregar = purchaseDTO.getArticles();

        // Junto la lista de articulos no valido si se repiten
        List<ProductPurchaseDTO> ppNuevo = Stream.concat(ppOriginal.stream(), ppAgregar.stream())
                .collect(Collectors.toList());

        dataCart.setArticles(ppNuevo);
       /* writeJson();
        loadJson();*/

    }

    public PurchaseDTO getDataCart() {
        return dataCart;
    }

    public void setDataCart(PurchaseDTO dataCart) {
        this.dataCart = dataCart;
    }
// pruebo sin archivos, cargando el carrito en memoria
   /* private List<PurchaseDTO> loadJson() {
        File file = null;
        try {
            file = ResourceUtils.getFile("src/main/resources/data/cart_file.json");
        } catch (FileNotFoundException e) {
            throw new MissingFileException();
            // e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<PurchaseDTO>> typeReference = new TypeReference<>() {};
        List<ProductDTO> cart = null;

        try {
            cart = objectMapper.readValue(file, typeReference);
        } catch (IOException e) {
            throw new MissingFileException();
        }

        return cart;
    }

    private List<PurchaseDTO> writeJson() {
        File file = null;
        try {
            file = ResourceUtils.getFile("src/main/resources/data/cart_file.json");
        } catch (FileNotFoundException e) {
            throw new MissingFileException();
            // e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<PurchaseDTO>> typeReference = new TypeReference<>() {};
        List<PurchaseDTO> cart = null;

        try {
            objectMapper.writeValue(file, typeReference);
        } catch (IOException e) {
            throw new MissingFileException();
        }

        return cart;
    }*/

  /*  @Override
    public List<PurchaseDTO> listAllProducts() {
        return dataCart.getArticles();
    }*/


}
