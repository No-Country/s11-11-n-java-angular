package com.marcketplace.MarcketPlace.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@DiscriminatorValue("customer")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Customers extends Account implements Serializable {

    @Column(name = "number")
    private String number;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "address")
    private String address;
    @Column(name = "country")
    private String country;
    @Column(name = "shipping_address")
    private String shippingAddress;
    @Column(name = "payment_preferences")
    private String payment_preferences;

    public Customers(String email, String password){
        super(email,password);
    }

    public Customers(String email){
        super(email);
    }
}
