package com.matixtech.productinventoryservice.repository;

import com.matixtech.productinventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
//    @Query(value = "SELECT i FROM Inventory i WHERE i.skuCode=?1")

    List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
