package com.mercadolibre.starwars.service.impl;

import com.mercadolibre.starwars.Utils.Sorter;
import com.mercadolibre.starwars.dao.impl.ProductsRepositoryImpl;
import com.mercadolibre.starwars.model.response.ProductDTO;
import com.mercadolibre.starwars.service.IFindProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindProductsServiceImpl implements IFindProductsService {
    @Autowired
    private ProductsRepositoryImpl productDao;

    public FindProductsServiceImpl(ProductsRepositoryImpl productoDao) {

        this.productDao = productoDao;
    }

    /**
     * Listar productos en base a un orden.
     * @param order tipo de orden que se quiere realizar
     * @return lista de productos ordenada
     */
    @Override
    public List<ProductDTO> listProducts(String order) {
        List<ProductDTO> result = productDao.listAllProducts();
        List<ProductDTO> ordered = SortProducts(result,order);
        return ordered;
    }

    /**
     * Encontrar productos en una determinada categoria y de forma ordenada
     * @param category string del nombre de la categoria
     * @param order orden especificado
     * @return Lista de Productos en la categoria correspondiente en el orden solicitado
     */
    @Override
    public List<ProductDTO> findCategory(String category, String order) {
        List<ProductDTO> result = productDao.findByCategory(category);
        List<ProductDTO> ordered = SortProducts(result,order);
        return ordered;
    }

    /**
     * Filtrar Productos segun categoria, freeshipping y algun orden seleccionado
     * @param category nombre de la categoria
     * @param freeshipping con freeshiping o sin freeshipping
     * @param order tipo de orden
     * @return lista filtrada ordenada
     */
    @Override
    public List<ProductDTO> filterProducts(String category, String freeshipping, String order) {
        List<ProductDTO> filtered = productDao.filterProducts(category,freeshipping);

        List<ProductDTO> ordered = SortProducts(filtered,order);

       return ordered;
    }

    /**
     * Ordenar una lista de productos, segun un orden dado.
     * @param filtered lista a ordenar
     * @param order tipo de orden a aplicar (0=nombre asc, 1= nombre desc, 2=mayor precio, 3=menor precio,
     *              cualquier otra cosa= sin orden definido)
     * @return Lista de productos ordenado
     */
    public List<ProductDTO> SortProducts(List<ProductDTO> filtered,String order){
        List<ProductDTO> ordered;
        switch (order){
            case "0": // La lista ordenada por Nombre Asc
                ordered = Sorter.sortNameAsc(filtered);
                break;
            case "1": // La lista ordenada por Nombre Desc
                ordered = Sorter.sortNameDesc(filtered);
                break;
            case "2": // La lista ordenada por mayor precio
                ordered = Sorter.sortPriceDesc(filtered);
                break;
            case "3": // La lista ordenada por menor precio
                ordered = Sorter.sortPriceAsc(filtered);
                break;
            default: // Como viene la lista
                ordered = filtered;
        }
        return ordered;
    }
}
