package com.nalbertgml.storeManager.repositories;

import com.nalbertgml.storeManager.models.Manager;
import com.nalbertgml.storeManager.models.Product;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends R2dbcRepository<Product, Long> {
}
