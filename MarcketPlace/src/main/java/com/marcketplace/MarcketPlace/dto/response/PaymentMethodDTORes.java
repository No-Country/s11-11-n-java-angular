package com.marcketplace.MarcketPlace.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethodDTORes {

    private Long id;
    /*private User seller;*/
    private String name;
    private String paymentDetails;

}