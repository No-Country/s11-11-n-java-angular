package com.marcketplace.MarcketPlace.repository;


import com.marcketplace.MarcketPlace.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    Optional<Account> findByEmail(String email);

    Optional<Account> findByTokenPassword(String token);

    @Query(value = "SELECT MAX(a.number) FROM ACCOUNT a WHERE a.entity = 'customer'", nativeQuery = true)
    String findByNumber();
    


}
