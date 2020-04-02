package com.toms.service.orderservice;


import com.toms.domain.customer.CustomerRepository;
import com.toms.domain.order.OrderRepository;
import org.junit.jupiter.api.Test;


class OrderServiceTest {

    OrderRepository orderRepository = new OrderRepository();
    CustomerRepository customerRepository = new CustomerRepository();
    OrderService service = new OrderService(customerRepository,orderRepository);

    @Test
    void whenTryingToCreateNewOrder_ifNoKnownCustomer_ThrowException(){
        // Given
        String customersEmail = "tom@gmail.com";
        org.assertj.core.api.Assertions.assertThatThrownBy(()->service.openNewOrder(customersEmail)).isInstanceOf(IllegalArgumentException.class).hasMessage("The email adress:tom@gmail.com is not known in our database!");
    }








}