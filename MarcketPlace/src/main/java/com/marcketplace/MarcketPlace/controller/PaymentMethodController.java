package com.marcketplace.MarcketPlace.controller;

import com.marcketplace.MarcketPlace.dto.request.PaymentMethodDTOReq;
import com.marcketplace.MarcketPlace.dto.response.PaymentMethodDTORes;
import com.marcketplace.MarcketPlace.exception.IdNotFoundException;
import com.marcketplace.MarcketPlace.exception.NameExistsException;
import com.marcketplace.MarcketPlace.service.IPaymentMethodService;
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
 * Clase controlador de metodos de pago
 * @Autor Damian Canteros
 */
@Tag(name = "Controlador de metodos de pago")
@RestController
@RequestMapping("/api/v1/paymentMethods")
public class PaymentMethodController {

    @Autowired
    private IPaymentMethodService paymentMethodService;

    /**
     * Guarda el metodo de pago
     * @param paymentMethodDTO dto de metodo de pago
     * @return respuesta http con estado creado
     * @throws NameExistsException mensaje de excepcion de nombre ya existe en base de datos
     */
    @Operation(
            summary = "Guarda un metodo de pago",
            description = "Guarda el metodo de pago y devuelve un Codigo de estado 201 creado"
    )
    @PostMapping()
    public ResponseEntity<HttpStatus> savePaymentMethod(@Valid @RequestBody PaymentMethodDTOReq paymentMethodDTO) throws NameExistsException, IdNotFoundException {
        paymentMethodService.savePaymentMethod(paymentMethodDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Busca un metodo de pago por id
     * @param paymentMethodId numero de id del metodo de pago
     * @return respuesta http con dto del metodo de pago
     * @throws IdNotFoundException mensaje de excepcion de id no encontrado
     */
    @Operation(
            summary = "Trae un metodo de pago",
            description = "Busca un metodo de pago por id y devuelve un Codigo de estado 200 y los datos del metodo de pago"
    )
    @GetMapping("/{paymentMethodId}")
    public ResponseEntity<PaymentMethodDTORes> getPaymentMethod(@PathVariable Long paymentMethodId) throws IdNotFoundException {
        return ResponseEntity.ok(paymentMethodService.getPaymentMethodById(paymentMethodId));
    }

    /**
     * Trae todos los metodos de pago de base de datos
     * @param pageable configuracion de paginado
     * @return respuesta http con lista de metodos de pago paginados
     */
    @Operation(
            summary = "Traer todos los metodos de pago",
            description = "Trae todos los metodos de pago de base de datos y devuelve un Codigo de estado 200 y el listado de metodos de pago"
    )
    @GetMapping()
    public ResponseEntity<Page<PaymentMethodDTORes>> getAllPaymentMethods(Pageable pageable){
        return ResponseEntity.ok(paymentMethodService.getAllPaymentMethods(pageable));
    }

    /**
     * Busca un metodo de pago por id y lo actualiza
     * @param paymentMethodDTO datos de metodo de pago a actualizar
     * @return respuesta http con estado sin contenido
     * @throws IdNotFoundException mensaje de excepcion de id no encontrado
     * @throws NameExistsException mensaje de excepcion de nombre de metodo de pago ya existe en base de datos
     */
    @Operation(
            summary = "Actualiza un metodo de pago",
            description = "Busca un metodo de pago por id y lo actualiza, devuelve un Codigo de estado 204"
    )
    @PutMapping()
    public ResponseEntity<HttpStatus> updatePaymentMethod(@Valid @RequestBody PaymentMethodDTOReq paymentMethodDTO) throws IdNotFoundException,
            NameExistsException {
        paymentMethodService.updatePaymentMethod(paymentMethodDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Elimina un metodo de pago por id
     * @param paymentMethodId numero de id de metodo de pago
     * @return respuesta http con estado sin contenido
     */
    @Operation(
            summary = "Elimina un metodo de pago",
            description = "Elimina un metodo de pago por id, devuelve un Codigo de estado 204"
    )
    @DeleteMapping("/{paymentMethodId}")
    public ResponseEntity<HttpStatus> deletePaymentMethod(@PathVariable Long paymentMethodId) {
        paymentMethodService.deletePaymentMethod(paymentMethodId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
