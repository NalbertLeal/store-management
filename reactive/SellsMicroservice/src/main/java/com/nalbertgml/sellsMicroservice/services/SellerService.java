package com.nalbertgml.sellsMicroservice.services;

import com.nalbertgml.sellsMicroservice.models.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.ws.rs.core.MediaType;

@Service
public class SellerService {
    @Autowired
    private ReactorLoadBalancerExchangeFilterFunction lbFunction;

    public Mono<Seller> getSeller(String email) {
        return WebClient.builder()
            .baseUrl("http://users")
                .filter(lbFunction)
                .build()
                .get()
                .uri("/seller?email=" + email)
                .retrieve()
                .bodyToMono(Seller.class);

//        return WebClient.create()
//                .get()
//                .uri("http://localhost:8082/seller?email=" + email)
//                .retrieve()
//                .bodyToMono(Seller.class);
    }
}
