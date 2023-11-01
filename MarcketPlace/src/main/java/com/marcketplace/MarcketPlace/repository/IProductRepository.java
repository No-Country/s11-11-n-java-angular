package com.marcketplace.MarcketPlace.repository;

import com.marcketplace.MarcketPlace.model.Category;
import com.marcketplace.MarcketPlace.model.Product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

public interface IProductRepository extends JpaRepository<Product, Long> {
    boolean existsByName(String name);


    //  --------Filtros-----
    // Byname
    // List<Product> findByName(String name);
    List<Product> findByNameStartsWith(String name);

    // ByCategoryName
    @Query("SELECT p FROM Product p WHERE p.category.name LIKE %:categoryName%")
    List<Product> findProductsByCategoryName(@Param("categoryName") String categoryName);
    
    // ByPriceProduct
    @Query("SELECT p FROM Product p where p.price>= :minPrice AND p.price<= :maxPrice")
    List<Product> findProductsByPrice(@Param("minPrice") double minPrice, @Param("maxPrice") double maxPrice);

}
