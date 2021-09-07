package com.nalbertgml.monolith.models;

import org.springframework.data.annotation.Id;

public class Sell {
    @Id
    private Long id;
    private Double amount;
    private String sellerEmail;

    public Sell() {
    }

    public Sell(Double amount, String sellerEmail) {
        this.amount = amount;
        this.sellerEmail = sellerEmail;
    }

    public Sell(Long id, Double amount, String sellerEmail) {
        this.id = id;
        this.amount = amount;
        this.sellerEmail = sellerEmail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }
}

