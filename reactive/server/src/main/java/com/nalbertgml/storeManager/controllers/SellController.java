package com.nalbertgml.storeManager.controllers;

import com.nalbertgml.storeManager.models.Sell;
import com.nalbertgml.storeManager.models.SellProducts;
import com.nalbertgml.storeManager.services.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class SellController {
    @Autowired
    private SellService sellService;

    public SellController(SellService sellService) {
        this.sellService = sellService;
    }

    @GetMapping("/sell")
    public Object getALLSellFromSeller(@RequestParam String email) {
        return sellService
            .getAllFromSeller(email)
            .onErrorMap(err -> new Exception(""));
    }

    @PostMapping("/sell")
    public Mono<Sell> createSell(@RequestBody Sell sell) {
        return sellService
            .createSell(sell)
            .onErrorMap(err -> new Exception(""));
    }

    @PostMapping("/sell-products")
    public Mono<SellProducts> createSellProduct(
            @RequestBody SellProducts sellProducts
    ) {
        return sellService
            .createSellProducts(sellProducts)
            .onErrorMap(err -> new Exception(""));
    }

    @PutMapping("/sell")
    public Mono<Sell> updateSell(
            @RequestParam Long id,
            @RequestBody Sell sell
    ) {
        return sellService
                .updateSell(sell)
                .onErrorMap(err -> new Exception(""));
    }

    @DeleteMapping("/sell")
    public Mono<Void> deteleSell(@RequestParam Long id) {
        return sellService
            .deleteSell(id)
            .onErrorMap(err -> new Exception(""));
    }
}
