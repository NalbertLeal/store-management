package com.nalbertgml.sellsMicroservice.services;

import com.nalbertgml.sellsMicroservice.models.Product;
import com.nalbertgml.sellsMicroservice.models.Sell;
import com.nalbertgml.sellsMicroservice.models.SellProducts;
import com.nalbertgml.sellsMicroservice.models.Seller;
import com.nalbertgml.sellsMicroservice.repositories.SellProductsRepository;
import com.nalbertgml.sellsMicroservice.repositories.SellRepository;
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
    @Autowired
    private ProductAPI productAPI;
    @Autowired
    private SellerAPI sellerAPI;

    public SellService(SellRepository sellRepository, SellProductsRepository sellProductsRepository, ProductAPI productAPI, SellerAPI sellerAPI) {
        this.sellRepository = sellRepository;
        this.sellProductsRepository = sellProductsRepository;
        this.productAPI = productAPI;
        this.sellerAPI = sellerAPI;
    }

    public Flux<Sell> getAllFromSeller(String sellerEmail) {
        return sellRepository
            .findAllBySellerEmail(sellerEmail);
//            .flatMap(sell -> mountSellAsMap(sell));
    }

    public Mono<Sell> createSell(Sell sell) {
        return sellerAPI
            .getSeller( sell.getSellerEmail() )
            .switchIfEmpty(Mono.just(new Seller()))
            .flatMap(seller -> {
                if (seller.getEmail() == null) return Mono.just(sell);
                return sellRepository.save(sell);
            });
    }

    public Mono<SellProducts> createSellProducts(SellProducts sellProducts){
        return productAPI
            .getProduct( sellProducts.getProductId() )
            .switchIfEmpty(Mono.just(new Product()))
            .flatMap(product -> {
                if (product.getName() == null) return Mono.just(sellProducts);
                return sellProductsRepository.save(sellProducts)
                    .onErrorMap(err -> new Exception(""));
            });
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
