package com.nalbertgml.sellsMicroservice.controllers;

import com.nalbertgml.sellsMicroservice.models.Product;
import com.nalbertgml.sellsMicroservice.models.Sell;
import com.nalbertgml.sellsMicroservice.models.SellProducts;
import com.nalbertgml.sellsMicroservice.services.ProductService;
import com.nalbertgml.sellsMicroservice.services.SellService;
import com.nalbertgml.sellsMicroservice.services.SellerService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class SellController {
    @Autowired
    private SellService sellService;
    @Autowired
    private ProductService productService;
    @Autowired
    private SellerService sellerService;

    public SellController(SellService sellService, ProductService productService, SellerService sellerService) {
        this.sellService = sellService;
        this.productService = productService;
        this.sellerService = sellerService;
    }

    @GetMapping("/sell")
    public Object getALLSellFromSeller(@RequestParam String email) {
        return sellService
            .getAllFromSeller(email)
            .onErrorMap(err -> new Exception(""));
    }

    @PostMapping("/sell")
    public Mono<Sell> createSell(@RequestBody Sell sell) {
        return sellerService
            .getSeller( sell.getSellerEmail() )
            .flatMap(seller -> {
                return sellService
                    .createSell(sell)
                    .onErrorMap(err -> new Exception(""));
            })
            .onErrorMap(err -> new Exception(err));
    }

    @PostMapping("/sell-products")
    public Mono<SellProducts> createSellProduct(
            @RequestBody SellProducts sellProducts
    ) {
        return productService
            .getProduct( sellProducts.getProductId() )
            .flatMap(product -> {
                return sellService
                    .createSellProducts(sellProducts)
                    .onErrorMap(err -> new Exception(""));
            })
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
