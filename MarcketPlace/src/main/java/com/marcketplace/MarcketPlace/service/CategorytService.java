package com.marcketplace.MarcketPlace.service;

import com.marcketplace.MarcketPlace.dto.request.CategoryDTOReq;
import com.marcketplace.MarcketPlace.dto.response.CategoryDTORes;
import com.marcketplace.MarcketPlace.exception.IdNotFoundException;
import com.marcketplace.MarcketPlace.exception.NameExistsException;
import com.marcketplace.MarcketPlace.model.Category;
import com.marcketplace.MarcketPlace.repository.ICategoryRepository;
// import com.marcketplace.MarcketPlace.repository.IUserRepository;
// import com.marcketplace.MarcketPlace.repository.ICategoryRepository;
import com.marcketplace.MarcketPlace.util.IWordsConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategorytService implements ICategoryService {

    // @Autowired
    // private IProductRepository productRepository;
    // @Autowired
    // private IUserRepository userRepository;
    @Autowired
    private ICategoryRepository categoryRepository;
    @Autowired
    private IWordsConverter wordsConverter;
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Guarda una categoria en la base de datos
     * 
     * @param categoryDTO dto de categoria
     * @throws NameExistsException mensaje de excepcion de nombre de categoria ya
     *                             existe
     */
    @Override
    public void saveCategory(CategoryDTOReq categoryDTO) throws NameExistsException, IdNotFoundException {
        // if (!userRepository.existsById(productDTO.getUser().getId())){
        // throw new IdNotFoundException("El vendedor ingresado no se encuentra
        // registrado");
        // }
        if (categoryRepository.existsByName(categoryDTO.getName())) {
            throw new NameExistsException("El nombre " + categoryDTO.getName() + " ya existe. Ingrese un nuevo nombre");
        }
        // convierte la primer letra de cada palabra en mayúscula
        categoryDTO.setName(wordsConverter.capitalizeWords(categoryDTO.getName()));

        categoryRepository.save(modelMapper.map(categoryDTO, Category.class));
    }

    /**
     * Devuelve una lista de categorias paginados
     * 
     * @param pageable configuracion de paginacion
     * @return lista de categorias paginados
     */
    @Override
    public Page<CategoryDTORes> getAllCategories(Pageable pageable) {
        var categoriessDB = categoryRepository.findAll(pageable);
        var categoriesDTO = new ArrayList<CategoryDTORes>();
        // recorre la lista de productos de la DB, los convierte a DTO y los guarda en
        // una listaDTO
        for (Category category : categoriessDB) {
            categoriesDTO.add(modelMapper.map(category, CategoryDTORes.class));
        }
        return new PageImpl<>(categoriesDTO, pageable, categoriessDB.getTotalElements());
    }

    /**
     * Actualiza una categoria por id en base de datos
     * 
     * @param productDTO dto de producto
     * @throws IdNotFoundException mensaje de excepcion de id de produccto no
     *                             encontrado
     * @throws NameExistsException mensaje de excepcion de nombre de producto ya
     *                             exsiste
     */
    @Override
    public void updateCategory(CategoryDTOReq categoryDTO) throws IdNotFoundException, NameExistsException {
        var categoryDB = categoryRepository.findById(categoryDTO.getId())
                .orElseThrow(() -> new IdNotFoundException("El id " + categoryDTO + " no existe. Ingrese un nuevo id"));
        // if (!userRepository.existsById(productDTO.getUser().getId())) {
        // throw new IdNotFoundException("El vendedor ingresado no se encuentra
        // registrado");
        // }
        // if (!categoryRepository.existsById(productDTO.getCategory().getId())) {
        // throw new IdNotFoundException("La categoria ingresada no se encuentra
        // registrada");
        // }
        // valida que el nombre del producto no exista y si existe que coincida con el
        // producto encontrado
        if (!categoryDTO.getName().equals(categoryDB.getName())
                && categoryRepository.existsByName(categoryDTO.getName())) {
            throw new NameExistsException("El nombre " + categoryDTO.getName() + " ya existe. Ingrese un nuevo nombre");
        }
        // convierte la primer letra de cada palabra en mayúscula
        categoryDTO.setName(wordsConverter.capitalizeWords(categoryDTO.getName()));
        categoryRepository.save(modelMapper.map(categoryDTO, Category.class));
    }

    /**
     * Busca y devuelve una categoria por el nombre
     * 
     * @param categoryName numero de id de producto
     * @return dto de producto
     * @throws IdNotFoundException mensaje de excepcion de id de producto no
     *                             encontrado
     */
    @Override
    public Category getCategoryByName(String categoryName) throws NameExistsException {
        Category category = categoryRepository.findByName(categoryName)
                .orElseThrow(() -> new NameExistsException(
                        "El nomrbre " + categoryName + " no exite. Ingrese un nuevo nombre de categoria"));
        return category;
    }
}
