package com.nalbertgml.monolith.repositories;

import com.nalbertgml.monolith.models.Manager;
import com.nalbertgml.monolith.models.Product;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends R2dbcRepository<Product, Long> {
}
