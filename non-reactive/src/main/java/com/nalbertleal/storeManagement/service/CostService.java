package com.nalbertleal.storeManagement.service;

import com.nalbertleal.storeManagement.model.Cost;
import com.nalbertleal.storeManagement.repository.CostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostService {
    @Autowired
    private CostRepository costRepository;

    public CostService(CostRepository costRepository) {
        this.costRepository = costRepository;
    }

    public List<Cost> getAll() {
        return costRepository.findAll();
    }

    public Cost createCost(Cost cost) {
        return costRepository.save(cost);
    }

    public Cost updateCost(Cost cost) {
        return costRepository.save(cost);
    }

    public void deleteCost(Long id) {
        costRepository.deleteById(id);
    }
}
