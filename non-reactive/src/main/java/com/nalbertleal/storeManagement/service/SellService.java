package com.nalbertleal.storeManagement.service;

import com.nalbertleal.storeManagement.model.Sell;
import com.nalbertleal.storeManagement.model.SellProducts;
import com.nalbertleal.storeManagement.repository.SellProductsRepository;
import com.nalbertleal.storeManagement.repository.SellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class SellService {
    @Autowired
    private SellRepository sellRepository;
    @Autowired
    private SellProductsRepository sellProductsRepository;

    public SellService(SellRepository sellRepository, SellProductsRepository sellProductsRepository) {
        this.sellRepository = sellRepository;
        this.sellProductsRepository = sellProductsRepository;
    }

    public List<Map> getAllFromSeller(String sellerEmail) {
        List<Sell> sells = sellRepository.findAllBySellerEmail(sellerEmail);
        return mountSellAsMap(sells);
    }

    public Sell createSell(Sell sell) {
        return sellRepository.save(sell);
    }

    public SellProducts createSellProducts(SellProducts sellProducts){
        return sellProductsRepository.save(sellProducts);
    }

    public Sell updateSell(Sell sell) {
        return sellRepository.save(sell);
    }

    public void deleteSell(Long id) {
        sellRepository.deleteById(id);
    }

    private List<Map> mountSellAsMap(List<Sell> sells) {
        List<Map> sellsWithProducts = new ArrayList<>();
        for (final Sell sell : sells) {
            List<SellProducts> sellProducts = sellProductsRepository.findBySellId(sell.getId());
            List<Map> products = productsAsMap(sellProducts);
            final Map sellWithProduct = Map.of(
                    "id", sell.getId(),
                    "amount", sell.getAmount(),
                    "sellerEmail", sell.getSellerEmail(),
                    "products", products
            );
            sellsWithProducts.add(sellWithProduct);
        }
        return sellsWithProducts;
    }

    private List<Map> productsAsMap(List<SellProducts> sellProducts) {
        List<Map> products = new ArrayList<>();
        for (final SellProducts sellProducts1: sellProducts) {
            final Map product = Map.of(
                    "id", sellProducts1.getProductId(),
                    "sellId", sellProducts1.getSellId(),
                    "productId", sellProducts1.getProductId()
            );
            products.add(product);
        }
        return products;
    }
}
