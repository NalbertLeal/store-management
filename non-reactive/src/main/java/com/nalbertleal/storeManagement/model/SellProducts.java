package com.nalbertleal.storeManagement.model;

import javax.persistence.*;

@Entity
@Table
public class SellProducts {
    @Id
    @SequenceGenerator(
            name = "sell_products_sequence",
            sequenceName = "sell_products_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sell_products_sequence"
    )
    @Column(
            name = "id",
            columnDefinition = "BIGINT",
            updatable = false
    )
    private Long id;
    @Column(
            name = "sellId",
            columnDefinition = "FLOAT"
    )
    private Long sellId;
    @Column(
            name = "productId",
            columnDefinition = "FLOAT"
    )
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
