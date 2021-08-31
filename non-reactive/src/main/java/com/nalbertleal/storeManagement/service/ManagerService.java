package com.nalbertleal.storeManagement.service;

import com.nalbertleal.storeManagement.model.Manager;
import com.nalbertleal.storeManagement.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepository managerRepository;

    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public Manager getManager(String email) {
        return managerRepository.findByEmail(email).orElseThrow();
    }

    public Manager createManager(Manager user) {
        return managerRepository.save(user);
    }

    public Manager updateManager(String email, Manager user) {
        Manager userFromDb = managerRepository.findByEmail(email).orElseThrow();
        user.setId(userFromDb.getId());
        return managerRepository.save(user);
    }

    public void deleteManager(String email) {
        Manager manager = managerRepository.findByEmail(email).orElseThrow();
        managerRepository.deleteById(manager.getId());
    }
}
