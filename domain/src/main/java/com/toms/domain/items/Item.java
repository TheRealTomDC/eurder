package com.toms.domain.items;

public class Item {
    private final String name;
    private String description;
    private double price;
    public static final String CURRENCY = "EURO";
    private int amountInStock;


    public Item(String name, String description, double price, int amountInStock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amountInStock = amountInStock;


    }

    public void setAmountInStock(int amountInStock) {
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

    public static String getCURRENCY() {
        return CURRENCY;
    }
}
