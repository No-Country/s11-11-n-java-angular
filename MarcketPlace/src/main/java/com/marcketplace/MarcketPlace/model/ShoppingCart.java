package com.marcketplace.MarcketPlace.model;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart implements Serializable {
    
        private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private int shoppingCartId;

    @Column(name = "quantity", nullable = false)
    private int quantity;

   @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;
/*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;*/
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "purchase_order_id", referencedColumnName = "purchase_order_id")
    private PurchaseOrder order;
    
}
