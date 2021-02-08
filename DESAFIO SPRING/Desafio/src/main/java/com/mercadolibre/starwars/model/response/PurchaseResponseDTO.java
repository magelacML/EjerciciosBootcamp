package com.mercadolibre.starwars.model.response;

public class PurchaseResponseDTO {
    private String userName;
    private Integer quantityArticles;
    private Double totalPrice;

    public PurchaseResponseDTO() {

    }

    public PurchaseResponseDTO(String userName, Integer quantityArticles, Double totalPrice) {
        this.userName = userName;
        this.quantityArticles = quantityArticles;
        this.totalPrice = totalPrice;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getQuantityArticles() {
        return quantityArticles;
    }

    public void setQuantityArticles(Integer quantityArticles) {
        this.quantityArticles = quantityArticles;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
