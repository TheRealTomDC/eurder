package com.toms.service.customerservice;

public class CustomerCreaterDTO {
    private String firstName;
    private String lastName;
    private String eMail;
    private String street;
    private int houseNumber;
    private int postalCode;
    private String city;
    private String phoneNumber;

    public CustomerCreaterDTO(String firstName, String lastName, String eMail, String street, int houseNumber, int postalCode, String city, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.street = street;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String geteMail() {
        return eMail;
    }

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

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

