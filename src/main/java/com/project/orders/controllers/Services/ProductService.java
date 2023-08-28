package com.project.orders.controllers.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.project.orders.controllers.Services.exceptions.DatabaseException;
import com.project.orders.controllers.Services.exceptions.ResourceNotFoundException;
import com.project.orders.controllers.repositories.ProductRepository;
import com.project.orders.model.entities.Product;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Product insert(Product product){
        return repository.save(product);
    } 
    
    public void delete(Long id){
        try{
            if(repository.existsById(id)){
                repository.deleteById(id);
            } else {
                throw new ResourceNotFoundException(id);
            }
        }
        catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public Product update(Long id, Product product){
        try {
            Product entity = repository.getReferenceById(id);
            updateData(entity, product);
            return repository.save(entity);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Product entity, Product product) {
        entity.setTitle(product.getTitle());
        entity.setDescription(product.getDescription());
        entity.setPrice(product.getPrice());
    }
}
