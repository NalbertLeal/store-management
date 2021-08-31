package com.nalbertleal.storeManagement.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Sell {
    @Id
    @SequenceGenerator(
            name = "sell_sequence",
            sequenceName = "sell_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sell_sequence"
    )
    @Column(
            name = "id",
            columnDefinition = "BIGINT",
            updatable = false
    )
    private Long id;
    @Column(
            name = "amount",
            columnDefinition = "FLOAT"
    )
    private Double amount;
    @Column(
            name = "seller_email",
            columnDefinition = "TEXT"
    )
    private String sellerEmail; // user id
//    private List<Product> products;


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
