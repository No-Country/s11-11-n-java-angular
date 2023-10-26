package com.marcketplace.MarcketPlace.controller;

import com.marcketplace.MarcketPlace.dto.request.ReviewDTOReq;
import com.marcketplace.MarcketPlace.dto.response.ReviewDTORes;
import com.marcketplace.MarcketPlace.exception.IdNotFoundException;
import com.marcketplace.MarcketPlace.exception.NameExistsException;
import com.marcketplace.MarcketPlace.service.IReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

    /**
     * Clase controlador de reseña
     * @Autor Damian Canteros
     */
    @Tag(name = "Controlador de reseña")
    @RestController
    @RequestMapping("/api/v1/reviews")
    public class ReviewController {

        @Autowired
        private IReviewService reviewService;

        /**
         * Guarda la reseña
         * @param reviewDTO dto de reseña
         * @return respuesta http con estado creado
         */
        @Operation(
                summary = "Guarda una reseña",
                description = "Guarda la reseña y devuelve un Codigo de estado 201 creado"
        )
        @PostMapping()
        public ResponseEntity<HttpStatus> saveReview(@Valid @RequestBody ReviewDTOReq reviewDTO) throws IdNotFoundException {
            reviewService.saveReview(reviewDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        /**
         * Busca una reseña por id
         * @param reviewId numero de id de la reseña
         * @return respuesta http con dto de la reseña
         * @throws IdNotFoundException mensaje de excepcion de id no encontrado
         */
        @Operation(
                summary = "Trae una reseña",
                description = "Busca una reseña por id y devuelve un Codigo de estado 200 y los datos de la reseña"
        )
        @GetMapping("/{reviewId}")
        public ResponseEntity<ReviewDTORes> getReview(@PathVariable Long reviewId) throws IdNotFoundException {
            return ResponseEntity.ok(reviewService.getReviewById(reviewId));
        }

        /**
         * Trae todas las reseñas de base de datos
         * @param pageable configuracion de paginado
         * @return respuesta http con lista de reseñas paginados
         */
        @Operation(
                summary = "Traer todos las reseñas",
                description = "Trae todas las reseñas de base de datos y devuelve un Codigo de estado 200 y el listado de las reseñas"
        )
        @GetMapping()
        public ResponseEntity<Page<ReviewDTORes>> getAllReviews(Pageable pageable){
            return ResponseEntity.ok(reviewService.getAllReviews(pageable));
        }

        /**
         * Busca una reseña por id y lo actualiza
         * @param reviewDTO datos de reseña a actualizar
         * @return respuesta http con estado sin contenido
         * @throws IdNotFoundException mensaje de excepcion de id no encontrado
         */
        @Operation(
                summary = "Actualiza una reseña",
                description = "Busca una reseña por id y lo actualiza, devuelve un Codigo de estado 204"
        )
        @PutMapping()
        public ResponseEntity<HttpStatus> updateReview(@Valid @RequestBody ReviewDTOReq reviewDTO) throws IdNotFoundException,
                NameExistsException {
            reviewService.updateReview(reviewDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        /**
         * Elimina una reseña por id
         * @param reviewId numero de id de reseña
         * @return respuesta http con estado sin contenido
         */
        @Operation(
                summary = "Elimina una reseña",
                description = "Elimina una reseña por id, devuelve un Codigo de estado 204"
        )
        @DeleteMapping("/{reviewId}")
        public ResponseEntity<HttpStatus> deleteReview(@PathVariable Long reviewId) {
            reviewService.deleteReview(reviewId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
