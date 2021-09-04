package com.nalbertgml.storeManager.controllers;

import com.nalbertgml.storeManager.models.Product;
import com.nalbertgml.storeManager.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public Mono<Product> show(@RequestParam Long id) {
        return productService
            .getProduct(id)
            .onErrorMap(err -> new Exception(""));
    }

    @GetMapping("/all-products")
    public Flux<Product> getAll() {
        return productService
            .getAllProducts()
            .onErrorMap(err -> new Exception(""));
    }

    @PostMapping("/product")
    public Mono<Product>  create(@RequestBody Product product) {
        return productService
            .createProduct(product)
            .onErrorMap(err -> new Exception(""));
    }

    @PutMapping("/product")
    public Mono<Product>  update(
            @RequestParam Long id,
            @RequestBody Product product
    ) {
        return productService
            .updateProduct(product)
            .onErrorMap(err -> new Exception(""));
    }

    @DeleteMapping("/product")
    public Mono<Void>  delete(@RequestParam Long id) {
        return productService
            .deleteProduct(id)
            .onErrorMap(err -> new Exception(""));
    }
}
