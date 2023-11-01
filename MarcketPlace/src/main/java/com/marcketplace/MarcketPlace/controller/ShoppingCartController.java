package com.marcketplace.MarcketPlace.controller;

import com.marcketplace.MarcketPlace.model.Product;
import com.marcketplace.MarcketPlace.service.Impl.ShoppingCartImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ShoppingCart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartImpl cartImpl;

    @GetMapping
    @RequestMapping(value = "GetProducts", method = RequestMethod.GET)
    public ResponseEntity<?> GetProducts() {
        List<Product> products = this.cartImpl.GetProducts();
        return ResponseEntity.ok(products);
    }
    
    @PostMapping
    @RequestMapping(value = "createProduct", method = RequestMethod.POST)
     private ResponseEntity<?> createProduct(@RequestBody Product produc){
         Product cartProduct = this.cartImpl.createProduct(produc);
         return ResponseEntity.status(HttpStatus.CREATED).body(produc);
     }

     @PutMapping
     @RequestMapping(value = "modifyProduct", method = RequestMethod.PUT)
     public ResponseEntity<?> modifyProduct(@RequestBody Product product){
         Product productModificated = this.cartImpl.modifyProduct(product);
         return ResponseEntity.status(HttpStatus.CREATED).body(productModificated);
     }
     
     @GetMapping
     @RequestMapping(value = "consultProduct/{id}", method = RequestMethod.GET)
     public ResponseEntity<?> consultProduct(@PathVariable int id){
         Product product = this.cartImpl.consultProduct(id);
         return ResponseEntity.ok(product);
     }
     
     @DeleteMapping
     @RequestMapping(value = "deleteProduct/{id}", method = RequestMethod.DELETE)
     public ResponseEntity<?> deleteProduct(@PathVariable int id){
         this.cartImpl.deleteProduct(id);
         return ResponseEntity.ok().build();
     }
    }
