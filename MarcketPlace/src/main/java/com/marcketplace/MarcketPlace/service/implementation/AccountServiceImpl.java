package com.marcketplace.MarcketPlace.service.implementation;

import com.marcketplace.MarcketPlace.dto.request.CustomerRegistration;
import com.marcketplace.MarcketPlace.model.Account;
import com.marcketplace.MarcketPlace.model.Customers;
import com.marcketplace.MarcketPlace.repository.AccountRepository;
import com.marcketplace.MarcketPlace.repository.CustomerRepository;
import com.marcketplace.MarcketPlace.security.jwt.JwtProvider;
import com.marcketplace.MarcketPlace.service.AccountService;
import com.marcketplace.MarcketPlace.util.enums.Role;
//import jakarta.mail.MessagingException;
import jakarta.transaction.Transactional;
import org.modelmapper.internal.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.*;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public CustomerRegistration createCustomer(Customers customers) {
        CustomerRegistration customerRegistration = new CustomerRegistration();
        int anoActual = LocalDate.now().getYear();
        String numeracion = obtenerNumeracionAutomatica();

        String email = customers.getEmail();
        customerRegistration.setEmail(email);
        String password = passwordEncoder.encode(customers.getPassword());
        customerRegistration.setPassword(password);
        String name = customers.getName();
        String lastName = customers.getLastName();
        String fullName = name + " " + lastName;
        customerRegistration.setFullName(fullName);
        String verificationCode = RandomString.make(64);
        customerRegistration.setVerificationCode(verificationCode);

        Customers saveCustomer = new Customers(email, password);
        saveCustomer.setEmail(email);
        saveCustomer.setPassword(password);
        saveCustomer.setName(name);
        saveCustomer.setLastName(lastName);
        String customerNumber = anoActual + "-" + numeracion;
        saveCustomer.setRol(Role.USER);
        saveCustomer.setNumber(customerNumber);

        String jwt = jwtProvider.generateToken(saveCustomer);
        customerRegistration.setToken(jwt);

        customerRepository.save(saveCustomer);

        return customerRegistration;
    }

    @Override
    public Optional<Account> findByEmail(String email) {
        try {
            if (email == null || email.isEmpty()) {
                throw new IllegalArgumentException("Email cannot be empty");
            }
            return accountRepository.findByEmail(email);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Error finding account by email: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("Error finding account by email", e);
        }
    }

    @Override
    public Optional<Account> findByTokenPassword(String tokenPassword) {
        try {
            if (tokenPassword == null || tokenPassword.isEmpty()) {
                throw new IllegalArgumentException("Token cannot be empty");
            }
            return accountRepository.findByTokenPassword(tokenPassword);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Error finding Token by email: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("Error finding Token by email", e);
        }
    }

    private String obtenerNumeracionAutomatica() {
        String maxNumber = accountRepository.findByNumber();
        if (maxNumber == null || maxNumber.isEmpty()) {
            return "1";
        } else {
            int separatorIndex = maxNumber.indexOf("-");
            if (separatorIndex != -1 && separatorIndex + 1 < maxNumber.length()) {
                String numeracion = maxNumber.substring(separatorIndex + 1);
                int number = Integer.parseInt(numeracion.trim());
                number++;
                return String.valueOf(number);
            } else {
                return "1";
            }
        }
    }

    @Override
    public Account findByUsernameReturnToken(String username) {
        Account user = accountRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario no existe" + username));
        String jwt = jwtProvider.generateToken(user);
        user.setToken(jwt);
        return user;
    }

    @Override
    public Optional<Customers> findByUuid(String uuid) {
        try {
            if (uuid == null || uuid.isEmpty()) {
                throw new IllegalArgumentException("Email cannot be empty");
            }
            return customerRepository.findByAccountUuid(uuid);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Error finding account by email: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("Error finding account by email", e);
        }
    }
}
