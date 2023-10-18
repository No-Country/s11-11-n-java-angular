package com.marcketplace.MarcketPlace.security;

import com.marcketplace.MarcketPlace.model.Account;
import com.marcketplace.MarcketPlace.service.AccountService;
import com.marcketplace.MarcketPlace.util.security.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private AccountService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account user = userService.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario no fue encontrado:" + email));

        Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(user.getRol().name()));

        return UserPrincipal.builder()
                .account(user)
                .id(user.getAccountUuid())
                .usuario(user.getEmail())
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }
}
