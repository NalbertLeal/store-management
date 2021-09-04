package com.nalbertgml.storeManager.repositories;

import com.nalbertgml.storeManager.models.Sell;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface SellRepository extends R2dbcRepository<Sell, Long> {
    Flux<Sell> findAllBySellerEmail(String sellerEmail);
}
