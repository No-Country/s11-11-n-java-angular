package com.marcketplace.MarcketPlace.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.marcketplace.MarcketPlace.dto.request.CategoryDTOReq;
import com.marcketplace.MarcketPlace.dto.response.CategoryDTORes;
import com.marcketplace.MarcketPlace.exception.IdNotFoundException;
import com.marcketplace.MarcketPlace.exception.NameExistsException;
import com.marcketplace.MarcketPlace.model.Category;

public interface ICategoryService {
    void saveCategory(CategoryDTOReq categoryDTO) throws NameExistsException, IdNotFoundException;

    // CategoryDTORes getCategoryById(Long categoryId) throws IdNotFoundException;

    Page<CategoryDTORes> getAllCategories(Pageable pageable);

    void updateCategory(CategoryDTOReq categoryDTO) throws IdNotFoundException, NameExistsException;

    Category getCategoryByName(String categoryName) throws NameExistsException;
    // void deleteCategory(Long categoryID);
}
