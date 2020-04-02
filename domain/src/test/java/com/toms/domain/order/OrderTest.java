package com.toms.domain.order;

import com.toms.domain.customer.Adress;
import com.toms.domain.customer.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class OrderTest {

    @Test
    void whenSecondOrderIsCreated_assertThatOrderNumberIs101() {
        //Given
        Customer one = new Customer("tom", "dc", "tom@mail.com", new Adress("broek", 5, 9030, "Gent"), "092277412");
        Order first = new Order(one);
        //When
        Order second = new Order(one);
        //Then
        Assertions.assertEquals(101, second.getOrderNumber());
    }


}