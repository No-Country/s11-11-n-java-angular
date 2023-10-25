package com.marcketplace.MarcketPlace.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTOReq {
    private Long id;
    @NotNull(message = "No puede estar vacio")
    private CustomerRegistration customer;
    @NotNull(message = "No puede estar vacio")
    private CustomerRegistration seller;
    private Integer rating;
    private String comment;

}
