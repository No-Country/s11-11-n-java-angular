package com.marcketplace.MarcketPlace.security.jwt;


import com.marcketplace.MarcketPlace.model.Account;
import com.marcketplace.MarcketPlace.security.UserPrincipal;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;

public interface JwtProvider {
    String generateToken(UserPrincipal auth);

    String generateToken(Account account);

    Authentication getAuthentication(HttpServletRequest request);

    boolean isTokenValid(HttpServletRequest request);
}
