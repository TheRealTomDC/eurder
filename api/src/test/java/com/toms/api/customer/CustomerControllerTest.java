package com.toms.api.customer;


import com.toms.domain.customer.CustomerRepository;
import com.toms.service.Validation;
import com.toms.service.customerservice.CustomerCreaterDTO;
import com.toms.service.customerservice.CustomerDTO;
import com.toms.service.customerservice.CustomerService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


class CustomerControllerTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private Validation validation;
    CustomerCreaterDTO createrDTO;
    CustomerService service;
    CustomerController controller;


    @BeforeEach
    void init() {
        createrDTO = new CustomerCreaterDTO("tom", "dc", "to@dd.dd", "broek", 5, 9030, "Gent", "092277412");
        service = new CustomerService(customerRepository, validation);
        controller = new CustomerController(service);
    }

    @Test
    void whenNewCustomerIsCreated_assertThatWeGetBackDTO() {
        Assertions.assertThat(controller.createCustomerAccount(createrDTO)).isInstanceOf(CustomerDTO.class);

    }

}