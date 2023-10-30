package com.marcketplace.MarcketPlace.repository;

import com.marcketplace.MarcketPlace.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
    boolean existsByName(String name);
}
