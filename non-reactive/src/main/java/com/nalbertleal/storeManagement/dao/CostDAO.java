package com.nalbertleal.storeManagement.dao;

import com.nalbertleal.storeManagement.model.Cost;

public class CostDAO {
    public Double amount;
    public String description;
    public boolean success;

    public CostDAO(boolean success) {
        this.success = success;
    }

    public CostDAO(Double amount, String description) {
        this.amount = amount;
        this.description = description;
        this.success = true;
    }

    public static CostDAO fromCost(Cost cost) {
        return new CostDAO(
            cost.getAmount(),
            cost.getDescription()
        );
    }

    public Cost toCost() {
        return new Cost(
            amount,
            description
        );
    }
}
