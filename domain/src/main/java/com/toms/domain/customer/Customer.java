package com.toms.domain.customer;

public class Customer {
    String firstName;
    String lastName;
    String eMail;
    Adress adress;
    String phoneNumber;


    public Customer(String firstName, String lastName, String eMail, Adress adress, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
    }
}
