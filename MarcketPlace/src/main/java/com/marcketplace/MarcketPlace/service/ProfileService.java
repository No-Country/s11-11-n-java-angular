package com.marcketplace.MarcketPlace.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.marcketplace.MarcketPlace.dto.request.ProfileUpdateDTO;

import com.marcketplace.MarcketPlace.dto.response.ProfileDTORes;
import com.marcketplace.MarcketPlace.exception.IdNotFoundException;
import com.marcketplace.MarcketPlace.exception.NameExistsException;

import com.marcketplace.MarcketPlace.model.Customers;

// import com.marcketplace.MarcketPlace.repository.AccountRepository;
import com.marcketplace.MarcketPlace.repository.CustomerRepository;



import org.modelmapper.ModelMapper;

@Service
public class ProfileService implements IProfileService {

    @Autowired
    private CustomerRepository customerRepository;

    // @Autowired
    // private AccountRepository accountRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Customers> GetUser() {
        return (List<Customers>) this.customerRepository.findAll();
    }


// Servicio para listar cliente por Email
    @Override
    public ProfileDTORes getCustomerByEmail(String byEmail) throws IdNotFoundException {
        return modelMapper.map(customerRepository.findByEmail(byEmail)
                .orElseThrow(
                        () -> new IdNotFoundException("El email " + byEmail + " no exite. Ingrese un nuevo email")),
                ProfileDTORes.class);
    }

    // Servicio para actualizar cliente
    @Override
    public void updateCustomer(ProfileUpdateDTO profileUpdateDTO) throws IdNotFoundException, NameExistsException {

        var customerDB = customerRepository.findByEmail(profileUpdateDTO.getEmail())
                .orElseThrow(() -> new IdNotFoundException(
                        "El email " + profileUpdateDTO + " no existe. Ingrese un nuevo email"));

        // Actualiza los campos del cliente con los valores del objeto profileUpdateDTO
        modelMapper.map(profileUpdateDTO, customerDB);;
        // Añade más actualizaciones aquí según tus necesidades

        // Guarda el cliente actualizado en la base de datos
        customerRepository.save(customerDB);
    }
}
