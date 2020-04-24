package com.toms.service.orderservice;

import com.toms.domain.customer.Customer;
import com.toms.domain.customer.CustomerRepository;
import com.toms.domain.items.ItemsRepository;
import com.toms.domain.order.ItemGroup;
import com.toms.domain.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final ItemsRepository itemsRepository;

    @Autowired
    public OrderService(CustomerRepository customerRepository, OrderRepository orderRepository, ItemsRepository itemsRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.itemsRepository = itemsRepository;
    }

    /*public OrderOpeningDTO openNewOrder(String customersEmail) {
        Customer customerToUse = customerRepository.getCustomerByEmail(customersEmail);
        int orderNumberCreated = orderRepository.addOrderToRepository(customerToUse);
        return new OrderOpeningDTO(customerToUse, orderNumberCreated);
    }*/

    public ItemGroupCreatedDTO makeNewItemGroupService(ItemGroupCreatorDTO itemGroupCreatorDTO) {
        checkIfValidInput(itemGroupCreatorDTO);
        double price = getPriceOfItem(itemGroupCreatorDTO);
        boolean checkIfInStock = checkIfItemIsInStock(itemGroupCreatorDTO);
        ItemGroup toUse = makeNewItemGroup(itemGroupCreatorDTO, price, checkIfInStock);
        orderRepository.addItemGroupToOrder(toUse);
        return new ItemGroupCreatedDTO(toUse);


    }

    private boolean checkIfItemIsInStock(ItemGroupCreatorDTO itemGroupCreatorDTO) {
        return itemsRepository.checkAndMaybeAdjustStock(itemGroupCreatorDTO.getItemToBuy(), itemGroupCreatorDTO.getAmount());
    }

    private double getPriceOfItem(ItemGroupCreatorDTO itemGroupCreatorDTO) {
        return itemsRepository.getItemPrice(itemGroupCreatorDTO.getItemToBuy());
    }

    /**
     * BEGIN METHODS valid input check for making ItemGroup
     */
    private void checkIfValidInput(ItemGroupCreatorDTO itemGroupCreatorDTO) {
        checkIfOrderNumberExists(itemGroupCreatorDTO.getOrderNumber());
        checkIfItemExists(itemGroupCreatorDTO.getItemToBuy());
    }

    private void checkIfItemExists(String itemToBuy) {
        if (itemsRepository.getSizeOfMap() == 0 ||
                !(itemsRepository.getItemsMap().containsKey(itemToBuy))) {
            throw new IllegalArgumentException("We don't sell " + itemToBuy + "'s.");
        }
    }

    private void checkIfOrderNumberExists(int orderNumber) {
        if (!(orderRepository.getOrdersRepositoryMap().containsKey(orderNumber))
                || orderRepository.getOrdersRepositoryMap().isEmpty()) {
            throw new IllegalArgumentException("The ordernumber " + orderNumber + " does not exist.");
        }
    }

    /**
     * END OF METHODS valid input check for making ItemGroup
     */


    private ItemGroup makeNewItemGroup(ItemGroupCreatorDTO itemGroupCreatorDTO, double price, boolean checkIfInStock) {
        return new ItemGroup(itemGroupCreatorDTO.getOrderNumber(), itemGroupCreatorDTO.getItemToBuy(), itemGroupCreatorDTO.getAmount(), price, checkIfInStock);
    }
}
