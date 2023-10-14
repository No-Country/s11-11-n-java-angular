package com.marcketplace.MarcketPlace.repository;

import com.marcketplace.MarcketPlace.model.Category;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByName(String name);

    Optional<Category> findByName(String name);
}
