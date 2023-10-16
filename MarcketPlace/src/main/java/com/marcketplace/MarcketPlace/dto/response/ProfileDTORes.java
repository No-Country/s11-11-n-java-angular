package com.marcketplace.MarcketPlace.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDTORes {
    
    
    private String number;
    private String name;
    private String lastName;
    private String address;
    private String country;
    private String shippingAddress;
    private String payment_preferences;
    private String accountUuid;
    private String email;
    private String rol;
    private String token;
    private String tokenPassword;


    
}