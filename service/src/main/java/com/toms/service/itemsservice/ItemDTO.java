package com.toms.service.itemsservice;

import com.toms.domain.items.Item;

public class ItemDTO {
    private final String name;
    private String description;
    private double price;
    private int amountInStock;

    public ItemDTO(Item item) {
        this.name = item.getName();
        this.description = item.getDescription();
        this.price = item.getPrice();
        this.amountInStock = item.getAmountInStock();
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
