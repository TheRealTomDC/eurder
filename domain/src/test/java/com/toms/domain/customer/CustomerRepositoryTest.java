package com.toms.domain.customer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRepositoryTest {

    Customer customer;
    CustomerRepository customerRepository;

    @BeforeEach
    void init() {
        customerRepository = new CustomerRepository();
        customer = new Customer("tom","dc","tom@mail.com",new Adress("broek",5,9030,"Gent"),"092277412");
        customerRepository.addNewCustomerAccount(customer);
    }

    @Test
    void whenTwoCustomersAreAdded_assertThatCustomerListSizeEqualsTwo(){
        Customer second = new Customer("tom","dc","nele@mail.com",new Adress("broek",5,9030,"Gent"),"092277412");
        customerRepository.addNewCustomerAccount(second);

        Assertions.assertThat(customerRepository.customerList.size()).isEqualTo(2);

    }



}