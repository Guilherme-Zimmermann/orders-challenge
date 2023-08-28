package com.project.orders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.orders.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
}
