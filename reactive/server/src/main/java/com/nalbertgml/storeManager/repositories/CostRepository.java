package com.nalbertgml.storeManager.repositories;

import com.nalbertgml.storeManager.models.Cost;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostRepository extends R2dbcRepository<Cost, Long> {
}
