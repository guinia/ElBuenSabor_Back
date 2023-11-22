package com.tup.buensabor.security.Auth;

import com.tup.buensabor.security.User.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    String username;
    String password;
    String apellido;
    String nombre;
    String telefono;
    String email;
    Role rol;


}
