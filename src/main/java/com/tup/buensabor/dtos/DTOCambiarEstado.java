package com.tup.buensabor.dtos;

import com.tup.buensabor.enums.EstadoPedido;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class DTOCambiarEstado {

    private Long idPedido;
    @Enumerated(EnumType.STRING)
    private EstadoPedido estadoPedido;

}
