package com.toms.service;

import com.toms.domain.customer.Customer;
import com.toms.domain.customer.CustomerRepository;
import com.toms.domain.customer.NotUniqueException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Embeddable;

public class Validation {

    @Autowired
    private static CustomerRepository customerRepository;

/*
    public static void checkIfEmailIsUnique(String emailToCheck) {
        if (!(customerRepository.count() == 0)) {
            if (customerRepository.containsKey(emailToCheck)) {
                throw new NotUniqueException("This E-mail adress is allready used.");
            }
        }
    }

    public Customer getCustomerByEmail(String customersEmail) {
        if (!customerList.containsKey(customersEmail)) {
            throw new IllegalArgumentException("The email adress:" + customersEmail + " is not known in our database!");
        }
        return customerList.get(customersEmail);
    }*/
}
