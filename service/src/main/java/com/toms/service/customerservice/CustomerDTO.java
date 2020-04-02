package com.toms.service.customerservice;

import com.toms.domain.customer.Adress;
import com.toms.domain.customer.Customer;

public class CustomerDTO {
    String firstName;
    String lastName;
    String eMail;
    Adress adress;
    String phoneNumber;


    public CustomerDTO(Customer customer) {
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.eMail = customer.geteMail();
        this.adress = customer.getAdress();
        this.phoneNumber = customer.getPhoneNumber();
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

    public Adress getAdress() {
        return adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
