package com.tup.buensabor.dtos;
import com.tup.buensabor.enums.Rol;
import lombok.Data;

@Data
public class DTOCambiarDatos {
    private Long id;
    private String email;
    private Rol rol;
    private String nombre;
    private String apellido;
    private String telefono;

}
