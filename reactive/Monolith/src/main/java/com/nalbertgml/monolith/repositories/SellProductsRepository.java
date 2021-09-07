package com.nalbertgml.monolith.repositories;

import com.nalbertgml.monolith.models.SellProducts;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface SellProductsRepository extends R2dbcRepository<SellProducts, Long> {
    Flux<SellProducts> findBySellId(Long sellId);
    Flux<SellProducts> findByProductId(Long productId);
}
