package com.toms.domain.order;

import java.time.LocalDate;

public class ItemGroup {
    private final int orderNumber;
    private final String itemReference;
    private final int amount;
    private LocalDate orderDate;
    private LocalDate shippingDate;
    private int pricePerItem;
    private int priceOfItemGroup;
    private int amountOfItemInStock;

    public ItemGroup(int orderNumber, String itemReference, int amount) {
        this.orderNumber = orderNumber;
        this.itemReference = itemReference;
        this.amount = amount;
        this.orderDate = LocalDate.now();
        this.shippingDate = calculateShippingDate(amountOfItemInStock, amount, orderDate);
        this.priceOfItemGroup = calculatePriceOfItemGroup(pricePerItem, amount);
    }

    private int calculatePriceOfItemGroup(int pricePerItem, int amount) {
        return pricePerItem * amount;
    }

    private LocalDate calculateShippingDate(int amountOfItemInStock, int amount, LocalDate orderDate) {
        if (amountOfItemInStock < amount) {
            return orderDate.plusDays(7);
        }
        return orderDate.plusDays(1);
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

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setAmountOfItemInStock(int amountOfItemInStock) {
        this.amountOfItemInStock = amountOfItemInStock;
    }

    public void setPricePerItem(int pricePerItem) {
        this.pricePerItem = pricePerItem;
    }
}
