package com.toms.domain.customer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRepositoryTest {

    @BeforeEach
    void init() {
        CustomerRepository customerRepository = new CustomerRepository();
        Customer customer = new Customer("tom","dc","to@dd.dd",new Adress("broek",5,9030,"Gent"),"092277412");
        customerRepository.addNewCustomerAccount(customer);
    }

    @Test
    void whenTwoCustomersAreAdded_assertThatCustomerListSizeEqualsTwo(){
        CustomerRepository customerRepository = new CustomerRepository();
        Customer customer = new Customer("tom","dc","to@dd.dd",new Adress("broek",5,9030,"Gent"),"092277412");
        customerRepository.addNewCustomerAccount(customer);
        Customer second = new Customer("tom","dc","to@dd.dd",new Adress("broek",5,9030,"Gent"),"092277412");
        customerRepository.addNewCustomerAccount(second);


        Assertions.assertThat(customerRepository.customerList.size()).isEqualTo(2);


    }



}