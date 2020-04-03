package com.toms.domain.order;

import com.toms.domain.customer.Adress;
import com.toms.domain.customer.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepositoryTest {


    Customer one = new Customer("tom", "dc", "tom@mail.com", new Adress("broek", 5, 9030, "Gent"), "092277412");
    Customer two = new Customer("tom", "dc", "tommmm@mail.com", new Adress("broek", 5, 9030, "Gent"), "092277412");

    // test below works when run separately, fails if all test run!

    @Test
    void twoOrdersAddedToRepository_checkIfContainsKey101() {
        // Given
        OrderRepository orderRepository = new OrderRepository();
        // When
        orderRepository.addOrderToRepository(one);
        orderRepository.addOrderToRepository(two);
        // Then
        assertTrue(orderRepository.getOrdersRepositoryMap().containsKey(101));
    }


    @Test
    void addOrderToRepository_whenTwoOrdersAreAdded_assertThatSizeIs2() {
        //Given
        OrderRepository orderRepository = new OrderRepository();
        // When
        orderRepository.addOrderToRepository(one);
        orderRepository.addOrderToRepository(two);
        // Then
        assertEquals(2, orderRepository.getOrdersRepositoryMap().size());
    }

}