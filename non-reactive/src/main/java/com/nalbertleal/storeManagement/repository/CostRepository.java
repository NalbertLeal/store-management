package com.nalbertleal.storeManagement.repository;

import com.nalbertleal.storeManagement.model.Cost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostRepository extends JpaRepository<Cost, Long> {
}
