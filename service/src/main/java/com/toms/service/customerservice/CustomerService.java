package com.toms.service.customerservice;

import com.toms.domain.customer.Adress;
import com.toms.domain.customer.Customer;
import com.toms.domain.customer.CustomerRepository;
import com.toms.service.validationservice.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService {


    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerDTO createCustomerService(CustomerCreaterDTO customerCreaterDTO) {
        checkIfValidInput(customerCreaterDTO);
        Customer customer = new Customer(customerCreaterDTO.getFirstName(), customerCreaterDTO.getLastName(), customerCreaterDTO.geteMail(), new Adress(customerCreaterDTO.getStreet(), customerCreaterDTO.getHouseNumber(), customerCreaterDTO.getPostalCode(), customerCreaterDTO.getCity()), customerCreaterDTO.getPhoneNumber());
        customerRepository.save(customer);
        return new CustomerDTO(customer);
    }

    private void checkIfValidInput(CustomerCreaterDTO customerCreaterDTO) {
        String emailToCheck = customerCreaterDTO.geteMail();
        Validation.checkIfEmailIsUnique(emailToCheck);


    }
}
