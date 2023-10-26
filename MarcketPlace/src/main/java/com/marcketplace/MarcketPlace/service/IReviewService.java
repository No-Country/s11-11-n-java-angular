package com.marcketplace.MarcketPlace.service;

import com.marcketplace.MarcketPlace.dto.request.ReviewDTOReq;
import com.marcketplace.MarcketPlace.dto.response.ReviewDTORes;
import com.marcketplace.MarcketPlace.exception.IdNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IReviewService {

    void saveReview(ReviewDTOReq reviewDTO) throws IdNotFoundException;
    ReviewDTORes getReviewById(Long reviewId) throws IdNotFoundException;

    Page<ReviewDTORes> getAllReviews(Pageable pageable);
    void updateReview(ReviewDTOReq reviewDTO) throws IdNotFoundException;
    void deleteReview(Long reviewID);
}
