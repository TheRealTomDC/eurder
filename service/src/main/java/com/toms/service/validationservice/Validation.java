package com.toms.service.validationservice;

import com.toms.domain.customer.Customer;
import com.toms.domain.customer.CustomerRepository;
import com.toms.domain.customer.NotUniqueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class Validation {


    private static CustomerRepository customerRepository;

    @Autowired
    public Validation(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void checkIfEmailIsUnique(String emailToCheck) {
        if (!(customerRepository.count() == 0)) {
            Optional<Customer> toCheck = (customerRepository.findByeMail(emailToCheck));
            if (toCheck.isPresent()) {
                throw new NotUniqueException("This E-mail adress is allready used.");
            }
        }
    }


    public Customer getCustomerByEmail(String customersEmail) {
        if ((customerRepository.findByeMail(customersEmail)).isEmpty()) {
            throw new IllegalArgumentException("The email adress:" + customersEmail + " is not known in our database!");
        }
        return customerRepository.findByeMail(customersEmail).get();
    }
}
