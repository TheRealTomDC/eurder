package com.toms.service.customerservice;

import com.toms.domain.customer.Adress;
import com.toms.domain.customer.Customer;
import com.toms.domain.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerDTO createCustomerService(CustomerCreaterDTO customerCreaterDTO) {
        checkIfValidInput(customerCreaterDTO);
        Customer customer = new Customer(customerCreaterDTO.getFirstName(),customerCreaterDTO.getLastName(),customerCreaterDTO.geteMail(),new Adress(customerCreaterDTO.getStreet(),customerCreaterDTO.getHouseNumber(),customerCreaterDTO.getPostalCode(),customerCreaterDTO.getCity()),customerCreaterDTO.getPhoneNumber());
        customerRepository.addNewCustomerAccount(customer);
        return new CustomerDTO(customer);
    }

    private CustomerCreaterDTO checkIfValidInput(CustomerCreaterDTO customerCreaterDTO) {
        String emailToCheck = customerCreaterDTO.geteMail();
        customerRepository.checkIfEmailIsUnique(emailToCheck);
        return customerCreaterDTO;

    }
}
