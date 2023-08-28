package com.project.orders.controllers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.orders.model.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
}
