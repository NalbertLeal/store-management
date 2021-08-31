package com.nalbertleal.storeManagement.repository;

import com.nalbertleal.storeManagement.model.Sell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellRepository extends JpaRepository<Sell, Long> {
    List<Sell> findAllBySellerEmail(String sellerEmail);
}
