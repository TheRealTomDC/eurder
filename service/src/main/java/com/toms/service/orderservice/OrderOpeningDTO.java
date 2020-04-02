package com.toms.service.orderservice;

import com.toms.domain.customer.Customer;

public class OrderOpeningDTO {
    private  Customer customer;
    private  int orderNumber;

    public OrderOpeningDTO(Customer customer, int orderNumber) {
        this.customer = customer;
        this.orderNumber = orderNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    @Override
    public String toString() {
        return "Dear "+ customer.getFirstName() + "\n" +
                "You have created a new Order. \n"+
                "To add items to your shopping cart please use your Ordernumber \n"+
                "Your Ordernumber is -------" + orderNumber + "-------";
    }
}
