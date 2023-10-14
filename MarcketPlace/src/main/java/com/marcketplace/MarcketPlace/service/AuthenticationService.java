package com.marcketplace.MarcketPlace.service;


import com.marcketplace.MarcketPlace.dto.response.CustomerLoginResponse;
import com.marcketplace.MarcketPlace.model.Account;

public interface AuthenticationService {
    CustomerLoginResponse signInAndReturnJWT(Account signInRequest);
}
