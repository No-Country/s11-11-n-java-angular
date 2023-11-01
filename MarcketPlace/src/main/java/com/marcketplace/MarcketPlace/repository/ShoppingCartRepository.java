package com.marcketplace.MarcketPlace.repository;

import com.marcketplace.MarcketPlace.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingCartRepository extends CrudRepository<Product, Integer> {
    
}
