package com.doyur.demo.repository.abstracts;

import com.doyur.demo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    Optional<Order> findByOrderDate(Timestamp orderDate);
}
