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

    @GetMapping(value = "/articles", params = {})
    public List<ProductDTO> listProduct() {
        return findProductsService.listProducts("");
    }

    @GetMapping(value = "/articles", params = {"order"})
    public List<ProductDTO> listProduct(@RequestParam(required = false, defaultValue = "")  String order) {
        return findProductsService.listProducts(order);
    }

    @GetMapping(value = "/articles", params = {"category"})
    public List<ProductDTO> findCategory(@RequestParam String category) {
        return findProductsService.findCategory(category,"");
    }

    @GetMapping(value = "/articles", params = {"category","order"})
    public List<ProductDTO> findCategoryOrdered(@RequestParam String category,
                                                @RequestParam(required = false, defaultValue = "")  String order) {
        return findProductsService.findCategory(category,order);
    }

    @GetMapping(value = "/articles", params = {"category","freeshipping"})
    public List<ProductDTO> filterProduct(@RequestParam String category, @RequestParam  String freeshipping) {
        return findProductsService.filterProducts(category,freeshipping,"");
    }

    @GetMapping(value = "/articles", params = {"category","freeshipping","order"})
    public List<ProductDTO> filterProductOrdered(@RequestParam String category, @RequestParam  String freeshipping,
                                                 @RequestParam(required = false, defaultValue = "")  String order) {
        return findProductsService.filterProducts(category,freeshipping,order);
    }
}
