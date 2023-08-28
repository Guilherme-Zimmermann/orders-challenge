package com.project.orders.controllers.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.project.orders.controllers.Services.exceptions.DatabaseException;
import com.project.orders.controllers.Services.exceptions.ResourceNotFoundException;
import com.project.orders.controllers.repositories.ClientRepository;
import com.project.orders.model.entities.Client;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository repository;

    public List<Client> findAll(){
        return repository.findAll();
    }

    public Client findById(Long id){
        Optional<Client> obj = repository.findById(id);
        return obj.get();
    }

    public Client insert(Client client){
        return repository.save(client);
    }

    public void delete(Long id){
        try{
            if (repository.existsById(id)){
                repository.deleteById(id);
            } else {
                throw new ResourceNotFoundException(id);
            }
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Client update(Long id, Client client){
        try {
            Client entity = repository.getReferenceById(id);
            updateData(entity, client);
            return repository.save(entity);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Client entity, Client client) {
        entity.setName(client.getName());
        entity.setEmail(client.getEmail());
        entity.setPhone(client.getPhone());
        entity.setPassword(client.getPassword());
    }
}
