package com.marcketplace.MarcketPlace.dto.response;

import com.marcketplace.MarcketPlace.model.Customers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethodDTORes {

    private Long id;
    private Customers seller;
    private String name;
    private String paymentDetails;

}