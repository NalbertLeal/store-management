package com.nalbertgml.monolith.controllers;

import com.nalbertgml.monolith.models.Cost;
import com.nalbertgml.monolith.services.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CostController {
    @Autowired
    private CostService costService;

    public CostController(CostService costService) {
        this.costService = costService;
    }

    @GetMapping("/all-costs")
    public Flux<Cost> index() {
        return costService
            .getAll()
            .onErrorMap(err -> new Exception(""));
    }

    @PostMapping("/cost")
    public Mono<Cost> create(@RequestBody Cost cost) {
        return costService
            .createCost(cost)
            .onErrorMap(err -> new Exception(""));
    }

    @PutMapping("/cost")
    public Mono<Cost> update(
            @RequestParam Long id,
            @RequestBody Cost cost
    ) {
        return costService
            .updateCost(cost)
            .onErrorMap(err -> new Exception(""));
    }

    @DeleteMapping("/cost")
    public Mono<Void> delete(@RequestParam Long id) {
        return costService
            .deleteCost(id)
            .onErrorMap(err -> new Exception(""));
    }
}
