package com.toms.api.customer;


import com.toms.domain.customer.Adress;
import com.toms.domain.customer.Customer;
import com.toms.domain.customer.CustomerRepository;
import com.toms.service.customerservice.CustomerCreaterDTO;
import com.toms.service.customerservice.CustomerDTO;
import com.toms.service.customerservice.CustomerService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CustomerControllerTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    CustomerCreaterDTO createrDTO;

    CustomerController controller;


    @BeforeEach
    void init() {
        createrDTO = new CustomerCreaterDTO("tom", "dc", "to@dfqqdsqgdqd.dd", "broek", 5, 9030, "Gent", "092277412");
        controller = new CustomerController(customerService);
    }

    @Test
    void whenNewCustomerIsCreated_assertThatWeGetBackDTO() {
        Assertions.assertThat(controller.createCustomerAccount(createrDTO)).isInstanceOf(CustomerDTO.class);

    }



}
