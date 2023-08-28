package com.project.orders.controllers.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.project.orders.controllers.Services.exceptions.DatabaseException;
import com.project.orders.controllers.Services.exceptions.ResourceNotFoundException;
import com.project.orders.controllers.repositories.OrderRepository;
import com.project.orders.model.entities.Order;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository repository;

    public List<Order> findAll(){
        return repository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }

    public Order insert(Order order){
        return repository.save(order);
    }

    public void delete(Long id){
        try {
            if (repository.existsById(id)){
                repository.deleteById(id);
            } else {
                throw new ResourceNotFoundException(id);
            }
        }
        catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }
}
