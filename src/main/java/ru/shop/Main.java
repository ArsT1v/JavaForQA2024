package ru.shop;

import ru.shop.exception.BadOrderCountException;
import ru.shop.model.Customer;
import ru.shop.model.Order;
import ru.shop.model.Product;
import ru.shop.model.ProductType;
import ru.shop.repository.CustomerRepository;
import ru.shop.repository.OrderRepository;
import ru.shop.repository.ProductRepository;
import ru.shop.service.CustomerService;
import ru.shop.service.OrderService;
import ru.shop.service.ProductService;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ProductService productService = new ProductService(new ProductRepository());


        Product lada = new Product(UUID.randomUUID(), "Lada", 100, ProductType.GOOD);
        productService.save(lada);
        Product kia = new Product(UUID.randomUUID(), "kia", 200, ProductType.GOOD);
        productService.save(kia);
        Product carWashing = new Product(UUID.randomUUID(), "Car Washing", 1, ProductType.SERVICE);
        productService.save(carWashing);


        CustomerService customerService = new CustomerService(new CustomerRepository());
        OrderService orderService = new OrderService(new OrderRepository());

        Customer Ivan = new Customer(UUID.randomUUID(), "Ivan", "1234", 20);
        customerService.save(Ivan);
        Customer Petr = new Customer(UUID.randomUUID(), "Petr", "123456", 22);
        customerService.save(Petr);
        for (Customer customer : customerService.findAll()) {
            System.out.println(customer);
        }
        for (Product product : productService.findAll()) {
            System.out.println(product);
        }
        System.out.println("GOODS");
        for (Product product : productService.findByProductType(ProductType.GOOD)) {
            System.out.println(product);
        }

        orderService.add(Ivan, lada, 2);
        orderService.add(Ivan, kia, 2);
        try {
            orderService.add(Petr, kia, 0);
        } catch (BadOrderCountException ex) {
            System.out.println("BadOrderCountException");
        }

        for (Order order : orderService.findByCustomer(Ivan)) {
            System.out.println(order);
        }

        System.out.println("Total amount: "+ orderService.getTotalCustomerAmount(Ivan));
    }

}