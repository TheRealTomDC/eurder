package com.toms.service.orderservice;

import java.time.LocalDate;

public class ItemGroupCreatorDTO {
    private final int orderNumber;
    private final String itemToBuy;
    private final int amount;
    private int totalPriceOfItemGroup;
    private LocalDate shippingDate;

    public ItemGroupCreatorDTO(int orderNumber, String itemToBuy, int amount) {
        this.orderNumber = orderNumber;
        this.itemToBuy = itemToBuy;
        this.amount = amount;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getItemToBuy() {
        return itemToBuy;
    }

    public int getAmount() {
        return amount;
    }

    public int getTotalPriceOfItemGroup() {
        return totalPriceOfItemGroup;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }


    public void setTotalPriceOfItemGroup(int totalPriceOfItemGroup) {
        this.totalPriceOfItemGroup = totalPriceOfItemGroup;

    }

    @Override
    public String toString() {
        return "This item was added to your shopping cart (order number: "+ orderNumber + "). \n" +
                amount + " piece(s) of " + itemToBuy + " with a total price of " + totalPriceOfItemGroup + ".\n" +
                "These items will be shipped out on " + shippingDate + ".";
    }
}
