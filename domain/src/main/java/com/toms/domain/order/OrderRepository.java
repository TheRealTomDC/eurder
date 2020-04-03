package com.toms.domain.order;

import com.toms.domain.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


@Repository
public class OrderRepository {

    private final Map<Integer, Order> ordersRepositoryMap;

    @Autowired
    public OrderRepository() {
        this.ordersRepositoryMap = new HashMap<>();
    }

    public int addOrderToRepository(Customer customer){
        Order toCreate = new Order(customer);
        ordersRepositoryMap.put(toCreate.getOrderNumber(),toCreate);

        return toCreate.getOrderNumber();
    }

    public void addItemGroupToOrder(ItemGroup toUse) {
        ordersRepositoryMap.get(toUse.getOrderNumber()).addTheItemGroup(toUse);

    }

    public Map<Integer, Order> getOrdersRepositoryMap() {
        return ordersRepositoryMap;
    }
}
