package com.nalbertgml.storeManager.services;

import com.nalbertgml.storeManager.models.Manager;
import com.nalbertgml.storeManager.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepository managerRepository;

    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public Mono<Manager> getManager(String email) {
        return managerRepository.findByEmail(email);
    }

    public Mono<Manager> createManager(Manager user) {
        return managerRepository.save(user);
    }

    public Mono<Manager> updateManager(String email, Manager user) {
        return managerRepository
            .findByEmail(email)
            .flatMap((managerFromDB) -> {
                user.setId(managerFromDB.getId());
                return managerRepository.save(user);
            });
    }

    public Mono<Boolean> deleteManager(String email) {
        return managerRepository.deleteByEmail(email);
    }
}
