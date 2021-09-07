package com.nalbertgml.sellsMicroservice.services;

import com.nalbertgml.sellsMicroservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    @Autowired
    private ReactorLoadBalancerExchangeFilterFunction lbFunction;

    public ProductService(ReactorLoadBalancerExchangeFilterFunction lbFunction) {
        this.lbFunction = lbFunction;
    }

    public Mono<Product> getProduct(Long id) {
        return WebClient.builder().baseUrl("http://products_microservice")
            .filter(lbFunction)
            .build()
            .get()
            .uri("/product" + id)
            .retrieve()
            .bodyToMono(Product.class);
    }
}
