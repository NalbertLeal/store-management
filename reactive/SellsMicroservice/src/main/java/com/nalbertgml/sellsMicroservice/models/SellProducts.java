package com.nalbertgml.sellsMicroservice.models;

import org.springframework.data.annotation.Id;

public class SellProducts {
    @Id
    private Long id;
    private Long sellId;
    private Long productId;

    public SellProducts() {
    }

    public SellProducts(Long sellId, Long productId) {
        this.sellId = sellId;
        this.productId = productId;
    }

    public SellProducts(Long id, Long sellId, Long productId) {
        this.id = id;
        this.sellId = sellId;
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSellId() {
        return sellId;
    }

    public void setSellId(Long sellId) {
        this.sellId = sellId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
