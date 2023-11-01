package com.marcketplace.MarcketPlace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marcketplace.MarcketPlace.dto.response.ProductDTORes;
import com.marcketplace.MarcketPlace.exception.IdNotFoundException;
import com.marcketplace.MarcketPlace.service.IFilterService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Filtros de productos")
@RestController
@RequestMapping("/api/v1/filters")
public class FilterController {
    @Autowired
    private IFilterService filterService;

    // FILTROS PERSONALIZADOS

   
    // @GetMapping("/byName/{name}")
    // public ResponseEntity<List<ProductDTORes>> getProductByName(@PathVariable String name) throws IdNotFoundException {
    //     List<ProductDTORes> productDTOs = filterService.getAllProductsByName(name);
    //     return ResponseEntity.ok(productDTOs);
    // }
 @Operation(
            summary = "Trae un producto por su nombre",
            description = "Busca un producto por nombre y devuelve un Codigo de estado 200 y los datos del producto"
    )
    @GetMapping("/searchName/{name}")
    public ResponseEntity<List<ProductDTORes>> searchProducts(@PathVariable String name) {
        List<ProductDTORes> productDTOs = filterService.getAllProductsByName(name);
        return ResponseEntity.ok(productDTOs);
    }

     @GetMapping("/searchCategory/{categoryName}")
     public ResponseEntity<List<ProductDTORes>> searchProductsByCategory(@PathVariable String categoryName) {
        List<ProductDTORes> productDTOs = filterService.getAllProductsByCategory(categoryName);
        return ResponseEntity.ok(productDTOs);
    }

    @GetMapping("/searchPrice/price")
    public ResponseEntity<List<ProductDTORes>> searchProductsByPriceRange(@RequestParam double minPrice, @RequestParam double maxPrice){
         List<ProductDTORes> productDTOs = filterService.getAllProductsByPrice(minPrice, maxPrice);
         return ResponseEntity.ok(productDTOs);

    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductDTORes>> searchProducts
    (
        
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String category,
        @RequestParam(required = false) Double minPrice,
        @RequestParam(required = false) Double maxPrice) {
            

        List<ProductDTORes> productDTOs = filterService.searchProducts(name, category, minPrice, maxPrice);

        return ResponseEntity.ok(productDTOs);
    }

    
}
