package com.nalbertleal.storeManagement.controller;

import com.nalbertleal.storeManagement.dao.ProductDAO;
import com.nalbertleal.storeManagement.model.Product;
import com.nalbertleal.storeManagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public ProductDAO show(@RequestParam Long id) {
        try {
            Product product = productService.getProduct(id);
            return ProductDAO.fromProduct(product);
        } catch (Exception e) {
            return new ProductDAO(false);
        }
    }

    @GetMapping("/all-products")
    public List<ProductDAO> getAll() {
        List<Product> products = productService.getAllProducts();
        return products
                .stream()
                .map((product) -> ProductDAO.fromProduct(product))
                .collect(Collectors.toList());
    }

    @PostMapping("/product")
    public ProductDAO create(@RequestBody ProductDAO productDAO) {
        try {
            Product product = productDAO.toProduct();
            Product createdProduct = productService.createProduct(product);
            return ProductDAO.fromProduct(createdProduct);
        } catch (Exception e) {
            return new ProductDAO(false);
        }
    }

    @PutMapping("/product")
    public ProductDAO update(
            @RequestParam Long id,
            @RequestBody ProductDAO productDAO
    ) {
        try {
            Product product = productDAO.toProduct();
            Product updatedProduct = productService.updateProduct(product);
            return ProductDAO.fromProduct(updatedProduct);
        } catch (Exception e) {
            return new ProductDAO(false);
        }
    }

    @DeleteMapping("/product")
    public ProductDAO delete(@RequestParam Long id) {
        try {
            productService.deleteProduct(id);
            return new ProductDAO(true);
        } catch (Exception e) {
            return new ProductDAO(false);
        }
    }
}
