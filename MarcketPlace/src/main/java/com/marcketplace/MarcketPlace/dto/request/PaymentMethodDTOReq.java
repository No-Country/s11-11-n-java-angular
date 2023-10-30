package com.marcketplace.MarcketPlace.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethodDTOReq {

    private Long id;
    /*  @NotNull(message = "No puede estar vacio")
        private UserDTOReq seller;*/
    @NotNull(message = "No puede estar vacio")
    private String name;
    @NotNull(message = "No puede estar vacio")
    private String paymentDetails;
}