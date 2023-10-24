package com.marcketplace.MarcketPlace.service;

import java.util.List;

import com.marcketplace.MarcketPlace.dto.response.ProductDTORes;

public interface IFilterService {

    // List<ProductDTORes> getAllProductsByName(String name);
    List<ProductDTORes> getAllProductsByName(String name);

    List<ProductDTORes> getAllProductsByCategory(String categoryName);

    List<ProductDTORes> getAllProductsByPrice(Double minPrice, Double maxPrice);

    List<ProductDTORes> searchProducts(String name, String categoryName, Double minPrice, Double maxPrice);
    
}
