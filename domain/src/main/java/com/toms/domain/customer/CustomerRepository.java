package com.toms.domain.customer;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {

     final List<Customer> customerList;

    public CustomerRepository() {
        customerList = new ArrayList<>();
    }

    public void addNewCustomerAccount(Customer customer) {
        customerList.add(customer);

    }
}
