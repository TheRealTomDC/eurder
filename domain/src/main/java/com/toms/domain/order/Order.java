package com.toms.domain.order;

import com.toms.domain.customer.Customer;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final Customer customer;
    private List<ItemGroup> itemGroupsList;
    private int totalPriceOfOrder;
    private boolean orderClosed;

    private final int orderNumber;
    private static int orderNumberTotal = 100;


    public Order(Customer customer) {
        this.customer = customer;
        this.itemGroupsList = new ArrayList<>();
        this.totalPriceOfOrder = 0;
        this.orderClosed = false;
        this.orderNumber = orderNumberTotal++;




    }

    public Customer getCustomer() {
        return customer;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public List<ItemGroup> getItemGroupsList() {
        return itemGroupsList;
    }

    public int getTotalPriceOfOrder() {
        return totalPriceOfOrder;
    }

    public boolean isOrderClosed() {
        return orderClosed;
    }

    public void addTheItemGroup(ItemGroup toUse) {
        itemGroupsList.add(toUse);
    }
}
