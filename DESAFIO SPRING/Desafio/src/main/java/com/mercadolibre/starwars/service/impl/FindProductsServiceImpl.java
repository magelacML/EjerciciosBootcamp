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

    @Override
    public List<ProductDTO> listProducts(String order) {
        List<ProductDTO> result = productDao.listAllProducts();
        List<ProductDTO> ordered = SortProducts(result,order);
        return ordered;
    }

    @Override
    public List<ProductDTO> findCategory(String category, String order) {
        List<ProductDTO> result = productDao.findByCategory(category);
        List<ProductDTO> ordered = SortProducts(result,order);
        return ordered;
    }



    @Override
    public List<ProductDTO> filterProducts(String category, String freeshipping, String order) {
        List<ProductDTO> filtered = productDao.filterProducts(category,freeshipping);

        List<ProductDTO> ordered = SortProducts(filtered,order);

       return ordered;
    }

    public List<ProductDTO> SortProducts(List<ProductDTO> filtered,String order){
        List<ProductDTO> ordered;
        switch (order){
            case "0": // La lista ordenada por Nombre Asc
                ordered = Sorter.OrdenarNombreAsc(filtered);
                break;
            case "1": // La lista ordenada por Nombre Desc
                ordered = Sorter.OrdenarNombreDesc(filtered);
                break;
            case "2": // La lista ordenada por mayor precio
                ordered = Sorter.OrdenarPrecioMayor(filtered);
                break;
            case "3": // La lista ordenada por menor precio
                ordered = Sorter.OrdenarPrecioMenor(filtered);
                break;
            default: // Como viene la lista
                ordered = filtered;
        }
        return ordered;
    }
}
