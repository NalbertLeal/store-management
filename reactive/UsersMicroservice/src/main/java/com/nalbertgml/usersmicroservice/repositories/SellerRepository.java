package com.nalbertgml.usersmicroservice.repositories;

import com.nalbertgml.usersmicroservice.models.Seller;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface SellerRepository extends R2dbcRepository<Seller, Long> {
    Mono<Seller> findByEmail(String email);
    Flux<Seller> findByManagerEmail(String email);
    Mono<Boolean> deleteByEmail(String email);
}
