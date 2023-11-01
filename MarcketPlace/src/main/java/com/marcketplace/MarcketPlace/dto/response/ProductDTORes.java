package com.marcketplace.MarcketPlace.dto.response;

import com.marcketplace.MarcketPlace.dto.request.CustomerRegistration;
import com.marcketplace.MarcketPlace.dto.request.SellerDTOReq;
import com.marcketplace.MarcketPlace.model.Account;
import com.marcketplace.MarcketPlace.model.Customers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTORes {

    private Long id;
    private String name;
    private Double price;
    private String images;
    private SellerDTORes seller;
    private CategoryDTORes category;
    private String shippingStatus;
    private int stock;

}

