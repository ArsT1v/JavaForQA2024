package ru.shop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import ru.shop.exception.BadOrderCountException;
import ru.shop.model.Customer;
import ru.shop.model.Order;
import ru.shop.model.Product;
import ru.shop.repository.OrderRepository;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceTest {
    private final OrderRepository orderRepository = Mockito.mock();
    private final OrderService orderService = new OrderService(orderRepository);

    @Test
    public void shouldAddOrder() {
        var customer = new Customer();
        var product = new Product();

        orderService.add(customer, product, Long.parseLong("100"));

        ArgumentCaptor<Order> orderArgumentCaptor = ArgumentCaptor.captor();

        Mockito.verify(orderRepository).save(orderArgumentCaptor.capture());
        Order savedOrder = orderArgumentCaptor.getValue();


    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, Integer.MIN_VALUE})
    public void shouldThrowBadOrderCountExeption() {
        //given
        var customer = new Customer();
        var product = new Product();
        //when
        orderService.add(customer, product, Long.parseLong("100"));

        //then
        Assertions.assertThrows(
                BadOrderCountException.class,
                () -> orderService.add(customer, product, Long.parseLong("10"))
        );


    }


    @Test
    public void shouldFindCustomerOrders() {
        Customer customer = new Customer(
                UUID.randomUUID(),
                "name",
                "1234",
                10
        );
    var firstOrderId = UUID.randomUUID();
    var secondOrderId = UUID.randomUUID();

        Mockito.when(orderRepository.findAll())
                .thenReturn(
                        List.of(
                                new Order(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), 2, 10),
                                new Order(firstOrderId,customer.getId(),UUID.randomUUID(),2,10),
                                new Order(secondOrderId,customer.getId(),UUID.randomUUID(),2,20)
                        )
                );

        long totalCustomerAmount = orderService.getTotalCustomerAmount(customer);

        assertThat(totalCustomerAmount).isEqualTo(30);
    }


}