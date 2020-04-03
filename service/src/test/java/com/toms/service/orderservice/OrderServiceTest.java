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


class OrderServiceTest {

    OrderRepository orderRepository = new OrderRepository();
    CustomerRepository customerRepository = new CustomerRepository();
    ItemsRepository itemsRepository = new ItemsRepository();
    Item item = new Item("buyThis","this",10,5);

    OrderService service = new OrderService(customerRepository,orderRepository, itemsRepository);
    Customer customer =  new Customer("tom","dc","tom@mail.com",new Adress("broek",5,9030,"Gent"),"092277412");
    ItemGroupCreatorDTO itemGroupCreatorDTO = new ItemGroupCreatorDTO(100,"buyThis",10);

    @BeforeEach
    void init(){
        orderRepository.addOrderToRepository(customer);  // making sure order number 100 exists
        itemsRepository.addNewItemToRepository(item);
    }
    @Test
    void whenTryingToCreateNewOrder_ifNoKnownCustomer_ThrowException(){
        // Given
        String customersEmail = "tom@gmail.com";
        org.assertj.core.api.Assertions.assertThatThrownBy(()->service.openNewOrder(customersEmail)).isInstanceOf(IllegalArgumentException.class).hasMessage("The email adress:tom@gmail.com is not known in our database!");
    }
    @Test
    void makeNewItemGroupService_ifThisRuns_makeSureThatIsAddedToGroupItemList(){
        //When
    //    orderRepository.addOrderToRepository(customer);
        service.makeNewItemGroupService(itemGroupCreatorDTO);
        //Then
        Assertions.assertEquals(1,orderRepository.getOrdersRepositoryMap().get(itemGroupCreatorDTO.getOrderNumber()).getItemGroupsList().size());
    }

    @Test
    void addItemGroupToOrder_assertThatWhenOrderNumberNonExisting_throwException() {
        //When
        ItemGroupCreatorDTO secondOne = new ItemGroupCreatorDTO(150,"buyThis",10);
        // Then
        org.assertj.core.api.Assertions.assertThatThrownBy(()->service.makeNewItemGroupService(secondOne)).hasMessage("The ordernumber 150 does not exist.");

    }

    @Test
    void addItemGroupToOrder_assertThatWhenItemNonExisting_throwException(){
        // When
        ItemGroupCreatorDTO secondOne = new ItemGroupCreatorDTO(100,"DontBuyThis",10);
        //Then
        org.assertj.core.api.Assertions.assertThatThrownBy(()->service.makeNewItemGroupService(secondOne)).hasMessage("We don't sell DontBuyThis's.");




    }









}