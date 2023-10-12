package com.marcketplace.MarcketPlace.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;
    private String name;
    private String description;
    private Double price;
    private String images;
//    @ManyToOne
//    @JoinColumn(name = "sellerID")
//    @JsonIgnoreProperties("products")
//    private User seller;
//    @ManyToOne
//    @JoinColumn(name = "categoryID")
//    @JsonIgnoreProperties("products")
//    private Category category;
//    private String shippingStatus;
//    private int stock;
    
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<ShoppingCart> cartProducts;

}
