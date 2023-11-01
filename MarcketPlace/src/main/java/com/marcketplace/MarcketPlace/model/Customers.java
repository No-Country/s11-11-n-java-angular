package com.marcketplace.MarcketPlace.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(name = "customer_wishlist", joinColumns = @JoinColumn(name = "customer_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> wishlist = new HashSet<>();

    public Customers(String email, String password) {
        super(email, password);
    }

    public Customers(String email) {
        super(email);
    }
}
