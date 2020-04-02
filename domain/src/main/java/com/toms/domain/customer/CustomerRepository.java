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

    public void checkIfEmailIsUnique(String emailToCheck) {
        if (!customerList.isEmpty()) {
            for (Customer customer : customerList
            ) {
                if (customer.geteMail().equalsIgnoreCase(emailToCheck)) {
                    throw new NotUniqueException("This E-mail adress is allready used.");
                }
            }
        }
    }

    public Customer getCustomerByEmail(String customersEmail) {
        return customerList.stream()
                .filter(customer -> customer.geteMail().equals(customersEmail))
                .findFirst()
                .orElse (null);

    }
}
 // throw new IllegalArgumentException("The email adress:" + customersEmail + " is not known in our database!");
