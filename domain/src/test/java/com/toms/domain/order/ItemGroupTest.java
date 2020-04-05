package com.toms.domain.order;

import com.toms.domain.customer.Adress;
import com.toms.domain.customer.Customer;
import com.toms.domain.items.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ItemGroupTest {

    OrderRepository repository = new OrderRepository();
    Customer customer =  new Customer("tom","dc","tom@mail.com",new Adress("broek",5,9030,"Gent"),"092277412");


    @BeforeEach
    void init(){
        repository.addOrderToRepository(customer);  // making sure order number 100 exists
    }

    @Test
    void whenItemGroupIsMade_OrderingSomethingNotCompletelyInStock_assertThatShippingDateIs7DaysLater() {
        // Given
        Item item = new Item("Something", "that", 10.0, 5);
        // When
        ItemGroup itemGroup = new ItemGroup(100, "Something", 6, 10, false);
        // Then
        assertEquals(itemGroup.getOrderDate().plusDays(7), itemGroup.getShippingDate());
    }

    @Test
    void whenItemGroupIsMade_OrderingSomethingThatIsCompletelyInStock_assertThatShippingDateIsTomorrow() {
        // Given
        Item item = new Item("Something", "that", 10.0, 5);
        // When
        ItemGroup itemGroup = new ItemGroup(100, "Something", 4, 10, true);
        // Then
        assertEquals(itemGroup.getOrderDate().plusDays(1), itemGroup.getShippingDate());
    }

    @Test
    void whenItemGroupIsMade_calculatePrice() {
        // Given
        Item item = new Item("Something", "that", 10.0, 5);
        // When
        ItemGroup itemGroup = new ItemGroup(100, "Something", 4, 10, true);
        // Then
        assertEquals(40, itemGroup.getPriceOfItemGroup());
    }







}