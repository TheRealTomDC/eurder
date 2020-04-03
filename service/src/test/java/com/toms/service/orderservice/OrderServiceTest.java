package com.toms.service.orderservice;


import com.toms.domain.customer.Adress;
import com.toms.domain.customer.Customer;
import com.toms.domain.customer.CustomerRepository;
import com.toms.domain.order.Order;
import com.toms.domain.order.OrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;


class OrderServiceTest {

    OrderRepository orderRepository = new OrderRepository();
    CustomerRepository customerRepository = new CustomerRepository();
    OrderService service = new OrderService(customerRepository,orderRepository);
    Customer customer =  new Customer("tom","dc","tom@mail.com",new Adress("broek",5,9030,"Gent"),"092277412");
    Order order = new Order(customer);
    ItemGroupCreatorDTO itemGroupCreatorDTO = new ItemGroupCreatorDTO(100,"buyThis",10);

    @Test
    void whenTryingToCreateNewOrder_ifNoKnownCustomer_ThrowException(){
        // Given
        String customersEmail = "tom@gmail.com";
        org.assertj.core.api.Assertions.assertThatThrownBy(()->service.openNewOrder(customersEmail)).isInstanceOf(IllegalArgumentException.class).hasMessage("The email adress:tom@gmail.com is not known in our database!");
    }
  /*  @Test
    void makeNewItemGroupService_ifThisRuns_makeSureThatisAddedToOrderList(){
        //When
        service.makeNewItemGroupService(itemGroupCreatorDTO);
        //Then
        Assertions.assertEquals(1,order.getItemGroupsList().size());
    }*/









}