package com.nalbertleal.storeManagement.controller;

import com.nalbertleal.storeManagement.dao.ManagerDAO;
import com.nalbertleal.storeManagement.dao.ErrorDAO;
import com.nalbertleal.storeManagement.model.Manager;
import com.nalbertleal.storeManagement.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping("/manager")
    public ManagerDAO show(@RequestParam String email) {
        try {
            Manager managerFound = managerService.getManager(email);
            return ManagerDAO.fromManager(managerFound);
        } catch (Exception e) {
            return new ManagerDAO(false);
        }
    }

    @PostMapping("/manager")
    public ManagerDAO createManager(@RequestBody ManagerDAO managerDAO) {
        try {
            Manager manager = managerDAO.toManager();
            Manager managerCreated = managerService.createManager(manager);
            return ManagerDAO.fromManager(managerCreated);
        } catch (Exception e) {
            return new ManagerDAO(false);
        }
    }

    @PutMapping("/manager")
    public ManagerDAO updateManager(
            @RequestParam String email,
            @RequestBody ManagerDAO managerDAO
    ) {
        try {
            Manager manager = managerDAO.toManager();
            return ManagerDAO.fromManager(manager);
        } catch (Exception e) {
            return new ManagerDAO(false);
        }
    }

    @DeleteMapping("/manager")
    public ManagerDAO deleteManager(@RequestParam String email) {
        try {
            managerService.deleteManager(email);
            return new ManagerDAO(true);
        } catch (Exception e) {
            return new ManagerDAO(false);
        }
    }
}
