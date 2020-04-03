package com.toms.service.orderservice;

import com.toms.domain.order.ItemGroup;

import java.time.LocalDate;

public class ItemGroupCreatedDTO {
    private final int orderNumber;
    private final String itemToBuy;
    private final int amount;
    private int totalPriceOfItemGroup;
    private LocalDate shippingDate;

    public ItemGroupCreatedDTO(ItemGroup itemGroup) {
        this.orderNumber = itemGroup.getOrderNumber();
        this.itemToBuy = itemGroup.getItemReference();
        this.amount = itemGroup.getAmount();
        this.totalPriceOfItemGroup = itemGroup.getPriceOfItemGroup();
        this.shippingDate = itemGroup.getShippingDate();
    }


    @Override
    public String toString() {
        return "This item was added to your shopping cart (order number: "+ orderNumber + "). \n" +
                amount + " piece(s) of " + itemToBuy + " with a total price of " + totalPriceOfItemGroup + ".\n" +
                "These items will be shipped out on " + shippingDate + ".";
    }
}
