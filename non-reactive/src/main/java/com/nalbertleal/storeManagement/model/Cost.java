package com.nalbertleal.storeManagement.model;

import javax.persistence.*;

@Entity
@Table
public class Cost {
    @Id
    @SequenceGenerator(
            name = "cost_sequence",
            sequenceName = "cost_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cost_sequence"
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
            name = "description",
            columnDefinition = "TEXT"
    )
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
