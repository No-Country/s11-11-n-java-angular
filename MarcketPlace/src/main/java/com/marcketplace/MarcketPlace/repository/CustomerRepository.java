package com.marcketplace.MarcketPlace.repository;


import com.marcketplace.MarcketPlace.model.Account;
import com.marcketplace.MarcketPlace.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CustomerRepository extends JpaRepository<Customers, String> {
    Optional<Customers> findByEmail(String email);

    Optional<Customers> findByAccountUuid(String uuid);

}
