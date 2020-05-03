package com.toms.api.customer;

import com.toms.domain.customer.Adress;
import com.toms.domain.customer.Customer;
import com.toms.service.customerservice.CustomerCreaterDTO;
import com.toms.service.customerservice.CustomerService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// todo: this class should be in Service (test)

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
