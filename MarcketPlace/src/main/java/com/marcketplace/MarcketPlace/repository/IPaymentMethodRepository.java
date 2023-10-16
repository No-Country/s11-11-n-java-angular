package com.marcketplace.MarcketPlace.repository;

import com.marcketplace.MarcketPlace.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
    boolean existsByName(String name);
}
