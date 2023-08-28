package com.project.orders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.orders.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
}
