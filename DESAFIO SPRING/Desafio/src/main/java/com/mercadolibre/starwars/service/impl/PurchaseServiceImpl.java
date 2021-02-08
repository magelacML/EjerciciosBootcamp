package com.mercadolibre.starwars.service.impl;

import com.mercadolibre.starwars.dao.impl.CartRespositoryImpl;
import com.mercadolibre.starwars.dao.impl.ProductsRepositoryImpl;
import com.mercadolibre.starwars.exceptions.StockNotFoundException;
import com.mercadolibre.starwars.model.request.PurchaseDTO;
import com.mercadolibre.starwars.model.request.ProductPurchaseDTO;
import com.mercadolibre.starwars.service.IPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements IPurchaseService {

    @Autowired
    private ProductsRepositoryImpl productsRepository;
    private CartRespositoryImpl cartRespository;

    public PurchaseServiceImpl(ProductsRepositoryImpl productsRepository, CartRespositoryImpl cartRespository) {

        this.productsRepository = productsRepository;
        this.cartRespository = cartRespository;
    }

    /**
     * Agregar una solicitud de compra al carrito
     * @param purchaseDTO recibe una solicitu de compra
     */
    public void addToCart(PurchaseDTO purchaseDTO){
        cartRespository.addData(purchaseDTO);
    }

    /**
     * Calcular precio total de una solicitud de compra. Para ello se recorren todos los articulos de la solicitud
     * y se suma el precio. Cuando se suma el precio se valida el stock, de no haberlo se mostrará un mensaje al usuario.
     * @param purchaseDTO recibe una solicitud de compra
     * @return un Double con el precio total de la solicitud.
     */
    @Override
    public Double totalPrice(PurchaseDTO purchaseDTO) {
        double total = 0;
        for (ProductPurchaseDTO p: purchaseDTO.getArticles()) {
            Integer id = p.getProductId();
            Integer quantity = p.getQuantity();
            Integer price = productsRepository.findById(id).getPrice();

            // Valido stock
            if (stockExist(id,quantity)){
                total = total + (quantity * price);
            }else{
                throw new StockNotFoundException();
            }
        }
        return total;
    }

    /**
     * Calculo del precio total de un carrito de compras, un carrito es una solicitud de compra que se va a actualizando.
     * @return Double con el precio total del carrito
     */
    @Override
    public Double totalPriceCart() {
        double total = 0;
        for (ProductPurchaseDTO p: cartRespository.getDataCart().getArticles()) {
            Integer id = p.getProductId();
            Integer quantity = p.getQuantity();
            Integer price = productsRepository.findById(id).getPrice();
            total = total + (quantity * price);

        }
        return total;
    }

    /**
     * Calculo de Cantidad de articulos que hay en una solicitud de compras
     * @param purchaseDTO solicitud de compra
     * @return Entero con la cantidad de articulos
     */
    @Override
    public Integer totalQuantity(PurchaseDTO purchaseDTO){
        Integer quantity = 0;
        for (ProductPurchaseDTO p: purchaseDTO.getArticles()) {
           quantity = quantity + p.getQuantity();
        }
        return quantity;
    }

    /**
     * Calculo de la cantidad de articulos del carrito de compras
     * @return cantidad de articulos
     */
    @Override
    public Integer totalQuantityCart(){
        Integer quantity = 0;
        for (ProductPurchaseDTO p: cartRespository.getDataCart().getArticles()) {
            quantity = quantity + p.getQuantity();
        }
        return quantity;
    }

    /**
     * Se valida si hay stock suficiente para una solicitud de compras.
     * @param id id del producto a chequear
     * @param quentity cantidad que se quiere comprar
     * @return true si hay stock, false si no hay stock suficiente
     */
    @Override
    public boolean stockExist(Integer id, Integer quentity){
        if (productsRepository.findById(id).getQuantity().compareTo(quentity) < 0){
            return false;
        }else{
            return true;
        }
    }

}
