package com.marcketplace.MarcketPlace.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerDTOReq {

    @NotNull(message = "El campo de email no puede estar vacío")
    private String email;
    
}
