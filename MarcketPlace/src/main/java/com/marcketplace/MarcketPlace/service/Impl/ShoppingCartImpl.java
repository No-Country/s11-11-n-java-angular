package com.marcketplace.MarcketPlace.service.Impl;

import com.marcketplace.MarcketPlace.model.Product;
import com.marcketplace.MarcketPlace.repository.ShoppingCartRepository;
import com.marcketplace.MarcketPlace.service.ShoppingCartService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartImpl implements ShoppingCartService {
    
    @Autowired
    private ShoppingCartRepository cartRepository;

    @Override
    public List<Product> GetProducts() {
        return (List<Product>) this.cartRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        product.setId(product.getId());
        return this.cartRepository.save(product);
    }

    @Override
    public Product modifyProduct(Product product) {
        return this.cartRepository.save(product);
    }

    @Override
    public Product consultProduct(int id) {
        return this.cartRepository.findById(id).get();
    }

    @Override
    public void deleteProduct(int id) {
        this.cartRepository.deleteById(id);
    }
    
}
