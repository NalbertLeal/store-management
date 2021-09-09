package com.nalbertgml.productsmicroservice.processor;

import com.nalbertgml.productsmicroservice.models.Product;
import com.nalbertgml.productsmicroservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class ProductStockUpdate {
    @Autowired
    private ProductService productService;

    public ProductStockUpdate(ProductService productService) {
        this.productService = productService;
    }

    @Bean
    public Consumer<Long> onReceive() {
        return (productId) -> {
            System.out.println(productId);
            productService
                .getProduct(productId)
                .doOnNext(product -> product.setStock( product.getStock()-1 ))
                .doOnNext(product -> System.out.println(product.getStock()))
                .doOnNext(product -> productService.updateProduct(product));
        };
    }
}
