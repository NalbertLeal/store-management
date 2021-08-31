package com.nalbertleal.storeManagement.dao;

import com.nalbertleal.storeManagement.model.Product;

public class ProductDAO {
    public Long id;
    public String name;
    public Double price;
    public Long stock;
    public String description;
    public boolean success;

    public ProductDAO(boolean success) {
        this.success = success;
    }

    public ProductDAO(Long id, String name, Double price, Long stock, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.success = true;
    }

    public static ProductDAO fromProduct(Product product) {
        return new ProductDAO(
            product.getId(),
            product.getName(),
            product.getPrice(),
            product.getStock(),
            product.getDescription()
        );
    }

    public Product toProduct() {
        return new Product(
                id,
                name,
                price,
                stock,
                description
        );
    }
}
