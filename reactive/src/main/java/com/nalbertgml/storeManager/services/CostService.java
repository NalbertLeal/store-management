package com.nalbertgml.storeManager.services;

import com.nalbertgml.storeManager.models.Cost;
import com.nalbertgml.storeManager.repositories.CostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class CostService {
    @Autowired
    private CostRepository costRepository;

    public CostService(CostRepository costRepository) {
        this.costRepository = costRepository;
    }

    public Flux<Cost> getAll() {
        return costRepository.findAll();
    }

    public Mono<Cost> createCost(Cost cost) {
        return costRepository.save(cost);
    }

    public Mono<Cost> updateCost(Cost cost) {
        return costRepository.save(cost);
    }

    public Mono<Void> deleteCost(Long id) {
        return costRepository.deleteById(id);
    }
}
