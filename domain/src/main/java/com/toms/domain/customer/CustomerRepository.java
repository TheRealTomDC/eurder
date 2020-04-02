package com.toms.domain.customer;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CustomerRepository {

    final Map<String, Customer> customerList;

    public CustomerRepository() {
        customerList = new HashMap<>();
    }

    public void addNewCustomerAccount(Customer customer) {
        customerList.put(customer.geteMail(), customer);

    }

    public void checkIfEmailIsUnique(String emailToCheck) {
        if (!customerList.isEmpty()) {
            if (customerList.containsKey(emailToCheck)) {
                throw new NotUniqueException("This E-mail adress is allready used.");
            }
        }
    }

    public Customer getCustomerByEmail(String customersEmail) {
        if (!customerList.containsKey(customersEmail)) {
            throw new IllegalArgumentException("The email adress:" + customersEmail + " is not known in our database!");
        }
        return customerList.get(customersEmail);
    }
}

