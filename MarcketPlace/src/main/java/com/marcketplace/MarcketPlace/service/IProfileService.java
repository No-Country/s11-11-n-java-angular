package com.marcketplace.MarcketPlace.service;

import java.util.List;


import com.marcketplace.MarcketPlace.dto.request.ProfileUpdateDTO;
import com.marcketplace.MarcketPlace.dto.response.ProfileDTORes;
import com.marcketplace.MarcketPlace.exception.IdNotFoundException;
import com.marcketplace.MarcketPlace.exception.NameExistsException;

import com.marcketplace.MarcketPlace.model.Customers;

public interface IProfileService {

    List<Customers> GetUser();

    ProfileDTORes getCustomerByEmail(String byEmail) throws IdNotFoundException;
    void updateCustomer(ProfileUpdateDTO profileUpdateDTODTO) throws IdNotFoundException, NameExistsException;
    

    
    }

