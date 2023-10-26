package com.marcketplace.MarcketPlace.dto.response;

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
    private Customers seller;
    private CategoryDTORes category;
    private String shippingStatus;
    private int stock;

}
