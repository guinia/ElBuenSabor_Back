package com.tup.buensabor.security.Auth;

import com.tup.buensabor.entities.Usuario;
import com.tup.buensabor.repositories.UsuarioRepository;
import com.tup.buensabor.security.Jwt.JwtService;
import com.tup.buensabor.security.User.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    public AuthResponse login(LoginRequest request) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

            UserDetails usuario = usuarioRepository.findByUsername(request.getUsername()).orElseThrow();
            String token = jwtService.getToken(usuario);
            return AuthResponse.builder()
                    .token(token)
                    .build();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public AuthResponse register(RegisterRequest request) {
        Usuario usuario = Usuario.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode( request.getPassword()))
                .role(request.getRol()) //revisar, le puse cliente, en el video le ponia de tipo usuario
                .auth0Id(request.getAuth0Id())
                .build();

        usuarioRepository.save(usuario);
        return AuthResponse.builder()
                .token(jwtService.getToken(usuario))
                .build();
    }
}
