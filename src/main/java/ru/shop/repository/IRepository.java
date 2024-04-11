package ru.shop.repository;

import ru.shop.model.Customer;

import java.util.List;

public interface IRepository<T> {
    void save(T customer);

    List<T> findAll();
}
