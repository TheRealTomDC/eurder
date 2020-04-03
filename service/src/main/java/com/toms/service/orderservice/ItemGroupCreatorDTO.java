package com.toms.service.orderservice;

public class ItemGroupCreatorDTO {
    private final int orderNumber;
    private final String itemToBuy;
    private final int amount;

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
}
