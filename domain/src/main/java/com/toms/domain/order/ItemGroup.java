package com.toms.domain.order;

import java.time.LocalDate;

public class ItemGroup {
    private final int orderNumber;
    private final String itemReference;
    private final int amount;
    private LocalDate orderDate;
    private LocalDate shippingDate;
    private double priceOfItemGroup;

    public ItemGroup(int orderNumber, String itemReference, int amount, double price, boolean checkIfInStock) {
        this.orderNumber = orderNumber;
        this.itemReference = itemReference;
        this.amount = amount;
        this.orderDate = LocalDate.now();
        this.shippingDate = calculateShippingDate(checkIfInStock, orderDate);
        this.priceOfItemGroup = calculatePriceOfItemGroup(price, amount);
    }

    private LocalDate calculateShippingDate(boolean checkIfInStock, LocalDate orderDate) {
        if (checkIfInStock) {
            return orderDate.plusDays(1);
        }
        return orderDate.plusDays(7);
    }

    private double calculatePriceOfItemGroup(double pricePerItem, int amount) {
        return pricePerItem * amount;
    }


    public String getItemReference() {
        return itemReference;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public double getPriceOfItemGroup() {
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
