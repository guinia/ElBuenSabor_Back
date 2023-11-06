package com.tup.buensabor.dtos;
import lombok.Data;

@Data
public class DTOCambiarContraseña {
    private Long id;
    private String contraseniaActual;
    private String contraseniaNueva;

}