package com.nalbertleal.storeManagement.repository;

import com.nalbertleal.storeManagement.model.SellProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellProductsRepository extends JpaRepository<SellProducts, Long> {
    List<SellProducts> findBySellId(Long sellId);
    List<SellProducts> findByProductId(Long productId);
}
