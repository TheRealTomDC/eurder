package com.toms.service.validationservice;

import com.toms.domain.customer.Customer;
import com.toms.domain.customer.CustomerRepository;
import com.toms.domain.customer.NotUniqueException;
import com.toms.domain.items.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Validation {


    private final CustomerRepository customerRepository;
    private final ItemsRepository itemsRepository;

    @Autowired
    public Validation(CustomerRepository customerRepository, ItemsRepository itemsRepository) {
        this.customerRepository = customerRepository;
        this.itemsRepository = itemsRepository;
    }

    public void checkIfEmailIsUnique(String emailToCheck) {
        if (customerRepository.findByeMail(emailToCheck).isPresent()) {
            throw new NotUniqueException("This E-mail adress is allready used.");
        }
    }


    public Customer getCustomerByEmail(String customersEmail) {
        if ((customerRepository.findByeMail(customersEmail)).isEmpty()) {
            throw new IllegalArgumentException("The email adress:" + customersEmail + " is not known in our database!");
        }
        return customerRepository.findByeMail(customersEmail).get();
    }

    public void checkIfItemIsNotAlreadyInStock(String name) {
        if (itemsRepository.findByName(name).isPresent()) {
            throw new IllegalArgumentException("There is allready a " + name + " item in our stock");
        }
    }
}
