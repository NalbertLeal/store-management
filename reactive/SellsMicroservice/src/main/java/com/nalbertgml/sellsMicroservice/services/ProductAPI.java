package com.nalbertgml.sellsMicroservice.services;

import com.nalbertgml.sellsMicroservice.models.Product;
import com.nalbertgml.sellsMicroservice.models.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ProductAPI {
    @Autowired
    private ReactorLoadBalancerExchangeFilterFunction lbFunction;

    public Mono<Product> getProduct(Long id) {
        return WebClient.builder()
            .baseUrl("http://products")
            .filter(lbFunction)
            .build()
            .get()
            .uri("/product?id=" + id)
            .retrieve()
            .bodyToMono(Product.class);
    }
}
