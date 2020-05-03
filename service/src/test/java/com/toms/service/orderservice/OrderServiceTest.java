/*
package com.toms.service.orderservice;


import com.toms.domain.customer.Adress;
import com.toms.domain.customer.Customer;
import com.toms.domain.customer.CustomerRepository;
import com.toms.domain.items.Item;
import com.toms.domain.items.ItemsRepository;
import com.toms.domain.order.OrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

//todo :
// test below works when run separately, fails if all test run!
// is because of automatic key numbering, he can erase the input but keeps the key,
// solve this by (Moking maybe?) test database?

@SpringBootTest
class OrderServiceTest {

    @Autowired
    private CustomerRepository customerRepository;

    OrderRepository orderRepository = new OrderRepository();
    ItemsRepository itemsRepository = new ItemsRepository();
    Item item = new Item("buyThis", "this", 10, 5);

    OrderService service = new OrderService(customerRepository, orderRepository, itemsRepository);
    Customer customer = new Customer("tom", "dc", "tom@mail.com", new Adress("broek", 5, 9030, "Gent"), "092277412");
    ItemGroupCreatorDTO itemGroupCreatorDTO = new ItemGroupCreatorDTO(100, "buyThis", 10);
    ItemGroupCreatorDTO secondItemGroupCreatorDTO = new ItemGroupCreatorDTO(100, "buyThis", 4);

    @BeforeEach
    void init() {
        orderRepository.addOrderToRepository(customer);  // making sure order number 100 exists
        itemsRepository.addNewItemToRepository(item);
    }

    // failed by changes
   */
/* @Test
    void whenTryingToCreateNewOrder_ifNoKnownCustomer_ThrowException() {
        // Given
        String customersEmail = "tom@gmail.com";
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> service.openNewOrder(customersEmail)).isInstanceOf(IllegalArgumentException.class).hasMessage("The email adress:tom@gmail.com is not known in our database!");
    }*//*


  */
/*  @Test
        //doesn't work when run all, does when run separately
    void makeNewItemGroupService_ifThisRuns_makeSureThatIsAddedToGroupItemList() {
        //When
        //    orderRepository.addOrderToRepository(customer);
        service.makeNewItemGroupService(itemGroupCreatorDTO);
        //Then
        Assertions.assertEquals(1, orderRepository.getOrdersRepositoryMap().get(itemGroupCreatorDTO.getOrderNumber()).getItemGroupsList().size());
    }*//*


    @Test
    void addItemGroupToOrder_assertThatWhenOrderNumberNonExisting_throwException() {
        //When
        ItemGroupCreatorDTO secondOne = new ItemGroupCreatorDTO(150, "buyThis", 10);
        // Then
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> service.makeNewItemGroupService(secondOne)).hasMessage("The ordernumber 150 does not exist.");

    }

  */
/*  @Test
        //doesn't work when run all, does when run separately
    void addItemGroupToOrder_assertThatWhenItemNonExisting_throwException() {
        // When
        ItemGroupCreatorDTO secondOne = new ItemGroupCreatorDTO(100, "DontBuyThis", 10);
        //Then
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> service.makeNewItemGroupService(secondOne)).hasMessage("We don't sell DontBuyThis's.");
    }*//*


  */
/*  @Test
    void makeNewItemGroupService_WhenMethodRuns_inStock_checkOutReturnCreatorDTOIsCorrect() {
        //When
        ItemGroupCreatedDTO created = service.makeNewItemGroupService(secondItemGroupCreatorDTO);
        //Then
        Assertions.assertEquals(40, created.getTotalPriceOfItemGroup());
        Assertions.assertEquals(LocalDate.now().plusDays(1), created.getShippingDate());
        int stockOfItemToBuy = itemsRepository.getAmountOfGivenItem(secondItemGroupCreatorDTO.getItemToBuy());
        Assertions.assertEquals(1, stockOfItemToBuy);

    }*//*


    @Test
        //doesn't work when run all, does when run separately
    void makeNewItemGroupService_WhenMethodRuns_notInStock_checkOutReturnCreatorDTOIsCorrect() {
        //When
        ItemGroupCreatedDTO created = service.makeNewItemGroupService(itemGroupCreatorDTO);
        //Then
        Assertions.assertEquals(100, created.getTotalPriceOfItemGroup());
        Assertions.assertEquals(LocalDate.now().plusDays(7), created.getShippingDate());
        int stockOfItemToBuy = itemsRepository.getAmountOfGivenItem(itemGroupCreatorDTO.getItemToBuy());
        Assertions.assertEquals(5, stockOfItemToBuy);
    }


}*/
