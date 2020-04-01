package com.toms.api.customer;

import com.toms.domain.customer.Adress;
import com.toms.domain.customer.CustomerRepository;
import com.toms.service.customerService.CustomerService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerControllerTest {

    @Test
    void whenNewCustomerIsCreated_assertThatWeGetBackDTO(){
        CustomerController customerController = new CustomerController(new CustomerService(new CustomerRepository()));

    }

}