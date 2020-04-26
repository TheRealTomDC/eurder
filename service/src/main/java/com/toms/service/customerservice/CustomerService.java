package com.toms.service.customerservice;

import com.toms.domain.customer.Adress;
import com.toms.domain.customer.Customer;
import com.toms.domain.customer.CustomerRepository;
import com.toms.service.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final Validation validation;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, Validation validation) {
        this.customerRepository = customerRepository;
        this.validation = validation;
    }


    public CustomerDTO createCustomerService(CustomerCreaterDTO customerCreaterDTO) {
        checkIfValidInput(customerCreaterDTO);
        Customer customer = new Customer(customerCreaterDTO.getFirstName(), customerCreaterDTO.getLastName(), customerCreaterDTO.geteMail(), new Adress(customerCreaterDTO.getStreet(), customerCreaterDTO.getHouseNumber(), customerCreaterDTO.getPostalCode(), customerCreaterDTO.getCity()), customerCreaterDTO.getPhoneNumber());
        customerRepository.save(customer);
        return new CustomerDTO(customer);
    }

    private void checkIfValidInput(CustomerCreaterDTO customerCreaterDTO) {
        String emailToCheck = customerCreaterDTO.geteMail();
        validation.checkIfEmailIsUnique(emailToCheck);


    }
}
