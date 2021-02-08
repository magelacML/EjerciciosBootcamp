package com.mercadolibre.starwars.model.response;

public class ProductDTO {
    private Integer id;
    private String name;
    private String category;
    private String mark;
    private Integer price;
    private Integer quantity;
    private Integer freeshipping;
    private Integer stars;


    public ProductDTO() {

    }

    public ProductDTO(Integer id, String name, String category, String mark, Integer price, Integer quantity, Integer freeshipping, Integer stars) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.mark = mark;
        this.price = price;
        this.quantity = quantity;
        this.freeshipping = freeshipping;
        this.stars = stars;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getFreeshipping() {
        return freeshipping;
    }

    public void setFreeshipping(Integer freeshipping) {
        this.freeshipping = freeshipping;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }
}
