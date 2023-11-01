package com.marcketplace.MarcketPlace.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileUpdateDTO {
    // @NotNull @Email
    private String email;
    @NotNull @Pattern(regexp = "^(\\+[0-9]{1,3})?[-. (]*[0-9]{1,4}[-. )]*[0-9]{1,10}$", message = "Número de teléfono no válido")
    private String number;
    
    @NotNull
    private String name;
    @NotNull
    private String lastName;
    @NotNull   @Size( max = 200)
    private String address;
    @NotNull   @Size(max = 200)
    private String country;
    @NotNull
    private String shippingAddress;
    @NotNull
    private String payment_preferences;

   

    
}