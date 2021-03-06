package com.toms.domain.customer;

import javax.persistence.*;

@Embeddable
public class Adress {

    @Column(name = "street")
    private String street;
    @Column(name = "houseNumber")
    private int houseNumber;
    @Column(name = "postalCode")
    private int postalCode;
    @Column(name = "city")
    private String city;

    public Adress(String street, int houseNumber, int postalCode, String city) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.city = city;
    }
    public Adress(){}


    public String getStreet() {
        return street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }
}
