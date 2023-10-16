package com.marcketplace.MarcketPlace.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileUpdateDTO {
    private String email;
    private String number;
    
    private String name;
 
    private String lastName;
    
    private String address;
    
    private String country;
    
    private String shippingAddress;
    
    private String payment_preferences;

   

    
}