package com.marcketplace.MarcketPlace.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "paymentMethods")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*    @ManyToOne
        @JoinColumn(name = "sellerID")
        @JsonIgnoreProperties("products")
        private User seller;*/
    private String name;
    private String paymentDetails;

}