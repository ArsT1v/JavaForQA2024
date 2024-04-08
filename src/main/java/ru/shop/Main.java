package ru.shop;

import ru.shop.model.Customer;
import ru.shop.model.Product;
import ru.shop.model.ProductType;
import ru.shop.repository.CustomerRepository;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Product lada =new Product(UUID.randomUUID(), "Lada", 100, ProductType.GOOD);
        System.out.println(lada);
        Product carWashing=new Product(UUID.randomUUID(), "Car Washing", 1, ProductType.SERVICE);
        System.out.println(carWashing);

        CustomerRepository repository=new CustomerRepository();

        Customer Ivan = new Customer(UUID.randomUUID(),"Ivan","1234",20);
        repository.save(Ivan);
        Customer Petr = new Customer(UUID.randomUUID(),"Petr","123456",22);
        repository.save(Petr);
        for(Customer customer:repository.findAll()){
            System.out.println(customer);
        }

    }

}