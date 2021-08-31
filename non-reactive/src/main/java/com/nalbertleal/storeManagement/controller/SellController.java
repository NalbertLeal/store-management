package com.nalbertleal.storeManagement.controller;

import com.nalbertleal.storeManagement.dao.SellDAO;
import com.nalbertleal.storeManagement.dao.SellProductsDAO;
import com.nalbertleal.storeManagement.model.Sell;
import com.nalbertleal.storeManagement.model.SellProducts;
import com.nalbertleal.storeManagement.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class SellController {
    @Autowired
    private SellService sellService;

    public SellController(SellService sellService) {
        this.sellService = sellService;
    }

    @GetMapping("/sell")
    public Object getALLSellFromSeller(@RequestParam String email) {
        try {
            return sellService.getAllFromSeller(email);
        } catch (Exception e) {
            return Map.of(
                "success", false
            );
        }
    }

    @PostMapping("/sell")
    public SellDAO createSell(@RequestBody SellDAO sellDAO) {
        try {
            Sell sell = sellDAO.toSell();
            Sell createdSell = sellService.createSell(sell);
            return SellDAO.fromSell(createdSell);
        } catch (Exception e) {
            return new SellDAO(false);
        }
    }

    @PostMapping("/sell-products")
    public SellProductsDAO createSellProduct(
            @RequestBody SellProductsDAO sellProductsDAO
            ) {
        try {
            SellProducts sellProducts = sellProductsDAO.toSellProducts();
            SellProducts createdSellProducts = sellService.createSellProducts(sellProducts);
            return SellProductsDAO.fromSellProducts(createdSellProducts);
        } catch (Exception e) {
            return new SellProductsDAO(false);
        }
    }

    @PutMapping("/sell")
    public SellDAO updateSell(
            @RequestParam Long id,
            @RequestBody SellDAO sellDAO
    ) {
        try {
            Sell sell = sellDAO.toSell();
            Sell updatedSell = sellService.updateSell(sell);
            return SellDAO.fromSell(updatedSell);
        } catch (Exception e) {
            return new SellDAO(false);
        }
    }

    @DeleteMapping("/sell")
    public SellDAO deteleSell(@RequestParam Long id) {
        try {
            sellService.deleteSell(id);
            return new SellDAO(true);
        } catch (Exception e) {
            return new SellDAO(false);
        }
    }
}
