package com.toms.service.customerService;

import com.toms.domain.customer.Adress;
import com.toms.domain.customer.Customer;
import com.toms.domain.customer.CustomerRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {

    CustomerRepository repository = new CustomerRepository();
    CustomerService service = new CustomerService(repository);
    CustomerCreaterDTO createrDTO = new CustomerCreaterDTO("tom", "dc", "tom@mail.com", "broek", 5, 9030, "Gent", "092277412");


    @Test
    void whenNewCostumerIsCreated_givesInEmailAdressThatIsUsedByOtherCustomer_ThrowException() {
        // Given
        Customer tom = new Customer("tom", "dc", "tom@mail.com", new Adress("broek", 5, 9030, "Gent"), "092277412");
        repository.addNewCustomerAccount(tom);
        // Then
        Assertions.assertThatThrownBy(() -> service.createCustomerService(createrDTO)).hasMessage("This E-mail adress is allready used.");


    }


}