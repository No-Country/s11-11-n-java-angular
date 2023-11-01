package com.marcketplace.MarcketPlace.service;

import com.marcketplace.MarcketPlace.dto.request.ProductDTOReq;
import com.marcketplace.MarcketPlace.dto.response.ProductDTORes;
import com.marcketplace.MarcketPlace.exception.IdNotFoundException;
import com.marcketplace.MarcketPlace.exception.NameExistsException;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {

    void saveProduct(ProductDTOReq productDTO) throws NameExistsException, IdNotFoundException;

    ProductDTORes getProductById(Long productId) throws IdNotFoundException;

    Page<ProductDTORes> getAllProducts(Pageable pageable);

    void updateProduct(ProductDTOReq productDTO) throws IdNotFoundException, NameExistsException;

    void deleteProduct(Long productID);

    // Filters Personalizados

}
