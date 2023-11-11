package com.tup.buensabor.Security.Config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration  //indica q esta clase es de configuracion
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    //esta clase contiene la cadena de metodos y el security filter

    //para restringir el acceso a las rutas:
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(csrf ->
                        csrf
                        .disable()
                        )
                .authorizeHttpRequests(authRequest ->
                        authRequest
                                .requestMatchers("/auth/**").permitAll()
                                .anyRequest().authenticated()
                        )
                .formLogin(withDefaults())
                .build();
    }
}
