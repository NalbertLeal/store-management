package com.nalbertgml.monolith.services;

import com.nalbertgml.monolith.models.Sell;
import com.nalbertgml.monolith.models.SellProducts;
import com.nalbertgml.monolith.repositories.SellProductsRepository;
import com.nalbertgml.monolith.repositories.SellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class SellService {
    @Autowired
    private SellRepository sellRepository;
    @Autowired
    private SellProductsRepository sellProductsRepository;

    public SellService(SellRepository sellRepository, SellProductsRepository sellProductsRepository) {
        this.sellRepository = sellRepository;
        this.sellProductsRepository = sellProductsRepository;
    }

    public Flux<Map> getAllFromSeller(String sellerEmail) {
        return sellRepository
            .findAllBySellerEmail(sellerEmail)
            .flatMap(sell -> mountSellAsMap(sell));
    }

    public Mono<Sell> createSell(Sell sell) {
        return sellRepository.save(sell);
    }

    public Mono<SellProducts> createSellProducts(SellProducts sellProducts){
        return sellProductsRepository.save(sellProducts);
    }

    public Mono<Sell> updateSell(Sell sell) {
        return sellRepository.save(sell);
    }

    public Mono<Void> deleteSell(Long id) {
        return sellRepository.deleteById(id);
    }

    private Flux<Map> mountSellAsMap(Sell sell) {
        return sellProductsRepository
            .findBySellId(sell.getId())
            .map(sellProduct -> {
                return Map.of(
                        "id", sell.getId(),
                        "amount", sell.getAmount(),
                        "sellerEmail", sell.getSellerEmail(),
                        "products", productAsMap(sellProduct)
                );
            });

    }

    private Map productAsMap(SellProducts sellProducts) {
        return Map.of(
                "id", sellProducts.getProductId(),
                "sellId", sellProducts.getSellId(),
                "productId", sellProducts.getProductId()
        );
    }
}
