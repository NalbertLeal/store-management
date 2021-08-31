package com.nalbertleal.storeManagement.dao;

import com.nalbertleal.storeManagement.model.SellProducts;

public class SellProductsDAO {
    public Long sellId;
    public Long productId;
    public boolean success;

    public SellProductsDAO(boolean success) {
        this.success = success;
    }

    public SellProductsDAO(Long sellId, Long productId) {
        this.sellId = sellId;
        this.productId = productId;
    }

    public static SellProductsDAO fromSellProducts(SellProducts sellProducts) {
        return new SellProductsDAO(
            sellProducts.getSellId(),
            sellProducts.getProductId()
        );
    }

    public SellProducts toSellProducts() {
        return new SellProducts(
                sellId,
                productId
        );
    }
}
