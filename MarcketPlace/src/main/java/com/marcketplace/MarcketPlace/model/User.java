package com.marcketplace.MarcketPlace.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "user")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private int userId;
    
    @Column(name = "full_name")
    private String fullName;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "personal_info")
    private String personal_info;
    
    @Column(name = "shipping_address")
    private String shippingAddress;
    
    @Column(name = "country")
    private String country;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "zip")
    private String zip;
    
    @Column(name = "payment_preferences")
    private String paymentPreferences;
    
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<ShoppingCart> Cart;
    
}
