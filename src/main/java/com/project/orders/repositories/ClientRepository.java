package com.project.orders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.orders.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
}
