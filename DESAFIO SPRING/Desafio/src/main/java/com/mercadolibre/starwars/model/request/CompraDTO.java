package com.mercadolibre.starwars.model.request;

import java.util.List;

public class CompraDTO {
    private String userName;
    private List<ProductoCompraDTO> articles;

    public CompraDTO(String userName, List<ProductoCompraDTO> articles) {
        this.userName = userName;
        this.articles = articles;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<ProductoCompraDTO> getArticles() {
        return articles;
    }

    public void setArticles(List<ProductoCompraDTO> articles) {
        this.articles = articles;
    }
}
