package com.marcketplace.MarcketPlace.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRegistration {
    private String email;
    private String password;
    private String verificationCode;
    private String fullName;
    private String token;
}
