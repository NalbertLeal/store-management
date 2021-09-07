package com.nalbertgml.monolith.controllers;

import com.nalbertgml.monolith.models.Manager;
import com.nalbertgml.monolith.models.Seller;
import com.nalbertgml.monolith.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class SellerController {
    @Autowired
    private SellerService sellerService;

    public SellerController(SellerService sellerServicee) {
        this.sellerService = sellerServicee;
    }

    @GetMapping("/seller")
    public Mono<Seller> show(@RequestParam String email) {
        return sellerService
            .getSeller(email)
            .onErrorMap(err -> new Exception(""));
    }

    @GetMapping("/sellers-from-manager")
    public Flux<Seller> getSellersFromManager(
            @RequestParam String email
    ) {
        return sellerService
            .getAllSellerFromManager(email)
            .onErrorMap(err -> new Exception(""));
    }

    @PostMapping("/seller")
    public Mono<Seller> createSeller(@RequestBody Seller seller) {
        return sellerService
            .createSeller(seller)
            .onErrorMap(err -> new Exception(""));
    }

    @PutMapping("/seller")
    public Mono<Seller> updateSeller(
            @RequestParam String email,
            @RequestBody Seller seller
    ) {
        return sellerService
            .updateSeller(email, seller)
            .onErrorMap(err -> new Exception(""));
    }

    @PutMapping("/seller-to-manager/{email}")
    public Mono<Manager> updateSellerToManager(
            @RequestParam String email
    ) {
        return sellerService
                .sellerToManager(email)
                .onErrorMap(err -> new Exception(""));
    }

    @DeleteMapping("/seller")
    public Mono<Void> deleteSeller(@RequestParam String email) {
        return sellerService
            .deleteSeller(email)
            .onErrorMap(err -> new Exception(""));
    }
}
