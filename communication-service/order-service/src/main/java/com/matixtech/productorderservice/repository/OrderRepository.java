package com.matixtech.productorderservice.repository;

import com.matixtech.productorderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
