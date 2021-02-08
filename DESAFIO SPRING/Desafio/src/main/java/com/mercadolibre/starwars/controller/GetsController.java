package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.model.response.ProductDTO;
import com.mercadolibre.starwars.service.impl.FindProductsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class GetsController {
    @Autowired
    private FindProductsServiceImpl findProductsService;

    /**
     * GET para obtener la lista de productos disponibles con todos sus datos.
     * @return Lista de Productos
     */
    @GetMapping(value = "/articles", params = {})
    public List<ProductDTO> listProduct() {
        return findProductsService.listProducts("");
    }

    /**
     * GET para obtener la lista de productos disponibles de forma ordenada.
     * @param order 0 ordena por nombre asc, 1 nombre desc, 2 precio mayor a menor, 3 precio menor a mayor.
     * @return Lista de Productos ordanda.
     */
    @GetMapping(value = "/articles", params = {"order"})
    public List<ProductDTO> listProduct(@RequestParam(required = false, defaultValue = "")  String order) {
        return findProductsService.listProducts(order);
    }

    /**
     * GET que recibe un parametro de categoria y devuelve una lista de los productos de esa categoria
     * @param category un String con una categoria
     * @return Devuelve una lista de Productos correspondientes a esa categoria.
     */
    @GetMapping(value = "/articles", params = {"category"})
    public List<ProductDTO> findCategory(@RequestParam String category) {
        return findProductsService.findCategory(category,"");
    }

    /**
     * GET que recibe un parametro de categoria y un tipo de orden
     * @param category un String con una categoria
     * @param order 0 ordena por nombre asc, 1 nombre desc, 2 precio mayor a menor, 3 precio menor a mayor.
     * @return Devuelve una lista de Productos correspondientes a esa categoria de forma ordenada.
     */
    @GetMapping(value = "/articles", params = {"category","order"})
    public List<ProductDTO> findCategoryOrdered(@RequestParam String category,
                                                @RequestParam(required = false, defaultValue = "")  String order) {
        return findProductsService.findCategory(category,order);
    }

    /**
     * GET que recibe una categoria y si el producto es freeshipping o no.
     * @param category un string con la categoria a filtrar
     * @param freeshipping un numero 1 o 0 segun si quiero filtrar por freeshipping o sin freeshipping
     * @return Devuelve una lista de Productos que cumplen que estan en la categoria y en el freeshipping seleccionado.
     */
    @GetMapping(value = "/articles", params = {"category","freeshipping"})
    public List<ProductDTO> filterProduct(@RequestParam String category, @RequestParam  String freeshipping) {
        return findProductsService.filterProducts(category,freeshipping,"");
    }

    /**
     * GET que recibe una categoria y si el producto es freeshipping o no, tambien si se quiere ordenar el resultado.
     * @param category un string con la categoria a filtrar
     * @param freeshipping un numero 1 o 0 segun si quiero filtrar por freeshipping o sin freeshipping
     * @param order 0 ordena por nombre asc, 1 nombre desc, 2 precio mayor a menor, 3 precio menor a mayor.
     * @return Devuelve una lista de Productos que cumple los filtros y esta ordenada.
     */
    @GetMapping(value = "/articles", params = {"category","freeshipping","order"})
    public List<ProductDTO> filterProductOrdered(@RequestParam String category, @RequestParam  String freeshipping,
                                                 @RequestParam(required = false, defaultValue = "")  String order) {
        return findProductsService.filterProducts(category,freeshipping,order);
    }
}
