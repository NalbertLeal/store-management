package com.nalbertleal.storeManagement.model;

import javax.persistence.*;

@Entity
@Table
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    @Column(
            name = "id",
            columnDefinition = "BIGINT",
            updatable = false
    )
    private Long id;
    @Column(
            name = "name",
            columnDefinition = "TEXT"
    )
    private String name;
    @Column(
            name = "price",
            columnDefinition = "FLOAT"
    )
    private Double price;
    @Column(
            name = "stock",
            columnDefinition = "BIGINT"
    )
    private Long stock;
    @Column(
            name = "description",
            columnDefinition = "TEXT"
    )
    private String description;

    public Product() { }

    public Product(String name, Double price, Long stock, String description) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
    }

    public Product(Long id, String name, Double price, Long stock, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
