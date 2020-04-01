package com.toms.service.customerService;

import com.toms.domain.customer.Adress;

public class CustomerDTO {
    String firstName;
    String lastName;
    String eMail;
    Adress adress;
    String phoneNumber;


    public CustomerDTO(String firstName, String lastName, String eMail, Adress adress, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
    }
}
