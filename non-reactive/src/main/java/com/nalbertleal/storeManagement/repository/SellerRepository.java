package com.nalbertleal.storeManagement.repository;

import com.nalbertleal.storeManagement.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
    Optional<Seller> findByEmail(String email);
    List<Seller> findByManagerEmail(String email);
    void deleteByEmail(String email);
}
