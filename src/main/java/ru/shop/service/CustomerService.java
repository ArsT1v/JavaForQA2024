package ru.shop.service;

import ru.shop.model.Customer;
import ru.shop.repository.CustomerRepository;
import ru.shop.repository.IRepository;

import java.util.List;

public class CustomerService {
    private final IRepository<Customer> repository;

    public CustomerService(IRepository<Customer> repository) {
        this.repository = repository;
    }

    public List<Customer> findAll() {
        return repository.findAll();
    }

    public void save(Customer product) {
        repository.save(product);
    }
}

