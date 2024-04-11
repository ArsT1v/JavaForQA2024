package ru.shop.service;

import ru.shop.model.Product;
import ru.shop.model.ProductType;
import ru.shop.repository.IRepository;
import ru.shop.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private final IRepository<Product> repository;

    public ProductService(IRepository<Product> repository) {
        this.repository = repository;
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public void save(Product product) {
        repository.save(product);
    }

    public List<Product> findByProductType(ProductType productType) {
        List<Product> result = new ArrayList<>();
        for (Product product : repository.findAll()) {
            if (product.getProductType() == productType) {
                result.add(product);
            }
        }
        return result;
    }
}
