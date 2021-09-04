package com.nalbertgml.storeManager.controllers;

import com.nalbertgml.storeManager.models.Manager;
import com.nalbertgml.storeManager.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping("/manager")
    public Mono<Manager> show(@RequestParam String email) {
        return managerService.getManager(email);
    }

    @PostMapping("/manager")
    public Mono<Manager> createManager(@RequestBody Manager manager) {
        return managerService.createManager(manager);
    }

    @PutMapping("/manager")
    public Mono<Manager> updateManager(
            @RequestParam String email,
            @RequestBody Manager manager
    ) {
        return managerService.updateManager(email, manager);
    }

    @DeleteMapping("/manager")
    public Mono<Boolean> deleteManager(@RequestParam String email) {
        return managerService.deleteManager(email);
    }
}
