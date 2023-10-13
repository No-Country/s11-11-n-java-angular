package com.marcketplace.MarcketPlace.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity
@Table(name = "purchase_order")
public class PurchaseOrder implements Serializable {
    
    private final static long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "purchase_order_id")
    private int purchaseOrderID;
    
    @Column(name = "date_order")
    private Date dateOrder;
    
    @Column(name = "total_amount")
    private double TotalAmount;
    
    @Size(max = 255)
    @Column(name = "status")
    private String status;
    
    @OneToOne(mappedBy = "order", fetch = FetchType.EAGER)
    private ShoppingCart cart;
    
}