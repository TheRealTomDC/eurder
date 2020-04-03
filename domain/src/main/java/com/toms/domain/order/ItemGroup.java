package com.toms.domain.order;

import java.time.LocalDate;

public class ItemGroup {
    private final int orderNumber;
    private final String itemReference;
    private final int amount;
    private final LocalDate orderDate;
    private LocalDate shippingDate;
    private int priceOfItemGroup;

    public ItemGroup(int orderNumber,String itemReference, int amount) {
        this.orderNumber = orderNumber;  // write check if exist, test allready written
        this.itemReference = itemReference;
        this.amount = amount;
        this.orderDate = LocalDate.now();
        this.shippingDate = calculateShippingDate(itemReference, amount, orderDate); // to write
        this.priceOfItemGroup = calculatePriceOfItemGroup(); // to write
    }

    private int calculatePriceOfItemGroup() {
        return 0;
    }

    private LocalDate calculateShippingDate(String item, int amount, LocalDate orderDate) {
        return null;
    }

    public String getItemReference() {
        return itemReference;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public int getPriceOfItemGroup() {
        return priceOfItemGroup;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }
}
