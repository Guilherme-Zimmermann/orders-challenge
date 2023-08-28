package com.project.orders.controllers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.orders.model.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
}
