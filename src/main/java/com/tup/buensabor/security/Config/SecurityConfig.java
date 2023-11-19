package com.tup.buensabor.security.Config;

import com.tup.buensabor.security.Jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration  //indica q esta clase es de configuracion, va a contener la cadena de filtros
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    //esta clase contiene la cadena de metodos y el security filter

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;

    //para restringir el acceso a las rutas:
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(withDefaults())
                .authorizeHttpRequests(authRequest ->
                        authRequest
                                //Para autenticacion-->
                                .requestMatchers(new AntPathRequestMatcher("/auth/**")).permitAll()
                                //Para H2
                                .requestMatchers(PathRequest.toH2Console()).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/api/v1/articulosinsumos/**")).hasAnyAuthority("ADMINISTRADOR", "COCINERO")
                                .requestMatchers(new AntPathRequestMatcher("/api/v1/articulosmanufacturados/**")).hasAnyAuthority("ADMINISTRADOR", "COCINERO", "DELIVERY", "CAJERO", "CLIENTE")
                                .requestMatchers(new AntPathRequestMatcher("/api/v1/facturas/**")).hasAnyAuthority("ADMINISTRADOR", "DELIVERY", "CAJERO", "CLIENTE")
                                .requestMatchers(new AntPathRequestMatcher("/api/v1/pedidos/**")).hasAnyAuthority("ADMINISTRADOR", "COCINERO", "DELIVERY", "CAJERO", "CLIENTE")
                                .requestMatchers(new AntPathRequestMatcher("/api/v1/recetas/**")).hasAnyAuthority("ADMINISTRADOR", "COCINERO")
                                .requestMatchers(new AntPathRequestMatcher("/api/v1/RubroArticuloInsumo/**")).hasAnyAuthority("ADMINISTRADOR", "COCINERO")
                                .requestMatchers(new AntPathRequestMatcher("/api/v1/RubroArticuloManufacturado/**")).hasAnyAuthority("ADMINISTRADOR", "COCINERO")
                                .requestMatchers(new AntPathRequestMatcher("/api/v1/domicilios/**")).hasAnyAuthority("ADMINISTRADOR", "CLIENTE")
                                .requestMatchers(new AntPathRequestMatcher("/api/v1/usuarios/**")).hasAnyAuthority("CLIENTE", "ADMINISTRADOR","COCINERO", "DELIVERY", "CAJERO")
                                .requestMatchers(new AntPathRequestMatcher("/api/v1/notascredito/**")).hasAnyAuthority("ADMINISTRADOR", "CAJERO")
                                .requestMatchers(new AntPathRequestMatcher("/api/v1/personas/**")).hasAnyAuthority("CLIENTE", "ADMINISTRADOR","COCINERO", "DELIVERY", "CAJERO")
                                .requestMatchers(new AntPathRequestMatcher("/api/v1/unidadmedida/**")).hasAnyAuthority("ADMINISTRADOR","COCINERO")

                                //ver si esto se saca
                                //.anyRequest().authenticated()
                )
                .headers((headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))) //H2
                .sessionManagement(sessionManager ->
                        sessionManager
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        )
                .authenticationProvider(authProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilter(new CorsFilter())
                .build();
    }
}