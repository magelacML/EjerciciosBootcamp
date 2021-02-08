package com.mercadolibre.starwars.model.request;

import java.util.List;

public class PurchaseDTO {
    private String userName;
    private List<ProductPurchaseDTO> articles;

    public PurchaseDTO(String userName, List<ProductPurchaseDTO> articles) {
        this.userName = userName;
        this.articles = articles;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<ProductPurchaseDTO> getArticles() {
        return articles;
    }

    public void setArticles(List<ProductPurchaseDTO> articles) {
        this.articles = articles;
    }
}
