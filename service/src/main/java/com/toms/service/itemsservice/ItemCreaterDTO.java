package com.toms.service.itemsservice;

public class ItemCreaterDTO {
    private final String name;
    private String description;
    private double price;
    private int amountInStock;

    public ItemCreaterDTO(String name, String description, double price, int amountInStock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amountInStock = amountInStock;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getAmountInStock() {
        return amountInStock;
    }
}
