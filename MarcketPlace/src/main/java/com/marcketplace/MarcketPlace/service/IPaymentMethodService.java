package com.marcketplace.MarcketPlace.service;

import com.marcketplace.MarcketPlace.dto.request.PaymentMethodDTOReq;
import com.marcketplace.MarcketPlace.dto.response.PaymentMethodDTORes;
import com.marcketplace.MarcketPlace.exception.IdNotFoundException;
import com.marcketplace.MarcketPlace.exception.NameExistsException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPaymentMethodService {

    void savePaymentMethod(PaymentMethodDTOReq paymentMethodDTO) throws NameExistsException, IdNotFoundException;
    PaymentMethodDTORes getPaymentMethodById(Long paymentMethodId) throws IdNotFoundException;

    Page<PaymentMethodDTORes> getAllPaymentMethods(Pageable pageable);
    void updatePaymentMethod(PaymentMethodDTOReq paymentMethodDTO) throws IdNotFoundException, NameExistsException;
    void deletePaymentMethod(Long paymentMethodID);
}