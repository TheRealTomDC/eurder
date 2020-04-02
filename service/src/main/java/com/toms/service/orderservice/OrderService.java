package com.toms.service.orderservice;

import com.toms.domain.customer.Customer;
import com.toms.domain.customer.CustomerRepository;
import com.toms.domain.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    public OrderOpeningDTO openNewOrder(String customersEmail) {
        Customer customerToUse = customerRepository.getCustomerByEmail(customersEmail);
        int orderNumberCreated =  orderRepository.addOrderToRepository(customerToUse);
        return new OrderOpeningDTO(customerToUse,orderNumberCreated);
    }
}
