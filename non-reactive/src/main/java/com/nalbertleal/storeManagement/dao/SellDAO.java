package com.nalbertleal.storeManagement.dao;

import com.nalbertleal.storeManagement.model.Sell;

public class SellDAO {
    public Long id;
    public Double amount;
    public String sellerEmail;
    public boolean success;

    public SellDAO(boolean success) {
        this.success = success;
    }

    public SellDAO(Long id, Double amount, String sellerEmail) {
        this.id = id;
        this.amount = amount;
        this.sellerEmail = sellerEmail;
    }

    public static SellDAO fromSell(Sell sell) {
        return new SellDAO(
            sell.getId(),
            sell.getAmount(),
            sell.getSellerEmail()
        );
    }

    public Sell toSell() {
        return new Sell(
                id,
                amount,
                sellerEmail
        );
    }
}
