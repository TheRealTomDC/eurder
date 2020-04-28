package com.toms.service.customerservice;

import com.toms.domain.customer.Adress;
import com.toms.domain.customer.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService service;

    CustomerCreaterDTO createrDTO = new CustomerCreaterDTO("tom", "dc", "tom@mail.com", "broek", 5, 9030, "Gent", "092277412");


    @Test
    void whenNewCostumerIsCreated_givesInEmailAdressThatIsUsedByOtherCustomer_ThrowException() {
        // Given
        Customer tom = new Customer("tom", "dc", "tom@mail.com", new Adress("broek", 5, 9030, "Gent"), "092277412");
        service.createCustomerService(createrDTO);
        // Then
        Assertions.assertThatThrownBy(() -> service.createCustomerService(createrDTO)).hasMessage("This E-mail adress is allready used.");

    }


}