package com.marcketplace.MarcketPlace.service;

import com.marcketplace.MarcketPlace.dto.request.ReviewDTOReq;
import com.marcketplace.MarcketPlace.dto.response.ReviewDTORes;
import com.marcketplace.MarcketPlace.exception.IdNotFoundException;
import com.marcketplace.MarcketPlace.model.Review;
import com.marcketplace.MarcketPlace.repository.CustomerRepository;
import com.marcketplace.MarcketPlace.repository.IReviewRepository;
import com.marcketplace.MarcketPlace.util.IWordsConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ReviewService implements IReviewService{

    @Autowired
    private IReviewRepository reviewRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private IWordsConverter wordsConverter;
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Guarda una reseña en base de datos
     * @param reviewDTO dto de reseña
     */
    @Override
    public void saveReview(ReviewDTOReq reviewDTO) throws IdNotFoundException {
        if (customerRepository.findByEmail(reviewDTO.getSeller().getEmail()).isEmpty()){
            throw new IdNotFoundException("El vendedor ingresado no se encuentra registrado");
        }
        //convierte la primer letra de cada palabra en mayúscula
        reviewDTO.setComment(wordsConverter.capitalizeWords(reviewDTO.getComment()));

        reviewRepository.save(modelMapper.map(reviewDTO, Review.class));
    }
 
    /**
     * Busca y devuelve una reseña por id
     * @param reviewId numero de id de reseña
     * @return dto de reseña
     * @throws IdNotFoundException mensaje de excepcion de id de reseña no encontrada
     */
    @Override
    public ReviewDTORes getReviewById(Long reviewId) throws IdNotFoundException {
        return modelMapper.map(reviewRepository.findById(reviewId)
                .orElseThrow(() -> new IdNotFoundException("El id " + reviewId + " no exite. Ingrese un nuevo id")), ReviewDTORes.class);
    }

    /**
     * Devuelve una lista de reseña paginadas
     * @param pageable configuracion de paginacion
     * @return lista de reseña paginadas
     */
    @Override
    public Page<ReviewDTORes> getAllReviews(Pageable pageable) {
        var reviewsDB = reviewRepository.findAll(pageable);
        var reviewsDTO = new ArrayList<ReviewDTORes>();
        //recorre la lista de reseña de la DB, los convierte a DTO y los guarda en una listaDTO
        for (Review review : reviewsDB) {
            reviewsDTO.add(modelMapper.map(review, ReviewDTORes.class));
        }
        return new PageImpl<>(reviewsDTO, pageable, reviewsDB.getTotalElements());
    }

    /**
     * Actualiza una reseña por id en base de datos
     * @param reviewDTO dto de reseña
     * @throws IdNotFoundException mensaje de excepcion de id de reseña no encontrado
     */
    @Override
    public void updateReview(ReviewDTOReq reviewDTO) throws IdNotFoundException {
        var reviewDB = reviewRepository.findById(reviewDTO.getId())
                .orElseThrow(() -> new IdNotFoundException("El id " + reviewDTO + " no existe. Ingrese un nuevo id"));
        if (customerRepository.findByEmail(reviewDTO.getSeller().getEmail()).isEmpty()){
            throw new IdNotFoundException("El vendedor ingresado no se encuentra registrado");
        }
        //convierte la primer letra de cada palabra en mayúscula
        reviewDTO.setComment(wordsConverter.capitalizeWords(reviewDTO.getComment()));

        reviewRepository.save(modelMapper.map(reviewDTO, Review.class));
    }

    /**
     * Elimina una reseña de base de datos
     * @param reviewID numero de id de reseña
     */
    @Override
    public void deleteReview(Long reviewID) {
        reviewRepository.deleteById(reviewID);
    }
}
