package com.toms.api.customer;



import com.toms.domain.customer.CustomerRepository;
import com.toms.service.customerService.CustomerCreaterDTO;
import com.toms.service.customerService.CustomerDTO;
import com.toms.service.customerService.CustomerService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CustomerControllerTest {
    CustomerCreaterDTO createrDTO;
    CustomerService service;
    CustomerController controller;


    @BeforeEach
    void init(){
        createrDTO = new CustomerCreaterDTO("tom","dc","to@dd.dd","broek",5,9030,"Gent","092277412");
        service = new CustomerService(new CustomerRepository());
        controller = new CustomerController(service);
    }

    @Test
    void whenNewCustomerIsCreated_assertThatWeGetBackDTO(){
        Assertions.assertThat(controller.createCustomerAccount(createrDTO)).isInstanceOf(CustomerDTO.class);

    }

}