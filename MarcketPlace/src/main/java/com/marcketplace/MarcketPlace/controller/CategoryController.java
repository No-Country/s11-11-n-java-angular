package com.marcketplace.MarcketPlace.controller;

import com.marcketplace.MarcketPlace.dto.request.CategoryDTOReq;
import com.marcketplace.MarcketPlace.dto.response.CategoryDTORes;
import com.marcketplace.MarcketPlace.exception.IdNotFoundException;
import com.marcketplace.MarcketPlace.exception.NameExistsException;
import com.marcketplace.MarcketPlace.service.ICategoryService;

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
 * Clase controlador de categorias
 *
 * @Autor Damian Della corte
 */
@Tag(name = "Controlador de categorias")
@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    /**
     * Guarda el producto
     *
     * @param categoryDTO dto de producto
     * @return respuesta http con estado creado
     * @throws NameExistsException mensaje de excepcion de nombre ya existe en base
     *                             de datos
     */
    @Operation(summary = "Guarda una categoria", description = "Guarda la categoria y devuelve un Codigo de estado 201 creado")
    @PostMapping()
    public ResponseEntity<HttpStatus> saveCategory(@Valid @RequestBody CategoryDTOReq categoryDTO)
            throws NameExistsException, IdNotFoundException {
        categoryService.saveCategory(categoryDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Trae todos las categorias de base de datos
     *
     * @param pageable configuracion de paginado
     * @return respuesta http con lista de categorias paginados
     */
    @Operation(summary = "Traer todas las categorias", description = "Trae todos las categorias de base de datos y devuelve un Codigo de estado 200 y el listado de categorias")
    @GetMapping()
    public ResponseEntity<Page<CategoryDTORes>> getAllCategories(Pageable pageable) {
        return ResponseEntity.ok(categoryService.getAllCategories(pageable));
    }

    /**
     * Busca una categoria por id y lo actualiza
     *
     * @param categoryDTO datos de categoria a actualizar
     * @return respuesta http con estado sin contenido
     * @throws IdNotFoundException mensaje de excepcion de id no encontrado
     * @throws NameExistsException mensaje de excepcion de nombre de categoria ya
     *                             existe en base de datos
     */
    @Operation(summary = "Actualiza una categorias", description = "Busca una categoria por id y lo actualiza, devuelve un Codigo de estado 204")
    @PutMapping()
    public ResponseEntity<HttpStatus> updateCategory(@Valid @RequestBody CategoryDTOReq categoryDTO)
            throws IdNotFoundException,
            NameExistsException {
        categoryService.updateCategory(categoryDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
