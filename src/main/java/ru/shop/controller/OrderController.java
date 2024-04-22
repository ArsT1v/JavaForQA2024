package ru.shop.controller;

import org.springframework.web.bind.annotation.*;
import ru.shop.model.Customer;
import ru.shop.model.Order;
import ru.shop.model.Product;
import ru.shop.model.ProductType;
import ru.shop.repository.OrderRepository;
import ru.shop.service.OrderService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {
    OrderService orderService = new OrderService(new OrderRepository());
    @GetMapping
    public List<Order> getOrder() {
        return orderService.findAll();
    }

    @PostMapping
    public void save(@RequestBody Order order) {
        //orderService.save(order);
    }
    @GetMapping("/{id}")
    public Optional<Order> getById(@PathVariable UUID id) {
        return orderService.findById(id);

    }

}

