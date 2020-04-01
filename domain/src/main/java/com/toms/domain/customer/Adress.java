package com.toms.domain.customer;

public class Adress {
    String street;
    int houseNumber;
    int postalCode;
    String city;

    public Adress(String street, int houseNumber, int postalCode, String city) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.city = city;
    }
}
