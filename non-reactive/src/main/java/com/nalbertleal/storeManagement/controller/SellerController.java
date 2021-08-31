package com.nalbertleal.storeManagement.controller;

import com.nalbertleal.storeManagement.dao.ManagerDAO;
import com.nalbertleal.storeManagement.dao.SellerDAO;
import com.nalbertleal.storeManagement.model.Manager;
import com.nalbertleal.storeManagement.model.Seller;
import com.nalbertleal.storeManagement.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class SellerController {
    @Autowired
    private SellerService sellerService;

    public SellerController(SellerService sellerServicee) {
        this.sellerService = sellerServicee;
    }

    @GetMapping("/seller")
    public SellerDAO show(@RequestParam String email) {
        try {
            Seller seller = sellerService.getSeller(email);
            return SellerDAO.fromSeller(seller);
        } catch (Exception e) {
            return new SellerDAO(false);
        }
    }

    @GetMapping("/sellers-from-manager")
    public Object getSellersFromManager(
            @RequestParam String email
    ) {
        try {
            List<Seller> sellers = sellerService.getAllSellerFromManager(email);
            ArrayList<SellerDAO> sellerDAOs = new ArrayList<>();
            for (int i=0; i<sellers.size(); i++) {
                Seller seller = sellers.get(i);
                SellerDAO sellerDAO = SellerDAO.fromSeller(seller);
                sellerDAOs.add(sellerDAO);
            }
            return sellerDAOs;
        } catch (Exception e) {
            return new SellerDAO(false);
        }
    }

    @PostMapping("/seller")
    public SellerDAO createSeller(@RequestBody SellerDAO sellerDAO) {
        try {
            Seller seller = sellerDAO.toSeller();
            Seller createdSeller = sellerService.createSeller(seller);
            return SellerDAO.fromSeller(createdSeller);
        } catch (Exception e) {
            return new SellerDAO(false);
        }
    }

    @PutMapping("/seller")
    public SellerDAO updateSeller(
            @RequestParam String email,
            @RequestBody SellerDAO sellerDAO
            ) {
        try {
            Seller seller = sellerDAO.toSeller();
            Seller updatedSeller = sellerService.updateSeller(email, seller);
            return SellerDAO.fromSeller(updatedSeller);
        } catch (Exception e) {
            return new SellerDAO(false);
        }
    }

    @PutMapping("/seller-to-manager/{email}")
    public Object updateSellerToManager(
            @RequestParam String email
    ) {
        try {
            Manager manager = sellerService.sellerToManager(email);
            return ManagerDAO.fromManager(manager);
        } catch (Exception e) {
            return new SellerDAO(false);
        }
    }

    @DeleteMapping("/seller")
    public SellerDAO deleteSeller(@RequestParam String email) {
        try {
            sellerService.deleteSeller(email);
            return new SellerDAO(true);
        } catch (Exception e) {
            return new SellerDAO(false);
        }
    }
}
