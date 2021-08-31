package com.nalbertleal.storeManagement.controller;

import com.nalbertleal.storeManagement.dao.CostDAO;
import com.nalbertleal.storeManagement.dao.ErrorDAO;
import com.nalbertleal.storeManagement.model.Cost;
import com.nalbertleal.storeManagement.service.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class CostController {
    @Autowired
    private CostService costService;

    public CostController(CostService costService) {
        this.costService = costService;
    }

    @GetMapping("/all-costs")
    public ArrayList<CostDAO> index() {
        List<Cost> costs = costService.getAll();
        ArrayList<CostDAO> costDAOs = new ArrayList<>();
        for (int i=0; i<costs.size(); i++) {
            Cost cost = costs.get(i);
            CostDAO costDAO = CostDAO.fromCost(cost);
            costDAOs.add(costDAO);
        }
        return costDAOs;
    }

    @PostMapping("/cost")
    public CostDAO create(@RequestBody CostDAO costDAO) {
        try {
            Cost cost = costDAO.toCost();
            Cost createdCost = costService.createCost(cost);
            return CostDAO.fromCost(createdCost);
        } catch (Exception e) {
            return new CostDAO(false);
        }
    }

    @PutMapping("/cost")
    public CostDAO update(
            @RequestParam Long id,
            @RequestBody CostDAO costDAO
    ) {
        try {
            Cost cost = costDAO.toCost();
            Cost updatedCost = costService.updateCost(cost);
            return CostDAO.fromCost(updatedCost);
        } catch (Exception e) {
            return new CostDAO(false);
        }
    }

    @DeleteMapping("/cost")
    public CostDAO delete(@RequestParam Long id) {
        try {
            costService.deleteCost(id);
            return new CostDAO(true);
        } catch (Exception e) {
            return new CostDAO(false);
        }
    }
}
