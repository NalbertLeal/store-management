package com.nalbertgml.monolith.models;

import org.springframework.data.annotation.Id;

public class Cost {
    @Id
    private Long id;
    private Double amount;
    private String description;

    public Cost() {
    }

    public Cost(Double amount, String description) {
        this.amount = amount;
        this.description = description;
    }

    public Cost(Long id, Double amount, String description) {
        this.id = id;
        this.amount = amount;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
