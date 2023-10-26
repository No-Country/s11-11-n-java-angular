package com.marcketplace.MarcketPlace.repository;

import com.marcketplace.MarcketPlace.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReviewRepository extends JpaRepository<Review, Long> {

}
