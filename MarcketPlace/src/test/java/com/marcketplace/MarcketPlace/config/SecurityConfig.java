package com.marcketplace.MarcketPlace.config;

import com.marcketplace.MarcketPlace.security.CustomUserDetailsService;
import com.marcketplace.MarcketPlace.security.jwt.JwtAuthorizationFilter;
import com.marcketplace.MarcketPlace.util.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Clase de configuracion de autenticacion y autorizacion de paths para roles de usuarios
 * @Autor
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    private final JwtAuthorizationFilter jwtAuthorizationFilter;
    /**
     * Metodo para configurar la seguridad de la aplicacion web, autorizaciones, tipo de sesion, proveedor de autenticacion y filtros
     * @param httpSecurity configuracion de seguridad http
     * @param authenticationManager administrador de autenticacion
     * @return securityFilterChain configuracion de seguridad http
     * @throws Exception mensaje de excepcion si la configuracion falla
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity, AuthenticationManager authenticationManager) throws Exception{

        return httpSecurity
            .csrf(AbstractHttpConfigurer::disable)
            .cors(Customizer.withDefaults())
            .authenticationManager(authenticationManager)
            .authorizeHttpRequests(auth ->
                auth.requestMatchers(HttpMethod.GET, "/customer/**").hasRole(Role.USER.name())
            )
            .authorizeHttpRequests(
                    auth -> auth.anyRequest().authenticated()
            )
            .sessionManagement(session->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

            .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
            .build();

    }
}
