package com.nalbertgml.storeManager.services;

import com.nalbertgml.storeManager.models.Manager;
import com.nalbertgml.storeManager.models.Seller;
import com.nalbertgml.storeManager.repositories.ManagerRepository;
import com.nalbertgml.storeManager.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SellerService {
    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private ManagerRepository managerRepository;

    public SellerService(SellerRepository sellerRepository, ManagerRepository managerRepository) {
        this.sellerRepository = sellerRepository;
        this.managerRepository = managerRepository;
    }

    public Mono<Seller> getSeller(String email) {
        return sellerRepository.findByEmail(email);
    }

    public Flux<Seller> getAllSellerFromManager(String email) {
        return sellerRepository.findByManagerEmail(email);
    }

    public Mono<Seller> createSeller(Seller seller) {
        return managerRepository
            .findByEmail(seller.getManagerEmail())
            .flatMap((manager) -> {
                if (manager.getId() == seller.getId()) {
                    return sellerRepository.save(seller);
                }
                return Mono.just(seller);
            });
    }

    public Mono<Seller> updateSeller(String email, Seller user) {
        return sellerRepository
            .findByEmail(email)
            .flatMap(sellerFromDb -> {
                Long sellerId = sellerFromDb.getId();
                user.setId(sellerId);
                return sellerRepository.save(user);
            });
    }

    public Mono<Manager> sellerToManager(String email) {
        return sellerRepository
            .findByEmail(email)
            .flatMap(seller -> {
                sellerRepository.deleteByEmail(email);
                Manager manager = new Manager(
                    seller.getFullname(),
                    seller.getEmail(),
                    seller.getPassword(),
                    seller.getSalary()
                );
                return managerRepository.save(manager);
            });
    }

    public Mono<Void> deleteSeller(String email) {
        return sellerRepository
            .findByEmail(email)
            .flatMap(seller -> {
               return sellerRepository.deleteById(seller.getId());
            });
    }
}
