package ru.shop.repository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.shop.model.Customer;
import ru.shop.model.Order;
import ru.shop.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OrderRepository  {
    List<Order> orders = new ArrayList<>();

    public void save(Order order) {
        orders.add(order);
    }
    public List<Order> findAll(){
        return orders;
    }
    public Optional<Order> findById(UUID id){
        for(Order order: orders){
            if(order.getId().equals(id)){
                return Optional.of(order);
            }
        }
        return Optional.empty();
    }
}
