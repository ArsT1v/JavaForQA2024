package ru.shop.service;

import ru.shop.model.Customer;
import ru.shop.repository.CustomerRepository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> findAll() {
        return repository.findAll();
    }

    public void save(Customer product) {
        repository.save(product);
    }
    public Optional<Customer> findById(UUID id) {
        return repository.findById(id);
    }
}

