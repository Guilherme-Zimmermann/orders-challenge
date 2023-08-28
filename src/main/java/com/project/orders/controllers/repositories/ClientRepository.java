package com.project.orders.controllers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.orders.model.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
}
