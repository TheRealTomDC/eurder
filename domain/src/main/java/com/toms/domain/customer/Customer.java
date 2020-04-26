package com.toms.domain.customer;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String eMail;
    @Embedded
    private Adress adress;
    @Column
    private String phoneNumber;


    public Customer(String firstName, String lastName, String eMail, Adress adress, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
    }

    public Customer() {
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

    @Override
    public String toString() {
        return super.toString();
    }
}
