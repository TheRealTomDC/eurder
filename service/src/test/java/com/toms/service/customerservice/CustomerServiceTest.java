package com.toms.service.customerservice;

import com.toms.domain.customer.Adress;
import com.toms.domain.customer.Customer;
import com.toms.domain.customer.CustomerRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class CustomerServiceTest {

    @Autowired
    private CustomerRepository customerRepository;

    CustomerService service = new CustomerService(customerRepository);
    CustomerCreaterDTO createrDTO = new CustomerCreaterDTO("tom", "dc", "tom@mail.com", "broek", 5, 9030, "Gent", "092277412");


    @Test
    void whenNewCostumerIsCreated_givesInEmailAdressThatIsUsedByOtherCustomer_ThrowException() {
        // Given
        Customer tom = new Customer("tom", "dc", "tom@mail.com", new Adress("broek", 5, 9030, "Gent"), "092277412");
        customerRepository.save(tom);
        // Then
        Assertions.assertThatThrownBy(() -> service.createCustomerService(createrDTO)).hasMessage("This E-mail adress is allready used.");


    }


}