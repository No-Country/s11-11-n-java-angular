package com.marcketplace.MarcketPlace.service;

import com.marcketplace.MarcketPlace.dto.request.PaymentMethodDTOReq;
import com.marcketplace.MarcketPlace.dto.response.PaymentMethodDTORes;
import com.marcketplace.MarcketPlace.exception.IdNotFoundException;
import com.marcketplace.MarcketPlace.exception.NameExistsException;
import com.marcketplace.MarcketPlace.model.PaymentMethod;
import com.marcketplace.MarcketPlace.repository.CustomerRepository;
import com.marcketplace.MarcketPlace.repository.IPaymentMethodRepository;
import com.marcketplace.MarcketPlace.util.IWordsConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PaymentMethodService implements IPaymentMethodService{

    @Autowired
    private IPaymentMethodRepository paymentMethodRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private IWordsConverter wordsConverter;
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Guarda un metodo de pago en base de datos
     * @param paymentMethodDTO dto de metodo de pago
     * @throws NameExistsException mensaje de excepcion de nombre de metodo de pago ya existe
     */
    @Override
    public void savePaymentMethod(PaymentMethodDTOReq paymentMethodDTO) throws NameExistsException, IdNotFoundException {
        if (!customerRepository.existsById(paymentMethodDTO.getSeller().getEmail())){
            throw new IdNotFoundException("El vendedor ingresado no se encuentra registrado");
        }
        if (paymentMethodRepository.existsByName(paymentMethodDTO.getName())) {
            throw new NameExistsException("El nombre " + paymentMethodDTO.getName() + " ya existe. Ingrese un nuevo nombre");
        }
        //convierte la primer letra de cada palabra en mayúscula
        paymentMethodDTO.setName(wordsConverter.capitalizeWords(paymentMethodDTO.getName()));

        paymentMethodRepository.save(modelMapper.map(paymentMethodDTO, PaymentMethod.class));
    }

    /**
     * Busca y devuelve un metodo de pago por id
     * @param paymentMethodId numero de id de metodo de pago
     * @return dto de metodo de pago
     * @throws IdNotFoundException mensaje de excepcion de id de metodo de pago no encontrado
     */
    @Override
    public PaymentMethodDTORes getPaymentMethodById(Long paymentMethodId) throws IdNotFoundException {
        return modelMapper.map(paymentMethodRepository.findById(paymentMethodId)
                .orElseThrow(() -> new IdNotFoundException("El id " + paymentMethodId + " no exite. Ingrese un nuevo id")), PaymentMethodDTORes.class);
    }

    /**
     * Devuelve una lista de metodos de pago paginados
     * @param pageable configuracion de paginacion
     * @return lista de metodos de pago paginados
     */
    @Override
    public Page<PaymentMethodDTORes> getAllPaymentMethods(Pageable pageable) {
        var paymentMethodsDB = paymentMethodRepository.findAll(pageable);
        var paymentMethodsDTO = new ArrayList<PaymentMethodDTORes>();
        //recorre la lista de metodos de pago de la DB, los convierte a DTO y los guarda en una listaDTO
        for (PaymentMethod paymentMethod : paymentMethodsDB) {
            paymentMethodsDTO.add(modelMapper.map(paymentMethod, PaymentMethodDTORes.class));
        }
        return new PageImpl<>(paymentMethodsDTO, pageable, paymentMethodsDB.getTotalElements());
    }

    /**
     * Actualiza un metodo de pago por id en base de datos
     * @param paymentMethodDTO dto de metodo de pago
     * @throws IdNotFoundException mensaje de excepcion de id de metodo de pago no encontrado
     * @throws NameExistsException mensaje de excepcion de nombre de metodo de pago ya exsiste
     */
    @Override
    public void updatePaymentMethod(PaymentMethodDTOReq paymentMethodDTO) throws IdNotFoundException, NameExistsException {
        var paymentMethodDB = paymentMethodRepository.findById(paymentMethodDTO.getId())
                .orElseThrow(() -> new IdNotFoundException("El id " + paymentMethodDTO + " no existe. Ingrese un nuevo id"));
        if (!customerRepository.existsById(paymentMethodDTO.getSeller().getEmail())){
            throw new IdNotFoundException("El vendedor ingresado no se encuentra registrado");
        }
        //convierte la primer letra de cada palabra en mayúscula
        paymentMethodDTO.setName(wordsConverter.capitalizeWords(paymentMethodDTO.getName()));
        paymentMethodRepository.save(modelMapper.map(paymentMethodDTO, PaymentMethod.class));
    }

    /**
     * Elimina un metodo de pago de base de datos
     * @param paymentMethodID numero de id de metodo de pago
     */
    @Override
    public void deletePaymentMethod(Long paymentMethodID) {
        paymentMethodRepository.deleteById(paymentMethodID);
    }
}