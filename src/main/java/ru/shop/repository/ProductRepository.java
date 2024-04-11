package ru.shop.repository;

import ru.shop.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IRepository<Product> {
    List<Product> Products = new ArrayList<>();

    public void save(Product Product) {
        Products.add(Product);
    }
    public List<Product> findAll(){
        return Products;
    }
}
