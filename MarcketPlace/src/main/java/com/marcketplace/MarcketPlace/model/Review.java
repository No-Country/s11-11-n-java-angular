package com.marcketplace.MarcketPlace.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "review")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "customerID")
    @JsonIgnoreProperties("products")
    private Customers customer;
    @ManyToOne
    @JoinColumn(name = "sellerID")
    @JsonIgnoreProperties("products")
    private Customers seller;
    private Integer rating;
    private String comment;

}