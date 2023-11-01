package com.marcketplace.MarcketPlace.dto.response;

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
    private CustomerRegistration seller;
    private CategoryDTORes category;
    private String shippingStatus;
    private int stock;

}
