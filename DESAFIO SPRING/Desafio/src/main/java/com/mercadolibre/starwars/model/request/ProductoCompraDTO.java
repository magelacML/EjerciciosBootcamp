package com.mercadolibre.starwars.model.request;

public class ProductoCompraDTO {
    private Integer productId;
    private Integer discount;
    private Integer quantity;

    public ProductoCompraDTO(Integer productId, Integer discount, Integer quantity) {
        this.productId = productId;
        this.discount = discount;
        this.quantity = quantity;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
