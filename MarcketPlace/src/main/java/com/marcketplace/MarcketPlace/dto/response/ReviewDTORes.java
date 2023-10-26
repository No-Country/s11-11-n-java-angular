package com.marcketplace.MarcketPlace.dto.response;

import com.marcketplace.MarcketPlace.dto.request.CustomerRegistration;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTORes {
    private Long id;
    private CustomerRegistration customer;
    private CustomerRegistration seller;
    private Integer rating;
    private String comment;
}
