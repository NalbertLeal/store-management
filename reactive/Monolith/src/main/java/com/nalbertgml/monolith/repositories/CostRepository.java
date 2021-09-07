package com.nalbertgml.monolith.repositories;

import com.nalbertgml.monolith.models.Cost;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostRepository extends R2dbcRepository<Cost, Long> {
}
