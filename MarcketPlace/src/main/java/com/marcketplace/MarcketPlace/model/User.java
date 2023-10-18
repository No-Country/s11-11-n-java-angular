//package com.marcketplace.MarcketPlace.model;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.*;
//import java.io.Serializable;
//import java.util.List;
//import lombok.*;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@ToString
//@Entity
//@Table(name = "user")
//public class User implements Serializable {
//    
//    private final static long serialVersionUID = 1L;
//    
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
//    @Column(name = "user_id")
//    private int userId;
//    
//    @Size(max = 255)
//    @Column(name = "full_name")
//    private String fullName;
//    
//    @Size(max = 255)
//    @Column(name = "email")
//    private String email;
//    
//    @Size(max = 255)
//    @Column(name = "password")
//    private String password;
//    
//    @Column(name = "personal_info")
//    private String personal_info;
//    
//    @Size(max = 255)
//    @Column(name = "shipping_address")
//    private String shippingAddress;
//    
//    @Size(max = 128)
//    @Column(name = "country")
//    private String country;
//    
//    @Size(max = 128)
//    @Column(name = "city")
//    private String city;
//    
//    @Size(max = 128)
//    @Column(name = "zip")
//    private String zip;
//    
//    @Size(max = 255)
//    @Column(name = "payment_preferences")
//    private String paymentPreferences;
//    
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    private List<ShoppingCart> Cart;
//    
//}