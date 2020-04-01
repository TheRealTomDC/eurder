package com.toms.service.customerService;

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
        Customer customer = new Customer(customerCreaterDTO.getFirstName(),customerCreaterDTO.getLastName(),customerCreaterDTO.geteMail(),new Adress(customerCreaterDTO.getStreet(),customerCreaterDTO.getHouseNumber(),customerCreaterDTO.getPostalCode(),customerCreaterDTO.getCity()),customerCreaterDTO.getPhoneNumber());
        customerRepository.addNewCustomerAccount(customer);
        return new CustomerDTO(customer);
    }
}
