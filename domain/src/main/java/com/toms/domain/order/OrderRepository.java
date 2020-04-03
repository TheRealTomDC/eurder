package com.toms.domain.order;

import com.toms.domain.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


@Repository
public class OrderRepository {

    private final Map<Integer, Order> ordersRepository;

    @Autowired
    public OrderRepository() {
        this.ordersRepository = new HashMap<>();
    }

    public int addOrderToRepository(Customer customer){
        Order toCreate = new Order(customer);
        ordersRepository.put(toCreate.getOrderNumber(),toCreate);
        return toCreate.getOrderNumber();
    }

    public void addItemGroupToOrder(ItemGroup toUse) {
        ordersRepository.get(toUse.getOrderNumber()).addTheItemGroup(toUse);

    }
}
