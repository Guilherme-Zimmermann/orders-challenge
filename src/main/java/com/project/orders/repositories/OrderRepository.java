package com.project.orders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.orders.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
}
