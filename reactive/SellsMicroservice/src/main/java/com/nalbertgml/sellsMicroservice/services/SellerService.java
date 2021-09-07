package com.nalbertgml.sellsMicroservice.services;

import com.nalbertgml.sellsMicroservice.models.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class SellerService {
    @Autowired
    private ReactorLoadBalancerExchangeFilterFunction lbFunction;

    public SellerService(ReactorLoadBalancerExchangeFilterFunction lbFunction) {
        this.lbFunction = lbFunction;
    }

    public Mono<Seller> getSeller(String email) {
        return WebClient.builder().baseUrl("http://users_microservices")
                .filter(lbFunction)
                .build()
                .get()
                .uri("/seller?email=" + email)
                .retrieve()
                .bodyToMono(Seller.class);
    }
}
