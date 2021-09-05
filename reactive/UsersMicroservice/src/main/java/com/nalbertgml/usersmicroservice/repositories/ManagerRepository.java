package com.nalbertgml.usersmicroservice.repositories;

import com.nalbertgml.usersmicroservice.models.Manager;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ManagerRepository extends R2dbcRepository<Manager, Long> {
    Mono<Manager> findByEmail(String email);
    Mono<Boolean> deleteByEmail(String email);
}
