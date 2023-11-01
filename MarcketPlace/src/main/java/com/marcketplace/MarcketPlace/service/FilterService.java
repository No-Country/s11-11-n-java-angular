package com.marcketplace.MarcketPlace.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import com.marcketplace.MarcketPlace.dto.response.ProductDTORes;
import com.marcketplace.MarcketPlace.model.Product;
import com.marcketplace.MarcketPlace.repository.IProductRepository;

@Service
public class FilterService implements IFilterService {
    @Autowired
    IProductRepository productRepository;
    @Autowired
    private ModelMapper modelMapper;

    /// FILTERS PERSONALIZADOS

    // @Override
    // public ProductDTORes getAllProductsByName(String name) throws
    // IdNotFoundException {
    // return modelMapper.map(productRepository.findByName(name)
    // .orElseThrow(() -> new IdNotFoundException("El name " + name + " no existe.
    // Ingrese un nuevo name")), ProductDTORes.class);

    // }

    @Override
    public List<ProductDTORes> getAllProductsByCategory(String categoryName) {
        List<Product> products = productRepository.findProductsByCategoryName(categoryName);
        List<ProductDTORes> productDTOs = products.stream()
                .map(product -> modelMapper.map(product, ProductDTORes.class))
                .collect(Collectors.toList());
        return productDTOs;
    }

    // public List<ProductDTORes> getAllProductsByName(String name) {
    // List<Product> products = productRepository.findByName(name);
    // List<ProductDTORes> productDTOs = products.stream()
    // .map(product -> modelMapper.map(product, ProductDTORes.class))
    // .collect(Collectors.toList());
    // return productDTOs;
    // }

    public List<ProductDTORes> getAllProductsByName(String name) {
        List<Product> products = productRepository.findByNameStartsWith(name);
        List<ProductDTORes> productDTOs = products.stream()
                .map(product -> modelMapper.map(product, ProductDTORes.class))
                .collect(Collectors.toList());
        return productDTOs;
    }

    @Override
    public List<ProductDTORes> getAllProductsByPrice(Double minPrice, Double maxPrice) {
        List<Product> products = productRepository.findProductsByPrice(minPrice, maxPrice);
        List<ProductDTORes> productDTOs = products.stream()
                .map(product -> modelMapper.map(product, ProductDTORes.class))
                .collect(Collectors.toList());
        return productDTOs;
    }

    @Override
    public List<ProductDTORes> searchProducts(String name, String categoryName, Double minPrice, Double maxPrice) {
        // Lógica para buscar productos basada en los parámetros proporcionados

        List<Product> products = productRepository.findAll(); // Obtén todos los productos inicialmente

        if (name != null) {
            String searchNameLower = name.toLowerCase(); 
            products = products.stream()
                    .filter(product -> product.getName().toLowerCase().contains(searchNameLower))
                    .collect(Collectors.toList());
        }

        if (categoryName != null) {
            String searchCategoryLower = categoryName.toLowerCase();
            products = products.stream()
                    .filter(product -> product.getCategory().getName().toLowerCase().contains (searchCategoryLower))
                    .collect(Collectors.toList());
        }

        if (minPrice != null) {
            products = products.stream()
                    .filter(product -> product.getPrice() >= minPrice)
                    .collect(Collectors.toList());
        }

        if (maxPrice != null) {
            products = products.stream()
                    .filter(product -> product.getPrice() <= maxPrice)
                    .collect(Collectors.toList());
        }

        // Mapea los productos filtrados a DTO y devuélvelos
        List<ProductDTORes> productDTOs = products.stream()
                .map(product -> modelMapper.map(product, ProductDTORes.class))
                .collect(Collectors.toList());

        return productDTOs;
    }

}
