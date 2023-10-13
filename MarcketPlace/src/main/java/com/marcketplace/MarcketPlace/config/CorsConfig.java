package com.marcketplace.MarcketPlace.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Clase de configuracion de Intercambio de recursos de origen cruzado (CORS)
 * @Autor Damian Canteros
 */
@Configuration
public class CorsConfig {

    /**
     * Metodo para configurar las urls permitidas por Cors para solicitudes de aplicaciones de ip externas a la red del servidor
     * @return cors configuracion de url y metodos permitidos
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                .allowedOrigins("https://localhost:4200/")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
};
}
}
