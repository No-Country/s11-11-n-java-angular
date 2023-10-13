package com.marcketplace.MarcketPlace.service;

import com.marcketplace.MarcketPlace.model.Product;
import java.util.List;

public interface ShoppingCartService {
    
    List<Product> GetProducts();
    
    Product createProduct(Product product);
    
    Product modifyProduct(Product product);
    
    Product consultProduct(int id);
    
    void deleteProduct(int id);
    
}
