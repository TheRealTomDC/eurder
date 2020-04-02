package com.toms.domain.order;

import com.toms.domain.customer.Customer;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final Customer customer;
    private static int orderNumber = 100;
    private List<ItemGroups> itemGroupsList;
    private int totalPriceOfOrder;
    private boolean orderClosed;


    public Order(Customer customer) {
        this.customer = customer;
        this.itemGroupsList = new ArrayList<>();
        this.totalPriceOfOrder = 0;
        this.orderClosed = false;
        this.orderNumber = orderNumber++;

    }

    public Customer getCustomer() {
        return customer;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public List<ItemGroups> getItemGroupsList() {
        return itemGroupsList;
    }

    public int getTotalPriceOfOrder() {
        return totalPriceOfOrder;
    }

    public boolean isOrderClosed() {
        return orderClosed;
    }
}
