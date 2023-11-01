package com.marcketplace.MarcketPlace.dto.request;

import com.marcketplace.MarcketPlace.model.Customers;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTOReq {

    private Long id;
    @NotNull(message = "No puede estar vacio")
    private String name;
    @DecimalMin(value = "0.0", message = "El valor mínimo ingresado debe ser 0.0")
    @NotNull(message = "No puede estar vacio")
    private Double price;
    @NotNull(message = "No puede estar vacio")
    private String images;
    @NotNull(message = "El Seller no puede estar vacio")
    private Customers seller;
    @NotNull(message = "No puede estar vacio")
    private CategoryDTOReq category;
    @NotNull(message = "No puede estar vacio")
    private String shippingStatus;
    @NotNull(message = "No puede estar vacio")
    private int stock;

}
