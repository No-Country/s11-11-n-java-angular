package com.marcketplace.MarcketPlace.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String images;
    /*    @ManyToOne
        @JoinColumn(name = "sellerID")
        @JsonIgnoreProperties("products")
        private User seller;*/
    @ManyToOne
    @JoinColumn(name = "categoryID")
    @JsonIgnoreProperties("products")
    private Category category;
    private String shippingStatus;
    private int stock;
    
   @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
   private List<ShoppingCart> cartProducts;

}